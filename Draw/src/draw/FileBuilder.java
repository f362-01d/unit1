package draw;

import java.util.*;
import java.io.*;

public abstract class FileBuilder {
	
	/*
	 * The constructor.
	 */
	
	public FileBuilder() {
	}
	
	/*
	 * This class saves the program to a file of the given
	 * string depending upon the format requested.
	 */
	
	public abstract void save(ArrayList<DrawingPrimitive> p, 
								String n) throws IOException;
}
