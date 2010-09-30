package draw.operations;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

import draw.Canvas;
import draw.DrawingPrimitive;
import draw.Operation;
import draw.primitives.Rectangle;

public class Create<T extends DrawingPrimitive> extends Operation implements MouseListener, MouseMotionListener {
	
	private Point mouseDownLocation;
	private Point mouseLastPosition;
	private T primitive;
	private Class<T> c;
	
	public Create(JComponent component, Canvas canvas, Class<T> c) {
		super(component, canvas);
		this.c = c;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		Graphics2D g = (Graphics2D)this.getComponent().getGraphics();
		T primitive;
		try {
			this.getComponent().repaint();
			this.primitive = (T) this.c.getConstructors()[0].newInstance(new Object[]{mouseDownLocation, arg0.getPoint()});
			this.primitive.draw(g);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mouseLastPosition = arg0.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		mouseDownLocation = arg0.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		try {
			this.primitive = (T) this.c.getConstructors()[0].newInstance(new Object[]{mouseDownLocation, mouseLastPosition});
			this.getCanvas().getElements().add(primitive);
			this.getComponent().repaint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mouseDownLocation = null;
	}
	
}
