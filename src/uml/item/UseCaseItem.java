package uml.item;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class UseCaseItem extends Item {
    static final Dimension DEFAULTSIZE = new Dimension(150, 40);
    static final Point INITPLACE = new Point(0, 0);
   
    //pass self to port as parent and define name, size
    public UseCaseItem()
    {
        super();
        name = "New Use Case";
        init();
    }

    @Override
    protected void init()
    {
        this.setSize(DEFAULTSIZE);
        this.setVisible(true);
        this.setLocation(INITPLACE);
        this.setOpaque(false);
    }

    @Override
    public void paintItemStyle(Graphics g)
    {
        int lineWidth = 1;
        double textShiftXPercent = 0.2;
        double textShiftYPercent = 0.6;
        g.setColor(Color.WHITE);
        g.fillOval(0, 0, DEFAULTSIZE.width, DEFAULTSIZE.height);
        g.setColor(Color.BLACK);
        g.drawOval(0, 0, DEFAULTSIZE.width - lineWidth, DEFAULTSIZE.height - lineWidth);
        g.drawString(name, (int)(DEFAULTSIZE.width * textShiftXPercent), (int)(DEFAULTSIZE.height * textShiftYPercent));
    }
}
