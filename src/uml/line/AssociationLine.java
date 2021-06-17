package uml.line;

import java.awt.Point;
import java.awt.Graphics;

import uml.Port;
import uml.item.Item;

public class AssociationLine extends Line {
    public AssociationLine(Port from, Port to)
    {
        super(from, to);
        init();
    }

    public AssociationLine()
    {
        super();
    }

    @Override
    public void doStyle(Graphics g, Point from, Point to, int portIndex)
    {
        SolidLine line = new SolidLine(g, from, to);
        line.draw();
        switch(portIndex)
        {
            case Item.NORTH_PORT:
                g.drawLine(to.x, to.y, to.x, to.y + ARROWSIZE);
                g.drawLine(to.x - ARROWSIZE / 2, to.y + ARROWSIZE / 2, to.x, to.y + ARROWSIZE);
                g.drawLine(to.x + ARROWSIZE / 2, to.y + ARROWSIZE / 2, to.x, to.y + ARROWSIZE);
                break;
            case Item.EAST_PORT:
                g.drawLine(to.x, to.y, to.x - ARROWSIZE, to.y);
                g.drawLine(to.x - ARROWSIZE / 2, to.y - ARROWSIZE / 2, to.x - ARROWSIZE, to.y);
                g.drawLine(to.x - ARROWSIZE / 2, to.y + ARROWSIZE / 2, to.x - ARROWSIZE, to.y);
                break;
            case Item.SOUTH_PORT:
                g.drawLine(to.x, to.y, to.x, to.y - ARROWSIZE);
                g.drawLine(to.x + ARROWSIZE / 2, to.y - ARROWSIZE / 2, to.x, to.y - ARROWSIZE);
                g.drawLine(to.x - ARROWSIZE / 2, to.y - ARROWSIZE / 2, to.x, to.y - ARROWSIZE);
                break;
            case Item.WEST_PORT:
                g.drawLine(to.x, to.y, to.x + ARROWSIZE, to.y);
                g.drawLine(to.x + ARROWSIZE / 2, to.y + ARROWSIZE / 2, to.x + ARROWSIZE, to.y);
                g.drawLine(to.x + ARROWSIZE / 2, to.y - ARROWSIZE / 2, to.x + ARROWSIZE, to.y);
                break;
        }
    }
}
