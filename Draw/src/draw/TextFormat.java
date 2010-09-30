package draw;

import java.util.*;

public class TextFormat extends FileFormat {
	
	public TextFormat(ArrayList<DrawingPrimitive> s) {
		super(s);
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
	
	public ArrayList<DrawingPrimitive> makeShapes(ArrayList<String> l) {
		return null;
	}
	
	protected void makeLLines(ArrayList<String> l,
								DrawingPrimitive p) {
		String line = new String("line ");
		line.concat(p.getPosition().getX() + " ");
		line.concat(p.getPosition().getY() + " ");
		line.concat((p.getPosition().getX()
				+ p.getSize().getWidth()) + " ");
		line.concat((p.getPosition().getY()
				+ p.getSize().getHeight()) + " ");
		line.concat(p.getColor().toString());
		l.add(line);
	}
	
	protected void makeRLines(ArrayList<String> l,
								DrawingPrimitive p) {
		String line = new String("rect ");
		line.concat(p.getPosition().getX() + " ");
		line.concat(p.getPosition().getY() + " ");
		line.concat((p.getPosition().getX()
				+ p.getSize().getWidth()) + " ");
		line.concat((p.getPosition().getY()
				+ p.getSize().getHeight()) + " ");
		line.concat(p.getColor().toString());
		l.add(line);
	}
	
	protected void makeGLines(ArrayList<String> l,
								DrawingPrimitive p) {
		l.add("begin");
		
		ListIterator<DrawingPrimitive> elementItr = p.getElements()
													.listIterator();
		
		while (elementItr.hasNext()) {
			DrawingPrimitive currentElement = elementItr.next();
			if (currentElement.getClass().toString().equals("Line")) {
				makeLLines(l, currentElement);
			} else if (currentElement.getClass().toString().equals("Rectangle")) {
				makeRLines(l, currentElement);
			} else {
				makeGLines(l, currentElement);
			}
		}
		
		l.add("end");
	}
}
