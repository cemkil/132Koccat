import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Koccat extends JPanel implements Drawable,ActionListener,KeyListener{
	Image[] imaj;
	int posx;
	int posy;
	Image whone;
	int velx=0;
	int vely=0;
	static int pivotx;
	static int pivoty;
	public static int score;
	public void draw(Graphics g) {
			
		
		g.drawImage(whone, posx, posy, null);
		
			  
		  }
	public Koccat() {
		score=0;
		posx=455;
		posy=455;
		pivotx=posx+40;
		pivoty=posy+40;
		takeImages();
		whone=imaj[0];
		this.setOpaque(false);
		this.setVisible(true);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		repaint();
	}
	public void keyPressed(KeyEvent e) {
		int c=e.getKeyCode();
		
	
	if(c== KeyEvent.VK_LEFT) {
		whone=imaj[1];
		velx=-3;
		vely=0;
	}
	if(c== KeyEvent.VK_UP) {
		whone=imaj[3];
		velx=0;
		vely=-3;
	}
	if(c== KeyEvent.VK_RIGHT) {
		whone=imaj[2];
		velx=3;
		vely=0;
	}
	if(c== KeyEvent.VK_DOWN) {
		whone=imaj[0];
		velx=0;
		vely=3;
	}
	
	}
	private void takeImages() {
 
	    File file1=new File("src/image_down.png")  ;
	    File file2=new File("src/image_right.png")  ;
	    File file3=new File("src/image_left.png")  ;
	    File file4=new File("src/image_up.png")  ;
        Image image1 = null;
        Image image2 = null;
        Image image3 = null;
        Image image4 = null;
        imaj=new Image[4]; 
        try
        {
            image1 =  ImageIO.read(file1).getScaledInstance(80, 80, Image.SCALE_DEFAULT); imaj[0]=image1;
            image2 =  ImageIO.read(file2).getScaledInstance(80, 80, Image.SCALE_DEFAULT); imaj[1]=image2;
            image3 =  ImageIO.read(file3).getScaledInstance(80, 80, Image.SCALE_DEFAULT); imaj[2]=image3;
            image4 =  ImageIO.read(file4).getScaledInstance(80, 80, Image.SCALE_DEFAULT); imaj[3]=image4;
             
            
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
			if(posx<0) {
				velx=0;
				posx=0;
			}
			if(posx>910) {
				velx=0;
				posx=910;
			}
			if(posy<0) {
				vely=0;
				posy=0;
			}
			if(posy>910) {
				vely=0;
				posy=910;
			}
			posx+=velx;
		    posy+=vely;
		    pivotx=posx+40;
			pivoty=posy+40;

		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			velx=0;
			vely=0;
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	

}
