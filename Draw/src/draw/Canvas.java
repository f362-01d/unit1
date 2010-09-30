package draw;

import java.util.*;

public class Canvas extends Observable {
	
    private ArrayList<DrawingPrimitive> primitives;

    public Canvas(){
        primitives = new ArrayList<DrawingPrimitive>();
    } // Canvas npo-args constructor
	
    public Canvas( ArrayList<DrawingPrimitive> importPrimitives ){
        primitives = importPrimitives;
    } // Canvas data load constructor

    public ArrayList<DrawingPrimitive> getSelected() {

        ArrayList<DrawingPrimitive> selected =
            new ArrayList<DrawingPrimitive>();

        // Iterate over the array of DrawingPrimitives, adding all selected
        // elements to another array which is later returned.
        for(int i=0;i<primitives.size();i++){
            if( primitives.get(i).isSelected() ){
                selected.add( primitives.get(i) );
            } // if
        } // for

        return selected;
    } // getSelected()

    public boolean setSelected( DrawingPrimitive modified, boolean isSelected ){

        boolean targetFound;
        int modifiedIndex = primitives.indexOf( modified );

        // Return a false boolean in case of an attempt to change an unknown
        // primitive since I don't trust myself with exceptions in my current
        // state.  ~Greg
        if( modifiedIndex == -1 ){
            targetFound = false;
        } else {
            targetFound = true;
            primitives.get( modifiedIndex ).setSelected( isSelected );
        } // if

        return targetFound;
    } // setSelected()

    public ArrayList<DrawingPrimitive> getPrimitives(){
        return primitives;
    } // getPrimitives()

    public void add( DrawingPrimitive newPrimitive ){
        primitives.add( newPrimitive );
    } // add()

    public void remove( DrawingPrimitive killPrimitive ){
        primitives.remove( killPrimitive );
    } // remove()

    public void remove( int killIndex ){
        primitives.remove( killIndex );
    } // remove()

} // Canvas
