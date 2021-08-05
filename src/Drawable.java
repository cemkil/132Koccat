import java.awt.Graphics;

import javax.tools.JavaCompiler;

public interface Drawable{
	public static boolean[][] matrix=new boolean[11][11];
	public void draw(Graphics g);
	public void doAction();
}
