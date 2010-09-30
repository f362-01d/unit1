package draw.operations;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.JComponent;

import draw.*;
import draw.Canvas;

public class Move extends Operation implements MouseListener, MouseMotionListener {

	private Point lastMousePosition;

	public Move(JComponent component, Canvas canvas) {
		super(component, canvas);
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		if(lastMousePosition != null)
		{
			ArrayList<DrawingPrimitive> primitives = this.getCanvas().getPrimitives();//getSelection();
			for(int i=0;i<primitives.size();i++)
			{
				DrawingPrimitive d = primitives.get(i);
				Point p = (Point)d.getPosition().clone();
				p.translate((int)(arg0.getX()-lastMousePosition.getX()), (int)(arg0.getY()-lastMousePosition.getY()));
				d.setPosition(p);
			}
			this.getComponent().repaint();
		}
		lastMousePosition = arg0.getPoint();
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		lastMousePosition = null;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) { }

	@Override
	public void mouseClicked(MouseEvent arg0) { }

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) { }

	@Override
	public void mousePressed(MouseEvent arg0) {	}

}
