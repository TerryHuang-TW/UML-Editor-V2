package uml;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import java.util.Vector;

public class GroupItem extends UMLObject {
    private Vector<UMLObject> memberObjs = new Vector<>();

    public GroupItem()
    {
        init();
    }

    private void init()
    {
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setOpaque(false);
    }
    
    //add member to groupItem and vector
    public void addMember(Vector<UMLObject> newGroup)
    {
        for(UMLObject member: newGroup)
        {
            this.add(member);
            memberObjs.add(member);
            member.setLocation(member.getLocation().x - this.getLocation().x, 
                member.getLocation().y - this.getLocation().y);
        }
    }

    @Override
    public void refreshUI()
    {
        for(UMLObject obj: memberObjs)
            obj.refreshUI();
    }
    
    @Override
    public Vector<UMLObject> getMember()
    {
        return memberObjs;
    }

    @Override
    public void switchSelect()
    {
        for(UMLObject member: memberObjs)
            member.switchSelect();
    }
    
    @Override
    public boolean checkSelected(Point p)
    {
        Point location = this.getLocation();       
        Point relateLocation = new Point(p.x - location.x, p.y - location.y);

        for(UMLObject member: memberObjs)
        {
            if(member.checkSelected(relateLocation))
                return true;
        }
        return false;
    }

    @Override
    public boolean checkSelected(Point from, Point to)
    {
        Point coordinatedFrom = new Point(Math.min(from.x, to.x), Math.min(from.y, to.y));
        Point coordinatedTo = new Point(Math.max(from.x, to.x), Math.max(from.y, to.y));
        Point location = this.getLocation();
        Dimension size = this.getSize();
        ////////// WAIT FOR BETTER IMPLEMENTATION (IMPROVEMENT 7) //////////
        /*if(coordinatedFrom.x <= location.x && location.x + size.width <= coordinatedTo.x)
        {
            if(coordinatedFrom.y <= location.y && location.y + size.height <= coordinatedTo.y)
            {
                return true;
            }
        }*/
        for(UMLObject member: memberObjs)
        {
            if(member.checkSelected(coordinatedFrom, coordinatedTo))
                return true;
        }
        return false;
    }
}
