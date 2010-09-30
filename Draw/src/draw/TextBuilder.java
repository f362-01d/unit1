package draw;

import java.util.*;
import java.io.*;

public class TextBuilder extends FileBuilder {
	
	public TextBuilder() {
		super();
	}
	
	public void save(ArrayList<DrawingPrimitive> a, String n) 
										throws IOException{
		
		BufferedWriter saver = null;
		
		try {
			saver = new BufferedWriter(new FileWriter(n));
		} catch (IOException e) {
			throw e;
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
			throw ex;
		}
	}
	
	public ArrayList<DrawingPrimitive> load(String f) 
									throws IOException {
		BufferedReader reader = null;
		ArrayList<String> lines = new ArrayList<String>();
		TextFormat shapeFormat = new TextFormat(
						new ArrayList<DrawingPrimitive>());
		try {
			reader = new BufferedReader(new FileReader(f));
			String line = new String();
			while (reader.ready()) {
				line = reader.readLine();
				lines.add(line);
			}
			reader.close();
		} catch(IOException e) {
			throw e;
		} catch(NumberFormatException ex) {
			System.err.println("Error loading file.");
		}
		return shapeFormat.makeShapes(lines);
	}
	
	public static void main(String[] args) {
		ArrayList<DrawingPrimitive> testList = 
			  new ArrayList<DrawingPrimitive>();
		TextBuilder builder = new TextBuilder();
		
		try {
			testList = builder.load("test.txt");
		} catch (IOException e) {
			System.err.println("Error loading file.");
		}
		
		try {
			builder.save(testList, "test2.txt");
		} catch (IOException e) {
			System.err.println("Error saving file.");
		}
	}
}