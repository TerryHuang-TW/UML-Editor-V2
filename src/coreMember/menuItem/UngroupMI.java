package coreMember.menuItem;

import java.util.Vector;

import behavior.CreateBehavior;
import behavior.CreateItem;
import coreMember.Canvas;
import uml.UMLObject;

public class UngroupMI extends MenuItem{
    public UngroupMI(String name, Canvas canvas)
    {
        super(name, canvas);
    }

    @Override
    protected void doMethod() {
        CreateBehavior cBehavior = new CreateItem();    //wait to know depth problem
        Vector<UMLObject> selects = canvas.getSelect();
        Vector<UMLObject> newSelects = new Vector<>();
        Vector<UMLObject> members = canvas.getMember();

        for(UMLObject select: selects)
        {
            Vector<UMLObject> groupMember = select.getMember();
            try
            {
                int depth = 0;
                for(UMLObject member: groupMember)
                {
                    member.setLocation(select.getLocation().x + member.getLocation().x, 
                        select.getLocation().y + member.getLocation().y);
                    canvas.add(member, depth);
                    members.insertElementAt(member, depth);
                    newSelects.add(member);
                    depth += 1;
                }
                members.remove(select);
                canvas.remove(select);
            }
            catch (NullPointerException e)
            {
                System.out.println("Not a GroupItem");
                newSelects.add(select);
            }
        }
        selects.clear();
        for(UMLObject select: newSelects)
            selects.add(select);
    }
}
