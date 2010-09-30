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
			double minX = p1.getX() < p2.getX() ? p1.getX() : p2.getX();
			double minY = p1.getY() < p2.getY() ? p1.getY() : p2.getY();
			double maxX = p1.getX() > p2.getX() ? p1.getX() : p2.getX();
			double maxY = p1.getY() > p2.getY() ? p1.getY() : p2.getY();
			p1 = new Point((int)minX, (int)minY);
			p2 = new Point((int)maxX, (int)maxY);
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

	@Override
	public Boolean contains(Point p) {
		int x = (int)p.getX();
		int y = (int)p.getY();
		int x1 = (int)topLeft.getX();
		int y1 = (int)topLeft.getY();
		int w = (int)size.getWidth();
		int h = (int)size.getHeight();
		if(x > x1 && y > y1 && x < x1 + w && y < y1 + h)
			return true;
		else
			return false;
	}

}
