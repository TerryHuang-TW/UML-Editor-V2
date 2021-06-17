package definition;

import java.awt.Point;

public class DragDefine {
    Point from;
    Point to;

    //get both points from listener in order pass to mode
    public DragDefine(Point from, Point to)
    {
        this.from = from;
        this.to = to;
    }

    // set when needed (such as group's size optimize)
    public void setFrom(Point from)
    {
        this.from = from;
    }

    // set when needed (such as group's size optimize)
    public void setTo(Point to)
    {
        this.to = to;
    }
    
    public Point getFrom()
    {
        return from;
    }

    public Point getTo()
    {
        return to;
    }
}
