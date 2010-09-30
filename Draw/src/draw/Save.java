package draw;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import draw.*;

public class Save {
	JFileChooser fc;
	UserInterface myInterface;
	public Save(UserInterface myInterface){
		this.myInterface = myInterface;
	}
	public void saveFile(){
		FileDirector fd = new FileDirector();
		fd.saveFile(myInterface);
	}
	
	public ArrayList<DrawingPrimitive> load(){
		JFileChooser fc = new JFileChooser();
		myInterface.myCanvas = new Canvas();
    	int returnVal = fc.showOpenDialog(myInterface); 
    	if (returnVal == JFileChooser.APPROVE_OPTION) {
    		try{
    			TextBuilder file = new TextBuilder();
    			return file.load(fc.getSelectedFile().getAbsolutePath());
    		}
    		catch (Exception e){
    			JOptionPane.showMessageDialog(myInterface, "Invalid File");
    		}
    	}
		return null;
	}
}
