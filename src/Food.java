import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public abstract class Food extends JComponent implements Drawable {
	public int age=0;
	public abstract void consumed();
	public abstract void grow();
	public abstract void draw(Graphics g);
}
