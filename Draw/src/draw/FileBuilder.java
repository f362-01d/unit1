package draw;

import java.util.*;

public abstract class FileBuilder {
	
	/*
	 * This class saves the program depending upon the format
	 * requested.
	 */
	
	public abstract void save(LinkedList<DrawingPrimitive> p);
	
}
