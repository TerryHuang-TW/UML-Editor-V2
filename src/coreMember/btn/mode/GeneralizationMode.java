package coreMember.btn.mode;

import behavior.CreateBehavior;
import coreMember.Canvas;
import definition.DragDefine;
import uml.line.GeneralizationLine;

public class GeneralizationMode extends Mode {
    public GeneralizationMode(Canvas canvas, CreateBehavior cBehavior)
    {
        super(canvas, cBehavior);
    }

    @Override
    protected void perform(DragDefine d)
    {
        cBehavior.create(canvas, new GeneralizationLine(), d);
    }
}
