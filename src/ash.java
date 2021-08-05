import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class ash extends ghost{
	
		int pivotx;
		int pivoty;
		Image image1;
		int xcenter;
		int ycenter;
		int xpos;
		int ypos;
		public boolean isleft;
	public ash()	{
		takeImages();
		decideplace();
		Random rand=new Random();
		if(rand.nextBoolean())isleft=true;
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
		
		  g.drawImage(image1, xcenter,ycenter , null);
	}
	
	private void takeImages() {
		 
	    File file1=new File("src/ghost1.png")  ;
        image1 = null;
             
        try
        {
            image1 =  ImageIO.read(file1).getScaledInstance(80, 80, Image.SCALE_DEFAULT);  
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
		if(isleft) {
			xcenter -= 1;
			if (xcenter <0) {
				isleft=false;
		}
		}else {
			xcenter+=1;
			if (xcenter >910) {
				isleft=true;
		}
		
		// TODO Auto-generated method stub
		
	}
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
