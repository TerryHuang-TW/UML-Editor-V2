package coreMember.menuItem;

import java.util.Vector;

import java.awt.Point;

import coreMember.Canvas;
import uml.GroupItem;
import uml.UMLObject;
import uml.line.Line;

public class GroupMI extends MenuItem {
    static final int TOPDEPTH = 0;

    public GroupMI(String name, Canvas canvas)
    {
        super(name, canvas);
    }

    @Override
    protected void doMethod() {
        Vector<UMLObject> selects = canvas.getSelect();
        Vector<UMLObject> members = canvas.getMember();
        Vector<Line> lines = canvas.getLines();
        Vector<UMLObject> newMember = new Vector<>();
        GroupItem group = new GroupItem();
        int minX = Integer.MIN_VALUE;
        int minY = Integer.MIN_VALUE;
        int maxX = Integer.MAX_VALUE;
        int maxY = Integer.MAX_VALUE;

        if(selects.size() <= 1)
            return;
        
        for(UMLObject select: selects)
        {
            minX = Math.min(minX, select.getLocation().x);
            minY = Math.min(minY, select.getLocation().y);
            maxX = Math.max(maxX, select.getLocation().x + select.getSize().width);
            maxY = Math.max(maxY, select.getLocation().y + select.getSize().height);
            newMember.add(select);
            members.remove(select);
        }

        Point minPoint = new Point(minX, minY);
        Point maxPoint = new Point(maxX, maxY);
        ////////// WAIT FOR BETTER IMPLEMENTATION (IMPROVEMENT 7) //////////
        //group.setSize(maxPoint.x - minPoint.x, maxPoint.y - minPoint.y);
		//group.setLocation(minPoint);
        group.setSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        group.setLocation(0, 0);
        group.addMember(newMember);
        canvas.add(group, TOPDEPTH);
        members.insertElementAt(group, TOPDEPTH);
        selects.clear();
        selects.add(group);
    }
}
