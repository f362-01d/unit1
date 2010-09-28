package draw.primitives;

import java.awt.*;
import java.awt.geom.*;

import draw.DrawingPrimitive;

public class Rectangle extends DrawingPrimitive {

	Point topLeft;
	Dimension size;
	
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
