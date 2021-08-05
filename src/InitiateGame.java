import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InitiateGame {
	public static int numberPoison;
	public static int numberFruit;
	public static int numberGhost;
	
	
	public static void InitializeInterface() {
		JFrame frame=new JFrame("welcome to koccat");
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setSize(300,300);
		
		JLabel label1=new JLabel("Enter the number of fruit");
		label1.setSize(150,100);
		label1.setLocation(25,27);
		panel.add(label1);
		
		JTextField alan1=new JTextField();
		alan1.setSize(100, 50);
		alan1.setLocation(220,50);
		panel.add(alan1);
		
		JLabel label2=new JLabel("Enter the number of poison");
		label2.setSize(190,100);
		label2.setLocation(25,127);
		panel.add(label2);
		
		JTextField alan2=new JTextField();
		alan2.setSize(100, 50);
		alan2.setLocation(220,150);
		panel.add(alan2);
		
		JLabel label3=new JLabel("Enter the number of ghosts");
		label3.setSize(190,100);
		label3.setLocation(25,227);
		panel.add(label3);
		
		JTextField alan3=new JTextField();
		alan3.setSize(100, 50);
		alan3.setLocation(220,250);
		panel.add(alan3);
		
		JLabel label4=new JLabel("click!!");
		label4.setSize(200, 20);
		label4.setLocation(200,460);
		panel.add(label4);
		
		
		ImageIcon ikon=new ImageIcon("src/image_down.png");
		Image img = (ikon.getImage()).getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ikon =new ImageIcon(img);
		JButton buton=new JButton(ikon);
		buton.setBackground(Color.white);
		buton.setSize(100,100);
		buton.setLocation(170,350);
		buton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0)  {
				if(Integer.parseInt(alan1.getText())<=0||Integer.parseInt(alan2.getText())<=0||Integer.parseInt(alan3.getText())<=0) {
					try{throw new Exception();
					}catch(Exception e) {
						throw new IllegalArgumentException();
					}
				}else {
					numberFruit=Integer.parseInt(alan1.getText());
					numberPoison=Integer.parseInt(alan2.getText());
					numberGhost=Integer.parseInt(alan3.getText());
					frame.setVisible(false);
					
					Drawable.matrix[5][5]=true;
					
					
					GameStart frame1 = new GameStart();

				        frame1.setTitle("kucat");
				        frame1.setSize(1080,1100);
				    	frame1.setResizable(false);
				        frame1.setLocationRelativeTo(null);
				        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        frame1.setVisible(true);
					
				}
				
			}
			
			
		});
		
		
		
		panel.add(buton);
		panel.setBackground(Color.cyan);
		frame.setLocation(600, 200);
		frame.setContentPane(panel);
		frame.setSize(500, 570);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}
}
