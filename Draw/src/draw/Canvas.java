package draw;

import java.util.*;

public class Canvas extends Observable {
	
    private ArrayList<DrawingPrimitive> primitives;

    public Canvas() {

        primitives = new ArrayList<DrawingPrimitive>();

    } // Canvas constructor
	
    public DrawingPrimitive[] getSelected() {

        ArrayList<DrawingPrimitive> selected =
            new ArrayList<DrawingPrimitive>();

        // Iterate over the array of DrawingPrimitives, adding all selected
        // elements to another array which is later returned.
        for(i=0;i<primitives.size;i++){
            if( primitives.get(i).isSelected ){

                selected.add( primitives.get(i) );

            } // if
        } // for

        return selected.toArray();

    } // getSelected()

    public void add( DrawingPrimative newPrimitive ){

        primitives.add( newPrimitive );

    } // add()

    public void remove( DrawingPrimitive killPrimitive ){

        primitives.remove( killPrimitive );

    } // remove()

    public void remove( int killIndex ){

        primitives.remove( killIndex );

    } // remove()

} // Canvas
