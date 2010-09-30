package draw;

import java.util.*;
import java.io.*;

public class TextBuilder extends FileBuilder {
	
	public TextBuilder() {
		super();
	}
	
	public void save(ArrayList<DrawingPrimitive> a, String n) {
		
		BufferedWriter saver = null;
		
		try {
			saver = new BufferedWriter(new FileWriter(n + ".txt"));
		} catch (IOException e) {
			System.err.println("Could not write file.");
		}
		
		ArrayList<String> fileLines;
		TextFormat format = new TextFormat(a);
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
	
	public ArrayList<DrawingPrimitive> load(String f) {
		BufferedReader reader = null;
		ArrayList<String> lines = new ArrayList<String>();
		TextFormat shapeFormat = new TextFormat(
						new ArrayList<DrawingPrimitive>());
		try {
			reader = new BufferedReader(new FileReader(f));
			String line = new String();
			line = reader.readLine();
			while (!line.equals(null)) {
				lines.add(line);
			}
			reader.close();
		} catch(IOException e) {
			System.err.println("Error loading file.");
		}
		return shapeFormat.makeShapes(lines);
	}
}