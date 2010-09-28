package draw;

import java.util.*;

public abstract class FileBuilder {
	
	/*
	 * The constructor.
	 */
	
	public FileBuilder() {
	}
	
	/*
	 * This class saves the program depending upon the format
	 * requested.
	 */
	
	public abstract void save(ArrayList<DrawingPrimitive> p);
	
}
