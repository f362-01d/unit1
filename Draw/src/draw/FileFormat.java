package draw;

import java.util.*;

public abstract class FileFormat {
	
	// The variables for a specific Format. shapes is the
	// list of DrawingPrimitives that are used in the Draw
	// program. shapeLines are the lines of converted 
	// DrawingPrimitives needed to save or load a file.
	
	protected LinkedList<DrawingPrimitive> shapes = null;
	protected LinkedList<String> shapeLines = null;
	 
	/*
	 * This method stores the shapes
	 * from the Draw program to be saved or loaded.
	 * 
	 */
	
	public abstract void store(LinkedList<DrawingPrimitive> 
								shapes);
	
	/*
	 * This method takes the list of shapes and creates
	 * a list of Strings in the format of either a line
	 * for Text or a line for XML.
	 */
	
	public abstract LinkedList<String> makeShapeList();
	
	/*
	 * This method reads in the lines of a specific file type
	 * and converts it into a list of DrawingPrimitives for
	 * Draw to read in.
	 */
	
	public abstract LinkedList<DrawingPrimitive> makeShapes();
}
