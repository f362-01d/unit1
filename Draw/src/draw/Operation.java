package draw;

import javax.swing.*;
import draw.DrawingPanel;

public abstract class Operation {
	
	private JComponent component;
	private Canvas canvas;
	
	public Operation(JComponent component, Canvas canvas)
	{
		this.component = component;
		this.canvas = canvas;
	}
	
	public JComponent getComponent()
	{
		return this.component;
	}
	
	public Canvas getCanvas()
	{
		return this.canvas;
	}
	
}
