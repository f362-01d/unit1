package draw;

import java.util.*;

public class Canvas extends Observable {
	
	private ArrayList<DrawingPrimitive> primitives = new ArrayList<DrawingPrimitive>();
	
	public ArrayList<DrawingPrimitive> getElements()
	{
		return primitives;
	}
	
	public ArrayList<DrawingPrimitive> getSelection()
	{
		return null;
	}

}
