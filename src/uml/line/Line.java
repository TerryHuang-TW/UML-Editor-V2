package uml.line;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import uml.Port;
import uml.UMLObject;
import uml.item.Item;

public class Line extends UMLObject implements LineStyle {
    public static final int ARROWSIZE = 6;
    protected Port fromPort;
    protected Port toPort;
    protected Point fromPoint = new Point();
    protected Point toPoint = new Point();

    //add port to line
    public Line(Port from, Port to)
    {
        fromPort = from;
        toPort = to;
        init();
    }

    public Line()
    {
        init();
    }
    
    //default gui setting
    protected void init()
    {
        this.setOpaque(false);
        this.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    //set port to line, then refresh itself
    public void setPort(Port from, Port to)
    {
        fromPort = from;
        fromPort.addLine(this);
        toPort = to;
        toPort.addLine(this);
        refreshLine();
    }

    //when canvas call paint() and attached object is moved reset line position
    public void refreshLine()
    {
        try
        {
            fromPoint = fromPort.getPosition();
            toPoint = toPort.getPosition();
        }
        catch (NullPointerException e)
		{
			this.setVisible(false);
			this.getParent().remove(this);
		}
    }

    //wait for better implement, currently using setSize(max, max)
    private void reSize()
    {
        Dimension size = new Dimension(Math.abs(fromPoint.x - toPoint.x) + ARROWSIZE * 2,
				Math.abs(fromPoint.y - toPoint.y) + ARROWSIZE * 2);
        this.setLocation(Math.min(fromPoint.x, toPoint.x) - ARROWSIZE, Math.min(fromPoint.y, toPoint.y) - ARROWSIZE);
		this.setSize(size);
    }

    private Point adjustArrowPoint(Point originPoint, int spot)
    {
        Point p = new Point(originPoint.x, originPoint.y);
        switch(spot)
        {
            case Item.NORTH_PORT:
                p.setLocation(p.x, p.y - ARROWSIZE);
                break;
            case Item.EAST_PORT:
                p.setLocation(p.x + ARROWSIZE, p.y);
                break;
            case Item.SOUTH_PORT:
                p.setLocation(p.x, p.y + ARROWSIZE);
                break;
            case Item.WEST_PORT:
                p.setLocation(p.x - ARROWSIZE, p.y);
                break;
        }
        return p;
    }

    //implement line style(line and arrow)
    public void doStyle(Graphics g, Point from, Point to, int portIndex)
    {
        //implement by subclass
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        refreshLine();
        Point to = adjustArrowPoint(toPoint, toPort.getSpot());
        doStyle(g, fromPoint, to, toPort.getSpot());
    }
}
