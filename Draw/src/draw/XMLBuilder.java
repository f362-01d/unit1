package draw;

import java.util.*;
import java.io.*;
import java.awt.Point;
import draw.primitives.*;

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
	
	public static void main(String[] args) {
		ArrayList<DrawingPrimitive> testList = new ArrayList<DrawingPrimitive>();
		testList.add(new Line(new Point(100,155), new Point(200,185)));
		testList.add(new Rectangle(new Point(25,25),new Point(50,50)));
		XMLBuilder builder = new XMLBuilder();
		builder.save(testList, "test");
	}
}
