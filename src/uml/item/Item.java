package uml.item;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Dimension;

import uml.UMLObject;
import uml.Port;

public class Item extends UMLObject implements ItemStyle {
    public static final int NORTH_PORT = 0;
    public static final int EAST_PORT = 1;
    public static final int SOUTH_PORT = 2;
    public static final int WEST_PORT = 3;
    //protected boolean isSelected = false;
    protected String name;
    protected Port[] ports = {new Port(this), new Port(this), new Port(this), new Port(this)};
    protected Point centerPoint;

    //pass self to port as parent and define name
    public Item()
    {
        for(int i = NORTH_PORT; i <= WEST_PORT; i++)
            ports[i].setSpot(i);
    }

    //default gui setting
    protected void init()
    {
        
    }
    
    //switch select to true or false
    /*public void switchSelect()
    {
        if(isSelected == false)
            isSelected = true;
        else
            isSelected = false;
    }*/

    //resize by text width (reference by "Project")
    public void reSize()
    {

    }

    //ask ports to paint when selected
    public void paintSelect(Graphics g)
    {
        for(Port port: ports)
            port.paint(g);
    }

    public Port[] getPorts()
    {
        return ports;
    }

    @Override
    public void refreshUI()
    {
        this.repaint();
        for(Port port: ports)
            port.broadCastLocation();
    }

    @Override
    public void changeName(String text)
    {
        name = text;
        this.repaint();     //weird this must be implement
    }

    @Override
    public boolean checkSelected(Point p)
    {
        Point location = this.getLocation();
        Dimension size = this.getSize();
        if(location.x <= p.x && p.x <= location.x + size.width)
        {
            if(location.y <= p.y && p.y <= location.y + size.height)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkSelected(Point coordinatedFrom, Point coordinatedTo)
    {
        Point location = this.getLocation();
        Dimension size = this.getSize();
        if(coordinatedFrom.x <= location.x && location.x + size.width <= coordinatedTo.x)
        {
            if(coordinatedFrom.y <= location.y && location.y + size.height <= coordinatedTo.y)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Item passItem()
    {
        return this;
    }

    //this will only call ports to paint, subclass must call super method first
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        paintItemStyle(g);
        if(isSelected)
            paintSelect(g);
    }

    //subclass implement their own paint style
    @Override
    public void paintItemStyle(Graphics g)
    {
        //implement by subclass
    }
}
