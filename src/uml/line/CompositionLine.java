package uml.line;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import uml.Port;

public class CompositionLine extends Line {
    public CompositionLine(Port from, Port to)
    {
        super(from, to);
        init();
    }

    public CompositionLine()
    {
        super();
    }

    @Override
    public void doStyle(Graphics g, Point from, Point to, int portIndex)
    {
        SolidLine line = new SolidLine(g, from, to);
        line.draw();
        int x[] =
		{to.x, to.x - ARROWSIZE, to.x, to.x + ARROWSIZE};
		int y[] =
		{to.y + ARROWSIZE, to.y, to.y - ARROWSIZE, to.y};
		Polygon polygon = new Polygon(x, y, x.length);
		g.setColor(Color.WHITE);
		g.fillPolygon(polygon);
		g.setColor(Color.BLACK);
		g.drawPolygon(polygon);
    }
}
