package coreMember.btn.mode;

import behavior.CreateBehavior;
import coreMember.Canvas;
import definition.DragDefine;
import uml.line.CompositionLine;

public class CompositionMode extends Mode {
    public CompositionMode(Canvas canvas, CreateBehavior cBehavior)
    {
        super(canvas, cBehavior);
    }
    
    @Override
    protected void perform(DragDefine d)
    {
        cBehavior.create(canvas, new CompositionLine(), d);
    }
}
