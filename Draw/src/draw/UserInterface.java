package Draw.src.draw;

/* Draw.java
 * drawing GUI design
 * @Author - Steven Horowitz
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class UserInterface extends JFrame implements ActionListener{
    
    JMenu file;
    JMenu edit;
    JMenu create;
    drawingPanel panel;
    public static boolean selected = false;
    
    public static ArrayList<Line2D> lines;
    
    /*
     * public class draw
     * @param name - The name of the object to be displayed on the title bar of the frame.
     */
    public UserInterface(String name){
        super(name);
        lines = new ArrayList<Line2D>();
        setSize(400,450);
        setResizable(false);
        panel = new drawingPanel();
        JMenuBar menuBar = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        create = new JMenu("Create");
        
        // the menu items; these are the selectable options in the top menu bar.
        JMenuItem delete = new JMenuItem("delete");
        JMenuItem save = new JMenuItem("save");
        JMenuItem quit = new JMenuItem("quit");
        JMenuItem line = new JMenuItem("line");
        JMenuItem rectangle = new JMenuItem("rectangle");
        JMenuItem properties = new JMenuItem("properties");
        
        //the buttons that allow you to add items without going through the menu.
        JButton createLine = new JButton("Create Line");
        JButton createRectangle = new JButton("Create Rectangle");
        
        //add actionlisteners from jordan here.
        delete.addActionListener(this);
        save.addActionListener(this);
        quit.addActionListener(this);
        line.addActionListener(this);
        rectangle.addActionListener(this);
        properties.addActionListener(this);
        createLine.addActionListener(this);
        createRectangle.addActionListener(this);
        
        //we need to add all the created items to the GUI here.
        file.add(quit);
        file.add(save);
        edit.add(delete);
        edit.add(properties);
        create.add(line);
        create.add(rectangle);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(create);
        
        setLayout(null);
        add(menuBar);
        add(createLine);
        add(createRectangle);
        add(panel);
        
        // Because we set the layout to null, we must manually set the bounds for the objects.
        createLine.setBounds(new Rectangle(0,30,150,20));
        createRectangle.setBounds(new Rectangle(150,30,150,20));
        menuBar.setBounds(new Rectangle(0,0,400,30));
        panel.setBounds(new Rectangle(0,50,400,400));
        
    }
    
    /*
     * public update
     * calls the repaint method on the view class, the panel.
     */
    public void update(){
        panel.repaint();
    }
    
    // test main object
    public static void main (String[]args){
        UserInterface draw = new UserInterface("Draw");
        draw.setVisible(true);
    }

    /*
     * public actionPerformed
     * called when a button or menu item is clicked, this will handle those cases. Likely will be replaced
     * with more sophisticated methods by someone handling the action listeners.
     */
    public void actionPerformed(ActionEvent arg0) {
        String command = arg0.getActionCommand();
        System.out.println(command);
        if (command == "quit")
            System.exit(0);
        if (command == "line" || command == "Create Line"){
            lines.add(new Line2D.Double(10,10,200,200));
            panel.repaint();
        }
        if (command == "properties"){
            editRectangle edit = new editRectangle("Edit line");
            edit.setVisible(true);
        }
        if (command == "delete"){
            UserInterface.lines.remove(0);
            update();
        }
    }
}

/*
 * drawingPanel.java
 * @author Steven Horowitz
 * This is a sub-class that handles the drawing of all objects on the screen.
 */
class drawingPanel extends JPanel implements MouseListener, MouseMotionListener{
    public drawingPanel(){
        setSize(400,400);
        this.setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    /*
     * paintComponents
     * @param g - the graphics object for the class; handles drawing of all objects.
     * This is the method where all items are drawn in.
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        // test to make sure I can draw rectangles OK. Line will be represented by drawing primatives
        // drawn from the canvas.
        if(UserInterface.lines.size()!=0){
            Point2D p1 = UserInterface.lines.get(0).getP1();
            Point2D p2 = UserInterface.lines.get(0).getP2();
            g.drawLine((int)p1.getX(),(int)p1.getY(),(int)p2.getX(),(int)p2.getY());
        }
    }

    /*
     * public mouseClicked
     * @param arg0- the click of a mouse
     * This method registers any and all mouse clicks. Will likely be replaced by a more involved action handler.
     */
    public void mouseClicked(MouseEvent arg0) {
        UserInterface.selected = !UserInterface.selected;
    }

    // unimplmeneted methods
    public void mouseEntered(MouseEvent arg0) {}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {}
    public void mouseDragged(MouseEvent arg0) {}
    // end unimplemented methods.
    
    /*
     * public mouseMoved -
     * @param arg0 - the mouse's current position data.
     * This will update every time the mouse shifts position. Useful for moving objects around on the screen. Should call
     * repaint when an ojbect moves, so that the movement can be tracked in the view.
     */
    public void mouseMoved(MouseEvent arg0) {
        if(UserInterface.selected)
            System.out.println(arg0);
    }
}

/*
 * editLine.java
 * @author Steven Horowitz
 * This is a sub-class for a properties J-Frame, it is the basic edit panel for a line segment.
 */
class editLine extends JFrame implements ActionListener{
    ButtonGroup group;
    JButton done = new JButton("Done");
    
    /*
     * public editLine
     * @param name - the name of the panel that is displayed on the title bar.
     * This panel allows us to modify the color of strings with a radio button.
     */
    public editLine(String name){
        super(name);
        this.setFocusable(true);
        setSize(200,200);
        setLayout(new GridLayout(0,1));
        JRadioButton black = new JRadioButton("Black");
        black.setSelected(true);
        JRadioButton blue = new JRadioButton("Blue");
        JRadioButton green = new JRadioButton("Green");
        group = new ButtonGroup();
        done.addActionListener(this);
        group.add(green);
        group.add(blue);
        group.add(black);
        black.setActionCommand("black");
        blue.setActionCommand("blue");
        green.setActionCommand("green");
        add(black);
        add(blue);
        add(green);
        add(done);
    }
    
    /*
     * public actionPerformed
     * @param arg0 - the button press that called this method.
     * allows us to close this window, and identify which color the user has chosen for the line segment.
     */
    public void actionPerformed(ActionEvent arg0) {
        System.out.println(group.getSelection().getActionCommand());
        this.setVisible(false);
    }
}

/*
 * editRectangle.java
 * @author Steven Horowitz
 * a sub-class of the editLine pane; has a few more features making it slightly more sophisticated.
 */
class editRectangle extends editLine implements ActionListener{
    ButtonGroup edges = new ButtonGroup();
    
    /*
     * public editRectangle
     * @param name- the name of the window to be displayed in the title bar of the frame.
     * This allows us to edit simple rectangles.
     */
    public editRectangle(String name){
        super(name);
        remove(done);
        setSize(300,300);
        JRadioButton rounded = new JRadioButton ("Rounded Edges");
        JRadioButton hard = new JRadioButton ("Hard Edges");
        edges.add(rounded);
        hard.setSelected(true);
        edges.add(hard);
        rounded.setActionCommand("rounded");
        hard.setActionCommand("hard");
        add(hard);
        add(rounded);
        add(done);
    }

    /*
     * public actionPerformed
     * @param e - If the done button is pressed, this is called.
     * This method allows us to retrieve information from the user about the rectangle's formatting.
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println(edges.getSelection().getActionCommand());
        super.actionPerformed(e);
    }
}