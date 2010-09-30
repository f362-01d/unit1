package draw.operations;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import draw.Canvas;
import draw.DrawingPrimitive;
import draw.Operation;

public class Select extends Operation implements MouseListener {

	public Select(JComponent component, Canvas canvas) {
		super(component, canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		ArrayList<DrawingPrimitive> primitives = getCanvas().getElements();
		ArrayList<DrawingPrimitive> underCursor = new ArrayList<DrawingPrimitive>();
		for(int i=0;i<primitives.size();i++)
		{
			if(primitives.get(i).contains(arg0.getPoint()))
			{
				System.out.println("hit");
				underCursor.add(primitives.get(i));
			}
		}
		if(!underCursor.isEmpty())
		{
			underCursor.get(underCursor.size()-1).setColor(Color.BLUE);
			getComponent().repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
