package draw.primitives;

import java.awt.*;
import java.awt.geom.*;

import java.math.*;

import draw.DrawingPrimitive;

public class Rectangle extends DrawingPrimitive {

	Point topLeft;
	Dimension size;
	
	public Rectangle(Point p1, Point p2)
	{
		super(p1, p2);
		if(p1 != null && p2 != null)
		{
			this.setPosition(p1);
			this.setSize(new Dimension((int)Math.abs(p2.getX()-p1.getX()), (int)Math.abs(p2.getY()-p1.getY())));
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		g.setColor(this.getColor());
		g.draw(new Rectangle2D.Double(topLeft.getX(), topLeft.getY(), size.getWidth(), size.getHeight()));
	}

	@Override
	public Point getPosition() {
		return topLeft;
	}

	@Override
	public Dimension getSize() {
		return size;
	}

	@Override
	public void setPosition(Point p) {
		topLeft = p;
	}

	@Override
	public void setSize(Dimension d) {
		size = d;
	}

}
