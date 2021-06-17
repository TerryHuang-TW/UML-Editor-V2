package behavior;

import java.awt.Point;
import java.util.Vector;

import coreMember.Canvas;
import definition.AreaDefine;
import definition.DragDefine;
import uml.Port;
import uml.UMLObject;
import uml.item.Item;
import uml.line.Line;

public class CreateLine implements CreateBehavior {
	static final int TOPDEPTH = 0;

    //create item
	@Override
	public void create(Canvas canvas, UMLObject obj, Point p){}

	//create line, group
	@Override
	public void create(Canvas canvas, UMLObject obj, DragDefine d)
	{
		Vector<UMLObject> members = canvas.getMember();
		AreaDefine areaDefine = new AreaDefine();
		Point from = d.getFrom();
		Point to = d.getTo();
		Item fromItem = null;
		Item toItem = null;
		Port fromPort = null;
		Port toPort = null;

		for(UMLObject member: members)
		{
			if(member.checkSelected(from) && fromItem == null)
				fromItem = member.passItem();
			if(member.checkSelected(to) && toItem == null)
				toItem = member.passItem();
			if(fromItem != null && toItem != null)
				break;
		}
		if(fromItem == null || toItem == null)
			return;

		fromPort = areaDefine.decidePort(fromItem.getLocation(), fromItem.getSize(), from, fromItem);
		toPort = areaDefine.decidePort(toItem.getLocation(), toItem.getSize(), to, toItem);
		if(fromPort == null || toPort == null)
			return;

		canvas.getLines().insertElementAt(((Line) obj), TOPDEPTH);
		canvas.add(obj, TOPDEPTH);
		((Line) obj).setPort(fromPort, toPort);
	}
	
	//create none
	@Override
	public void create(){}
}
