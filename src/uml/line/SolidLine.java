package uml.line;

import java.awt.Point;
import java.awt.Graphics;

public class SolidLine {
    Graphics g;
    Point from;
    Point to;
    
    public SolidLine(Graphics g, Point from, Point to)
    {
        this.g = g;
        this.from = from;
        this.to = to;
    }

    public void draw()
    {
        g.drawLine(from.x, from.y, to.x, to.y);
    }
}
