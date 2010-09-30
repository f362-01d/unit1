package draw.operations;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import draw.Canvas;
import draw.DrawingPrimitive;
import draw.Operation;

public class Delete extends Operation implements KeyListener {

	static final int DELETE_KEY = KeyEvent.VK_DELETE;
	
	public Delete(JComponent component, Canvas canvas) {
		super(component, canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		if(arg0.getKeyCode() == DELETE_KEY)
		{
			ArrayList<DrawingPrimitive> toRemove = getCanvas().getSelected();
			for(int i=0;i<toRemove.size();i++)
			{
				getCanvas().remove(toRemove.get(i));
			}
		}
	}

}
