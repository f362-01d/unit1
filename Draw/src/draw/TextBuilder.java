package draw;

import java.util.*;
import java.io.*;

public class TextBuilder extends FileBuilder {
	
	public void save(ArrayList<DrawingPrimitive> a, String n) {
		
		try {
			FileWriter saver = new FileWriter(n);
		} catch (IOException e) {
			System.err.println("Could not write file.");
		}
		
		ArrayList<String> fileLines;
		TextFormat format = new TextFormat(a);
		fileLines = format.makeShapeList();
		ListIterator<String> lineIter = fileLines.listIterator();
		try {
			while (lineIter.hasNext()) {
				String line = lineIter.next();
				
			}
		} catch (IOException ex) {
			System.err.println("Error writing file.");
		}
	}
	
	public ArrayList<DrawingPrimitive> load(String f) {
		return null;
	}
}