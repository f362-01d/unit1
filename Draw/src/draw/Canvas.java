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

        for(i=0;i<primitives.size;i++){
            
            if( primitives.get(i).isSelected ){

                selected.add( primitives.get(i) );

            } // if

        } // for

        return selected.toArray();

    } // getSelected()

}
