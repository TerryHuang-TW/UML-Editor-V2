package uml;

import java.util.Vector;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Point;

import uml.item.Item;
import uml.line.Line;

public class Port {
    public static final Dimension PORTSIZE = new Dimension(10, 5);
    private Item parent;
    private Point position = new Point();
    private Vector<Line> lines = new Vector<>();
    private int spot;

    //add port to parent and set self relative position to parent
    public Port(Item parent)
    {
        this.parent = parent;
    }

    //add line to port
    public void addLine(Line l)
    {
        lines.add(l);
    }

    //set port spot
    public void setSpot(int spot)
    {
        this.spot = spot;
    }

    public int getSpot()
    {
        return spot;
    }

    public void broadCastLocation()
    {
        for(Line line: lines)
            line.refreshLine();
    }
    
    //direct position for line to connect point
    public Point getPosition()
    {
        setPosition();
        Point midPosition = new Point(parent.getLocation().x, parent.getLocation().y);
        switch(spot)
        {
            case Item.NORTH_PORT:
                midPosition.setLocation(midPosition.x + position.x + PORTSIZE.height, 
                    midPosition.y + position.y);
                break;
            case Item.EAST_PORT:
                midPosition.setLocation(midPosition.x + position.x + PORTSIZE.height, 
                    midPosition.y + position.y + PORTSIZE.height);
                break;
            case Item.SOUTH_PORT:
                midPosition.setLocation(midPosition.x + position.x + PORTSIZE.height, 
                    midPosition.y + position.y + PORTSIZE.height);
                break;
            case Item.WEST_PORT:
                midPosition.setLocation(midPosition.x + position.x, 
                    midPosition.y + position.y + PORTSIZE.height);
                break;
        }
        return midPosition;
    }

    //paint port itself
    public void paint(Graphics g)
    {
        setPosition();
        if(spot % 2 == 0)
            g.fillRect(position.x, position.y, PORTSIZE.width, PORTSIZE.height);
        else
            g.fillRect(position.x, position.y, PORTSIZE.height, PORTSIZE.width);
    }

    //unknown how not to use switch
    private void setPosition()
    {
        Dimension parentSize = parent.getSize();
        switch(spot)
        {
            case Item.NORTH_PORT:
                position.setLocation(parentSize.width / 2 - PORTSIZE.width / 2, 0);
                break;
            case Item.EAST_PORT:
                position.setLocation(parentSize.width - PORTSIZE.height, parentSize.height / 2 - PORTSIZE.width / 2);
                break;
            case Item.SOUTH_PORT:
                position.setLocation(parentSize.width / 2 - PORTSIZE.width / 2, parentSize.height - PORTSIZE.height);
                break;
            case Item.WEST_PORT:
                position.setLocation(0, parentSize.height / 2 - PORTSIZE.width / 2);
                break;
        }
    }
}
