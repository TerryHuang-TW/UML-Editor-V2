package coreMember.btn.mode;

import java.awt.Point;

import behavior.CreateBehavior;
import coreMember.Canvas;
import uml.item.ClassItem;

public class ClassMode extends Mode {
    public ClassMode(Canvas canvas, CreateBehavior cBehavior)
    {
        super(canvas, cBehavior);
    }
    
    @Override
    protected void perform(Point p)
    {
        cBehavior.create(canvas, new ClassItem(), p);
    }
}
