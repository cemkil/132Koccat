
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class KuBoard extends JPanel{
	
	public void draw(Graphics g) {
		for(int i=0;i<12;i++) {
			g.drawLine(i*90, 0, i*90, 990);
			g.drawLine(0,i*90, 990, i*90);
		}
		
	}
	
	
	
	public void paintComponent(Graphics g) {
		draw(g);

	}


}
