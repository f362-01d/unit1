package draw;

import java.awt.*;

public abstract class DrawingPrimitive {
	
	private Color color;
	
	public abstract void draw(Graphics2D g);
	
	public abstract Point getPosition();
	public abstract void setPosition(Point p);
	
	public abstract Dimension getSize();
	public abstract void setSize(Dimension d);
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}

}
