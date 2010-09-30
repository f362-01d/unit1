package draw;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import draw.operations.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import draw.operations.Create;
import draw.operations.Move;
import draw.primitives.Line;
import draw.primitives.Rectangle;

public class Draw extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Draw()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Graphics2D g = (Graphics2D) getGraphics();
		setVisible(true);
		setSize(new Dimension(500, 300));
		
		add(new JPanel(){
			Canvas c = new Canvas();
			
			{
				Create m = new Create(this, c, new Rectangle(null, null).getClass());
				addMouseListener(m);
				addMouseMotionListener(m);
				c.getElements().add(new Rectangle(new Point(5, 5), new Point(200, 200)));
				c.getElements().add(new Line(new Point(20,20), new Point(80,40)));
			}
			
			public void paintComponent(Graphics g)
			{
				g.clearRect(0, 0, getWidth(), getHeight());
				ArrayList<DrawingPrimitive> elements = c.getElements();
				for(int i=0;i<elements.size();i++)
					elements.get(i).draw((Graphics2D)g);
			}
		});
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Draw();
	}
}