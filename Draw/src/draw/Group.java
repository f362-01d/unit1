package draw;

import java.util.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Dimension;

public class Group extends DrawingPrimitive {
	
	private ArrayList<DrawingPrimitive> primitives = new ArrayList<DrawingPrimitive>();
	
	public Group(Point f, Point l) {
		super(f,l);
	}
	
	public ArrayList<DrawingPrimitive> getPrimitives()
	{
		return primitives;
	}
	
	public void add(DrawingPrimitive primitive)
	{
		primitives.add(primitive);
	}
	
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
	
	public void setSelected(Boolean selected)
	{
		super.setSelected(selected);
		for(int i=0;i<primitives.size();i++)
		{
			primitives.get(i).setSelected(isSelected());
		}
	}
	
	public void draw(Graphics2D g) 
	{
		for(int i=0;i<primitives.size();i++)
		{
			primitives.get(i).draw(g);
		}
	}

	@Override
	public Boolean contains(Point p) {
		for(int i=0;i<primitives.size();i++)
		{
			if(primitives.get(i).contains(p))
				return true;
		}
		return false;
	}

	@Override
	public DrawingPrimitive clone() {
		// TODO Auto-generated method stub
		return null;
	}
}
