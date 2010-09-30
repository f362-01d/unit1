package draw.primitives;

import java.awt.*;
import java.awt.geom.*;

import draw.DrawingPrimitive;

public class Line extends DrawingPrimitive {

	Point start;
	Point end;
	
	public Line(Point start, Point end) {
		super(start, end);
		this.start = start;
		this.end = end;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(this.getColor());
		g.draw(new Line2D.Double(start, end));
	}

	@Override
	public Point getPosition() {
		return start;
	}

	@Override
	public Dimension getSize() {
		return new Dimension(abs(start.getX()-end.getX()), abs(start.getY() - end.getY()));
	}

	private static int abs(double d) {
		return (int)(d < 0 ? -d : d);
	}

	@Override
	public void setPosition(Point p) {
		end.translate((int)(p.getX()-start.getX()), (int)(p.getY()-start.getY()));
		start = p;	
	}

	@Override
	//TODO: discuss options for setting line "size"
	public void setSize(Dimension d) {
		if(start.getX() < end.getX())
			end.setLocation(start.getX() + d.getWidth(), end.getY());
		else
			start.setLocation(end.getX() + d.getWidth(), start.getY());
		
		if(start.getY() < end.getY())
			end.setLocation(end.getX(), start.getY() + d.getHeight());
		else
			start.setLocation(start.getX(), end.getY() + d.getHeight());
	}

}
