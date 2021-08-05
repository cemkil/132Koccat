import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;

public class Poison extends Food  {
	
	Random rand = new Random();
	int sayac;
	int pivotx;
	int pivoty;
	int xcenter;
	int ycenter;
	public static int hwidth=20;
	int width = hwidth * 2;
	int ypos;
	int xpos;
	int age=1;
	Color color;
	Timer myTimer=new Timer();
	TimerTask task=new TimerTask() {
			@Override
			public void run() {
				sayac++;
				if(sayac%100==0) {
				grow();
				doAction();
				}
				if(sayac%2==0) {
				consumed();	
				}
				repaint();
			}
		};
		
	public Poison() {
		color=Color.yellow;
		decideplace();
		this.setOpaque(false);
		this.setVisible(true);
		myTimer.scheduleAtFixedRate(task, 100, 100);
	}

	private void decideplace() {
		// TODO Auto-generated method stub
	
		  
		   xpos=0;
		   ypos=0;
		 
		  //shift x and y by the radius of the circle in order to correctly center it
		  
			  while(matrix[ypos][xpos]) {
				  xpos=rand.nextInt(11);
				  ypos=rand.nextInt(11);
				 
			  }
			  matrix[ypos][xpos]=true;
	}

	public void draw(Graphics g) {
				xcenter=xpos*90+(90-width)/2;
				ycenter=ypos*90+(90-width)/2;
				pivotx=xcenter+hwidth/2;
				pivoty=ycenter+hwidth/2;
			  g.setColor(color);
			  g.fillRect(xcenter, ycenter, width , width); 
			  
		  }
		
	@Override
	public void consumed() {
		if(Math.pow(pivotx-Koccat.pivotx,2)+Math.pow(pivoty-Koccat.pivoty,2)<3600) {
			if(!GameStart.isFinished) {
			Koccat.score = Koccat.score - age*10;
			 System.out.println("poison");
			 System.out.println(age);}
			if(Koccat.score<=0) {
				GameStart.isFinished=true;
			}
			
			
		}
		
	}
	@Override
	public void grow() {
		age++;
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doAction();
		draw(g);
		
	}

	@Override
	public void doAction() {
		
		if(age>=10) {
			color=Color.red;
		}
		if(age<10) {
			color=Color.YELLOW;
		}
		
	}



}
