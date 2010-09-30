package draw;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class FileDirector {
	JFileChooser fc;
	public void saveFile(UserInterface myInterface){
		fc = new JFileChooser();
    	int returnVal = fc.showSaveDialog(myInterface);
    	if (returnVal == JFileChooser.APPROVE_OPTION){
    		String filename = fc.getSelectedFile().getName();
    		String ext = filename.substring(filename.indexOf('.'));
    		if (ext.equals(".txt")){
    			TextBuilder builder = new TextBuilder();
    			try {
					builder.save(myInterface.myCanvas.getPrimitives(), filename);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		else if (ext.equals(".xml")){
    			XMLBuilder builder = new XMLBuilder();
    			try {
					builder.save(myInterface.myCanvas.getPrimitives(),filename);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		else{
    			JOptionPane.showMessageDialog(myInterface, "Incorrect extention");
    		}
    	}
		
	}
}