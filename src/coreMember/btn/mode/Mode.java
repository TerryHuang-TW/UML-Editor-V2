package coreMember.btn.mode;

import java.awt.Point;

import behavior.CreateBehavior;
import coreMember.Canvas;
import definition.DragDefine;

public class Mode {
    protected Canvas canvas;
    protected CreateBehavior cBehavior;

    //connect mode to canvas and it's member items, selected items, mouselistener
    public Mode(Canvas canvas, CreateBehavior cBehavior)
    {
        this.canvas = canvas;
        this.cBehavior = cBehavior;
    }

    //called when canvasListener pass mouseEvent(mouse click) and do create behavior
    public void performFunc(Point p)
    {
        perform(p);
        updateUI();
    }

    //called when canvasListener pass DragDefine(mouse drag) and do create behavior
    public void performFunc(DragDefine d)
    {
        perform(d);
        updateUI();
    }

    //always call canvas to update when mode finish perform
    private void updateUI()
    {
        canvas.refreshUI();
    }

    protected void perform(Point p)
    {
        //implement by subclass if needed
    }

    protected void perform(DragDefine d)
    {
        //implement by subclass if needed
    }
}
