package draw.operations;

import java.util.ArrayList;

import javax.swing.JComponent;

import draw.Canvas;
import draw.DrawingPrimitive;
import draw.DrawingPanel;
import draw.Operation;

public class Group extends Operation {

	public Group(JComponent component, Canvas canvas) {
		super(component, canvas);
		// TODO Auto-generated constructor stub
	}
	
	public void groupSelected()
	{
		draw.Group newGroup = new draw.Group(null, null);
		ArrayList<DrawingPrimitive> selection = getCanvas().getSelected();
		for(int i=0;i<selection.size();i++)
		{
			getCanvas().remove(selection.get(i));
			newGroup.add(selection.get(i));
		}
		getCanvas().add(newGroup);
		((DrawingPanel)getComponent()).paintComponent(getCanvas());
	}

}
