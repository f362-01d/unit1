package draw;

import java.util.ArrayList;
import java.util.ListIterator;

public class XMLFormat extends FileFormat {
	
	public XMLFormat(ArrayList<DrawingPrimitive> d) {
		super(d);
	}
	
	public ArrayList<String> makeStringList() {
		ListIterator<DrawingPrimitive> shapeItr = this.shapes.listIterator();
		
		while (shapeItr.hasNext()) {
			DrawingPrimitive currentShape = shapeItr.next();
			if (currentShape.getClass().toString().equals("Line")) {
				makeLLines(this.shapeLines, currentShape);
			} else if (currentShape.getClass().toString().equals("Rectangle")) {
				makeRLines(this.shapeLines, currentShape);
			} else {
				makeGLines(this.shapeLines, currentShape);
			}
		}
		
		return this.shapeLines;
	}
	
	/*
	 * This method does not need to be implemented in XMLFormat at this
	 * time due to not needing to load an XML file.
	 */
	
	public ArrayList<DrawingPrimitive> makeShapes(ArrayList<String> l) {
		return null;
	}
	
	protected void makeLLines(ArrayList<String> l, DrawingPrimitive d) {
		l.add("<line>");
		l.add(" <begin>");
		l.add("  <x>" + d.getPosition().getX() + "</x>");
		l.add("  <y>" + d.getPosition().getY() + "</y>");
		l.add(" </begin>");
		l.add(" <end>");
		l.add("  <x>" + (d.getPosition().getX()
				+ d.getSize().getWidth()) + "</x>");
		l.add("  <y>" + (d.getPosition().getY()
				+ d.getSize().getHeight()) + "</y>");
		l.add(" </end>");
		l.add(" <color>" + d.getColor().toString() + "</color>");
		l.add("</line>");
	}
	
	protected void makeRLines(ArrayList<String> l, DrawingPrimitive d) {
		l.add("<rectangle>");
		l.add(" <upper-left>");
		l.add("  <x>" + d.getPosition().getX() + "</x>");
		l.add("  <y>" + d.getPosition().getY() + "</y>");
		l.add(" </upper-left>");
		l.add(" <lower-right>");
		l.add("  <x>" + (d.getPosition().getX()
				+ d.getSize().getWidth()) + "</x>");
		l.add("  <y>" + (d.getPosition().getY()
				+ d.getSize().getHeight()) + "</y>");
		l.add(" </lower-right>");
		l.add(" <color>" + d.getColor().toString() + "</color>");
		l.add("</rectangle>");
	}
	
	protected void makeGLines(ArrayList<String> l, DrawingPrimitive d) {
		
		Group currentGroup = (Group) d;
		l.add("<group>");
		ListIterator<DrawingPrimitive> elementItr = 
								currentGroup.getElements().listIterator();
		
		while (elementItr.hasNext()) {
			DrawingPrimitive currentElement = elementItr.next();
			if (currentElement.getClass().toString().equals("Line")) {
				makeLLines(this.shapeLines, currentElement);
			} else if (currentElement.getClass()
								.toString().equals("Rectangle")) {
				makeRLines(this.shapeLines, currentElement);
			} else {
				makeGLines(this.shapeLines, currentElement);
			}
		}
		
		l.add("<group>");
	}
}
