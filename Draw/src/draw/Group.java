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
		setSelected(false);
	}
	
	public Color getColor() {
		return null;
	}
	
	public Point getPosition() {
		return primitives.get(0).getPosition();
	}
	
	public Dimension getSize() {
		return null;
	}
	
	public void setColor(Color c) 
	{
		for(int i=0;i<primitives.size();i++)
		{
			primitives.get(i).setColor(c);
		}
	}
	
	public void setPosition(Point p) 
	{
		Point lastPosition = getPosition();
		int dx = (int)(p.getX() - lastPosition.getX());
		int dy = (int)(p.getY() - lastPosition.getY());
		for(int i=0;i<primitives.size();i++)
		{
			DrawingPrimitive primitive = primitives.get(i);
			Point newPos = new Point((int)primitive.getPosition().getX()+dx, (int)primitive.getPosition().getY()+dy);
			primitive.setPosition(newPos);
		}
	}
	
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
		Group newGroup = new Group(null,null);
		for(int i=0;i<primitives.size();i++)
		{
			newGroup.add(primitives.get(i).clone());	
		}
		return newGroup;
	}
}
