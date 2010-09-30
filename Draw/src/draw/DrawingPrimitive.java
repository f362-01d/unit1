package draw;

import java.awt.*;

public abstract class DrawingPrimitive {
	
	private static final Color DEFAULT_COLOR = Color.RED;
	
	private Color color;
	private Boolean selected = false;
	
	public DrawingPrimitive(Point p1, Point p2) {
		this.color = DEFAULT_COLOR;
	}
	
	public abstract void draw(Graphics2D g);
	
	public abstract Point getPosition();
	public abstract void setPosition(Point p);
	
	public abstract Dimension getSize();
	public abstract void setSize(Dimension d);
	
	public abstract Boolean contains(Point p);
	
	public Color getColor()
	{
		return color;
	}
	
	public void setColor(Color color)
	{
		this.color = color;
	}
	
	public Boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(Boolean selected)
	{
		this.selected = selected;
	}

}
