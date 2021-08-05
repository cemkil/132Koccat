import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class dolly extends ghost{
	int pivotx;
	int pivoty;
	Image image2;
	int xcenter;
	int ycenter;
	int xpos;
	int ypos;
	boolean isdown;
	public dolly()	{
		takeImages();
		decideplace();
		Random rand=new Random();
		if(rand.nextBoolean())isdown=true;
		this.setOpaque(false);
		this.setVisible(true);
	}
	public void decideplace() {
		Random rand = new Random();
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
	
	  g.drawImage(image2, xcenter,ycenter , null);
}
	public void takeImages() {
	    File file2=new File("src/ghost2.png")  ;
        image2 = null;
        try
        {
            image2 =  ImageIO.read(file2).getScaledInstance(80, 80, Image.SCALE_DEFAULT);
   
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
		
		if(isdown) {
			ycenter += 1;
			if (ycenter >910) {
				isdown=false;
		}
		}else {
			ycenter-=1;
			if (ycenter <0) {
				isdown=true;
		}
		
		// TODO Auto-generated method stub
		
	}
	
		// TODO Auto-generated method stub
		pivotx=xcenter+40;
		pivoty=ycenter+40;
		detectCollision();
	}
	public void detectCollision() {
		if(Math.pow(pivotx-Koccat.pivotx,2)+Math.pow(pivoty-Koccat.pivoty,2)<6000) {
			GameStart.isFinished=true;
		}
		
	}
}
