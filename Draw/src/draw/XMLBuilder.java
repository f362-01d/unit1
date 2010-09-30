package draw;

import java.util.*;
import java.io.*;

public class XMLBuilder extends FileBuilder {
	
	public XMLBuilder() {
		super();
	}
	
	public void save(ArrayList<DrawingPrimitive> s, String n) {
		BufferedWriter saver = null;
		
		try {
			saver = new BufferedWriter(new FileWriter(n + ".xml"));
		} catch (IOException e) {
			System.err.println("Could not write file.");
		}
		
		ArrayList<String> fileLines;
		XMLFormat format = new XMLFormat(s);
		fileLines = format.makeStringList();
		ListIterator<String> lineIter = fileLines.listIterator();
		try {
			while (lineIter.hasNext()) {
				String line = lineIter.next();
				saver.write(line);
				saver.newLine();
			}
			saver.close();
		} catch (IOException ex) {
			System.err.println("Error writing file.");
		}
	}
}
