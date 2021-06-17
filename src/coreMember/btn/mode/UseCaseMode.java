package coreMember.btn.mode;

import java.awt.Point;

import behavior.CreateBehavior;
import coreMember.Canvas;
import uml.item.UseCaseItem;

public class UseCaseMode extends Mode {
    public UseCaseMode(Canvas canvas, CreateBehavior cBehavior)
    {
        super(canvas, cBehavior);
    }
    
    @Override
    protected void perform(Point p)
    {
        cBehavior.create(canvas, new UseCaseItem(), p);
    }

}
