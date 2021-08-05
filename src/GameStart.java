import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameStart extends JFrame{
	ArrayList<ghost> gh;
	ArrayList<Fruit> fc;
	ArrayList<Poison> pc;
	KuBoard board=new KuBoard();
	Koccat cat=new Koccat();
	static boolean isFinished=false;
	boolean isReallyFinished=false;
	public GameStart() {
		JLayeredPane panel=new JLayeredPane();
		panel.setPreferredSize(new Dimension(1020,1040));
		ghostcreator(InitiateGame.numberGhost);
		fruitcreator(InitiateGame.numberFruit);
		poisoncreator(InitiateGame.numberPoison);
		int g=0;
		int f=0;
		int p=4;
		board.setBounds(0,0,1020,1040);
		cat.setBounds(0,0,1020,1040);
		panel.add(board,new Integer(0));
		
		for(Poison x:pc) {
			x.setBounds(0, 0, 1020, 1040);
			panel.add(x, new Integer(p));
			p++;
		}
		f=p+1;
			
		for(Fruit m:fc) {
			m.setBounds(0, 0, 1020, 1040);
			panel.add(m, new Integer(f));
			f++;
		}
		g=f+1;
		for(ghost a:gh) {
			a.setBounds(0, 0, 1020, 1040);
			panel.add(a, new Integer(g));
			g++;
		}
		panel.add(cat,new Integer(g+1));
		this.setContentPane(panel);
		
		  Timer timer = new Timer(10,new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	           	for(ghost a:gh) {
	    			a.repaint();
	    		}
	           	if(isFinished&!isReallyFinished) {
	           		finalizeGame();
	           		isFinished=false;
	           		isReallyFinished=true;
	           	}
	             }
	         } );
	        timer.start();
		
	}
	private void poisoncreator(int numberPoison) {
		// TODO Auto-generated method stub
		pc=new ArrayList<Poison>();
		for(int i=0;i<numberPoison;i++) {
			pc.add(new Poison());
		}
	}
	private void fruitcreator(int numberFruit) {
		// TODO Auto-generated method stub
		fc=new ArrayList<Fruit>();
		for(int i=0;i<numberFruit;i++) {
			fc.add(new Fruit());
		}
	}
	public void paintComponent(Graphics g) {
		
		ghostcreator(InitiateGame.numberGhost);
	
		
	
	}
	public void ghostcreator(int m) {
		gh=new ArrayList<ghost>();
		int mode=0;
		for(int i=0;i<m;i++) {
			if(mode==0) {
				gh.add(new ash());
				
				
			}else if(mode==1) {
				gh.add(new dolly());
			}else {
				gh.add(new Casper());
			}
			mode++;
			if(mode==3)mode=0;
		}
	}
	public void finalizeGame() {
		this.setVisible(false);
		JFrame frame3=new JFrame();
		JPanel panel3=new JPanel();
		panel3.setSize(500,500);
		panel3.setLayout(new BorderLayout());
		JLabel label3=new JLabel("GAME OVER!! \n KOCCAT SCORE: " +Koccat.score);
		
		label3.setHorizontalAlignment(0);
		label3.setSize(200,200);
		panel3.add(label3);
		frame3.setSize(500,500);
		frame3.setContentPane(panel3);
		frame3.setVisible(true);
	}
}
