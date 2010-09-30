package draw.operations;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;

import draw.Canvas;
import draw.Draw;
import draw.DrawingPanel;
import draw.DrawingPrimitive;
import draw.Operation;

public class Copy extends Operation implements KeyListener {

	private static final int COPY_MODIFIERS = KeyEvent.CTRL_DOWN_MASK;
	private static final int COPY_KEY = KeyEvent.VK_C;
	private static final int COPY_OFFSET = 5;
	
	public Copy(JComponent component, Canvas canvas) {
		super(component, canvas);
	}
	
	public void copySelected()
	{
		ArrayList<DrawingPrimitive> selected = getCanvas().getSelected();
		Select s = new Select(getComponent(), getCanvas());
		Move m = new Move(getComponent(), getCanvas());
		s.unselectAll();
		for(int i=0;i<selected.size();i++)
		{
			DrawingPrimitive copy = selected.get(i).clone();
			copy.setSelected(true);
			getCanvas().add(copy);
			((DrawingPanel)getComponent()).paintComponent(getCanvas());
		}
		m.moveSelected(COPY_OFFSET, COPY_OFFSET);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if((arg0.getModifiersEx() & (COPY_MODIFIERS | 0)) == COPY_MODIFIERS && arg0.getKeyCode() == COPY_KEY)
		{
			copySelected();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
