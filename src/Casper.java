import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import java.lang.Math;
public class Casper extends ghost{
	
	int pivotx;
	int pivoty;
	Image image3;
	int xcenter;
	int ycenter;
	int xpos;
	int ypos;
	int a;
	
	Random rand;
	public Casper()	{
		takeImages();
		decideplace();
		this.setOpaque(false);
		this.setVisible(true);
		rand=new Random();
	}
	public void decideplace() {
		  rand = new Random();
		  xpos = rand.nextInt(11);
		  ypos=rand.nextInt(11);
		  
		  while(matrix[ypos][xpos]) {
			  xpos=rand.nextInt(11);
			  ypos=rand.nextInt(11);
			 
		  }
		  matrix[ypos][xpos]=true;
		  xcenter=xpos*90+5;
		  ycenter=ypos*90+5;
		  pivotx=xcenter+40;
		  pivoty=ycenter+40;
	}
	
public void draw(Graphics g) {
	
	  g.drawImage(image3, xcenter,ycenter , null);
}
	
	private void takeImages() {
	
	    File file3=new File("src/ghost3.png")  ;
	   
         image3 = null;
        
        try
        {
            
            image3 =  ImageIO.read(file3).getScaledInstance(80, 80, Image.SCALE_DEFAULT); 
           
      
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doAction();
		draw(g);	
	}
	@Override
	public void doAction() {
		changeDirection();
		  pivotx=xcenter+40;
		  pivoty=ycenter+40;
		  detectCollision();
	}
	public void changeDirection() {
		a=rand.nextInt(4);
		switch(a) {
		case 0: xcenter+=3;
		if(xcenter>910) xcenter-=1;break;
		
		case 1: xcenter-=3;
		if(xcenter<0) xcenter+=1;break;
		
		case 2: ycenter+=3;
		if(ycenter>910) ycenter-=1;break;
		
		case 3: ycenter-=3;
		if(ycenter<0) ycenter+=1;break;
		}
		
	}
	public void detectCollision() {
		if(Math.pow(pivotx-Koccat.pivotx,2)+Math.pow(pivoty-Koccat.pivoty,2)<6000) {
			GameStart.isFinished=true;
		}
		
	}
}
