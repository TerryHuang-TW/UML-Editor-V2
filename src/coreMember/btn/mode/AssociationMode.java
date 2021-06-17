package coreMember.btn.mode;

import behavior.CreateBehavior;
import coreMember.Canvas;
import definition.DragDefine;
import uml.line.AssociationLine;

public class AssociationMode extends Mode {
    public AssociationMode(Canvas canvas, CreateBehavior cBehavior)
    {
        super(canvas, cBehavior);
    }
    
    @Override
    protected void perform(DragDefine d)
    {
        cBehavior.create(canvas, new AssociationLine(), d);
    }
}
