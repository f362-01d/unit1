package draw;
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
    			builder.save(myInterface.myCanvas.getPrimitives(), filename);
    		}
    		else if (ext.equals(".xml")){
    			XMLBuilder builder = new XMLBuilder();
    			builder.save(myInterface.myCanvas.getPrimitives(),filename);
    		}
    		else{
    			JOptionPane.showMessageDialog(myInterface, "Incorrect extention");
    		}
    	}
		
	}
}
