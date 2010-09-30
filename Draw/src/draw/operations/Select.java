package draw.operations;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import draw.Canvas;
import draw.DrawingPrimitive;
import draw.Operation;

public class Select extends Operation implements KeyListener, MouseListener {

	private static final int ADDITIVE_KEY = KeyEvent.VK_CONTROL;
	
	private Boolean additiveKeyPressed = false;
	
	public Select(JComponent component, Canvas canvas) {
		super(component, canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}
	
	public void unselectAll()
	{
		ArrayList<DrawingPrimitive> primitives = getCanvas().getPrimitives();
		for(int i=0;i<primitives.size();i++)
		{
			primitives.get(i).setSelected(false);
			primitives.get(i).setColor(Color.BLACK);
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
		getComponent().setFocusable(true);
		getComponent().requestFocus();
		ArrayList<DrawingPrimitive> primitives = getCanvas().getPrimitives();
		ArrayList<DrawingPrimitive> underCursor = new ArrayList<DrawingPrimitive>();
		for(int i=0;i<primitives.size();i++)
		{
			if(primitives.get(i).contains(arg0.getPoint()))
			{
				underCursor.add(primitives.get(i));
			}
		}
		if(!additiveKeyPressed)
			unselectAll();
		if(!underCursor.isEmpty())
		{
			underCursor.get(underCursor.size()-1).setSelected(true);
			underCursor.get(underCursor.size()-1).setColor(Color.BLUE);
			getComponent().repaint();
		}
		else
		{
			unselectAll();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == ADDITIVE_KEY)
			additiveKeyPressed = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == ADDITIVE_KEY)
			additiveKeyPressed = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
