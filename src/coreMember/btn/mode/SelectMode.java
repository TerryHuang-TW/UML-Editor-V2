package coreMember.btn.mode;

import java.awt.Point;
import java.util.Vector;

import behavior.CreateBehavior;
import coreMember.Canvas;
import definition.DragDefine;
import uml.UMLObject;

public class SelectMode extends Mode {
    public SelectMode(Canvas canvas, CreateBehavior cBehavior)
    {
        super(canvas, cBehavior);
    }
    
    @Override
    protected void perform(Point p)
    {
        cBehavior.create();
        Vector<UMLObject> members = canvas.getMember();
        Vector<UMLObject> selects = resetSelect();
        
        for(UMLObject obj: members)
        {
            if(obj.checkSelected(p))
            {
                selects.add(obj);
                obj.switchSelect();
                break;
            }
        }
    }

    @Override
    protected void perform(DragDefine d)
    {
        cBehavior.create();
        Vector<UMLObject> members = canvas.getMember();
        for(UMLObject obj: members)
        {
            if(obj.checkSelected(d.getFrom()))
            {
                moveEvent(d, obj);
                return;
            }
        }
        selectEvent(d);
    }

    private void moveEvent(DragDefine d, UMLObject obj)
    {
        Point delta = new Point(d.getTo().x - d.getFrom().x, d.getTo().y - d.getFrom().y);
        toTheEnd(obj, delta);
        /*if(obj.getMember() != null)
        {
            for(UMLObject member: obj.getMember())
                member.setLocation(member.getLocation().x + delta.x, member.getLocation().y + delta.y);
            return;
        }
        obj.setLocation(obj.getLocation().x + delta.x, obj.getLocation().y + delta.y);*/
    }

    private void toTheEnd(UMLObject obj, Point delta)
    {
        if(obj.getMember() != null)
        {
            for(UMLObject member: obj.getMember())
                toTheEnd(member, delta);
        }
        else
            obj.setLocation(obj.getLocation().x + delta.x, obj.getLocation().y + delta.y);
    }

    private void selectEvent(DragDefine d)
    {
        Vector<UMLObject> members = canvas.getMember();
        Vector<UMLObject> selects = resetSelect();

        Point coordinatedFrom = new Point(Math.min(d.getFrom().x, d.getTo().x), Math.min(d.getFrom().y, d.getTo().y));
        Point coordinatedTo = new Point(Math.max(d.getFrom().x, d.getTo().x), Math.max(d.getFrom().y, d.getTo().y));
        
        for(UMLObject obj: members)
        {
            if(obj.checkSelected(coordinatedFrom, coordinatedTo))
            {
                selects.add(obj);
                obj.switchSelect();
            }
        }
    }

    private Vector<UMLObject> resetSelect()
    {
        Vector<UMLObject> selects = canvas.getSelect();
        for(UMLObject obj: selects)
            obj.switchSelect();
        selects.clear();

        return selects;
    }
}
