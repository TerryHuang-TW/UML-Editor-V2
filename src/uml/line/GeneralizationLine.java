package uml.line;

import java.awt.Color;
import java.awt.Point;
import java.util.Vector;
import java.awt.Graphics;
import java.awt.Polygon;

import uml.Port;

public class GeneralizationLine extends Line {
    public GeneralizationLine(Port from, Port to)
    {
        super(from, to);
        init();
    }

    public GeneralizationLine()
    {
        super();
    }

    @Override
    public void doStyle(Graphics g, Point from, Point to, int portIndex)
    {
        SolidLine line = new SolidLine(g, from, to);
        line.draw();
        Vector<Integer> xList = new Vector<>();
        xList.add(to.x);
        xList.add(to.x + ARROWSIZE);
        xList.add(to.x);
        xList.add(to.x - ARROWSIZE);
        Vector<Integer> yList = new Vector<>();
        yList.add(to.y - ARROWSIZE);
        yList.add(to.y);
        yList.add(to.y + ARROWSIZE);
        yList.add(to.y);
        xList.remove(portIndex);
        yList.remove(portIndex);

        int[] x = new int[xList.size()];
        int[] y = new int[yList.size()];
        for(int i = 0; i < xList.size(); i++)
        {
            x[i] = xList.get(i);
            y[i] = yList.get(i);
        }

        Polygon polygon = new Polygon(x, y, x.length);
		g.setColor(Color.WHITE);
		g.fillPolygon(polygon);
		g.setColor(Color.BLACK);
		g.drawPolygon(polygon);
    }
}
