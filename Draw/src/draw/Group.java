package draw;

import java.util.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Dimension;

public class Group extends DrawingPrimitive {
	
	private ArrayList<DrawingPrimitive> elements = new ArrayList<DrawingPrimitive>();
	
	public Group(Point f, Point l) {
		super(f,l);
	}
	
	public ArrayList<DrawingPrimitive> getElements()
	{
		return elements;
	}
	
	public void Draw(Graphics2D d) {}
	
	public Color getColor() {
		return null;
	}
	
	public Point getPosition() {
		return null;
	}
	
	public Dimension getSize() {
		return null;
	}
	
	public void setColor(Color c) {}
	
	public void setPosition(Point p) {}
	
	public void setSize(Dimension d) {}
	
	public void draw(Graphics2D g) {}

	@Override
	public Boolean contains(Point p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DrawingPrimitive clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
