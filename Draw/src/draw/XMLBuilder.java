package draw;

import java.util.*;
import java.io.*;
import java.awt.Point;
import draw.primitives.*;

public class XMLBuilder extends FileBuilder {
	
	public XMLBuilder() {
		super();
	}
	
	public void save(ArrayList<DrawingPrimitive> s, String n) 
									throws IOException{
		BufferedWriter saver = null;
		
		try {
			saver = new BufferedWriter(new FileWriter(n));
		} catch (IOException e) {
			throw e;
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
			throw ex;
		}
	}
	
	public static void main(String[] args) {
		ArrayList<DrawingPrimitive> testList = new ArrayList<DrawingPrimitive>();
		testList.add(new Line(new Point(100,155), new Point(200,185)));
		testList.add(new Rectangle(new Point(25,25),new Point(50,50)));
		XMLBuilder builder = new XMLBuilder();
		try {
			builder.save(testList, "test.xml");
		} catch (IOException e) {
			System.err.println("Error saving XML file.");
		}
	}
}
