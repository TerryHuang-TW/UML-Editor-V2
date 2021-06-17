package uml.item;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Dimension;

public class ClassItem extends Item {
    static final Point INITPLACE = new Point(0, 0);
    static final Dimension DEFAULTSIZE = new Dimension(120, 30*3);
    static final Dimension BLOCKSIZE = new Dimension(120, 30);
    static final int CLASSBLOCK = 3;
    static final int TEXTSHIFTX = 5;

    //pass self to port as parent and define name, size
    public ClassItem()
    {
        super();
        name = "New Class";
        init();
    }

    @Override
    protected void init()
    {
        this.setSize(DEFAULTSIZE);
        this.setVisible(true);
        this.setLocation(INITPLACE);
        this.setOpaque(true);
    }

    @Override
    public void paintItemStyle(Graphics g)
    {
        int lineWidth = 1;
        int firstBlock = 0;
        double textShiftYPercent = 0.7;
        for(int i = 0; i < CLASSBLOCK; i++)
        {
            g.setColor(Color.WHITE);
            g.fillRect(0, BLOCKSIZE.height * i,
                BLOCKSIZE.width - lineWidth, BLOCKSIZE.height - lineWidth);
            g.setColor(Color.BLACK);
            g.drawRect(0, BLOCKSIZE.height * i,
                BLOCKSIZE.width - lineWidth, BLOCKSIZE.height - lineWidth);
            if(i == firstBlock)
                g.drawString(name, TEXTSHIFTX, (int)(BLOCKSIZE.height * textShiftYPercent));
        }
    }
}
