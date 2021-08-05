import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;

public class Fruit extends Food {
	int sayac=0;
	int pivotx;
	int pivoty;
	int xcenter;
	int ycenter;
	public static int radius=20;
	int ypos;
	int xpos;
	int diameter=2*radius;
	int age=1;
	Random rand = new Random();
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
				
				consumed();	
				repaint();

			}
		};
		
	public Fruit() {
		color=Color.blue;
		decideplace();
		this.setOpaque(false);
		this.setVisible(true);
		myTimer.scheduleAtFixedRate(task, 100, 100);
	}

	private void decideplace() {
		// TODO Auto-generated method stub
	   diameter = radius * 2;
		  
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
			xcenter=  xpos*90+(90-diameter)/2;
			ycenter=ypos*90+(90-diameter)/2;
			pivotx=xcenter+radius;
			pivoty=ycenter+radius;
			g.setColor(color);
			g.fillOval(xcenter, ycenter, diameter , diameter); 
			  
		  }
		
	@Override
	public void consumed() {
		if(Math.pow(pivotx-Koccat.pivotx,2)+Math.pow(pivoty-Koccat.pivoty,2)<3600) {
			Koccat.score = Koccat.score + age*5;
			age=1;
			  xpos=rand.nextInt(11);
			  ypos=rand.nextInt(11);
		      System.out.println("fruit");
		      System.out.println(age);
		}
		
	}
	@Override
	public void grow() {
		age+=1;
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doAction();
		draw(g);
		
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		if(age>=5) {
			color=Color.green;
		}if(age<5) {
			color=Color.blue;
		}if(age>10) {
			age=10;
		}

	}


}
