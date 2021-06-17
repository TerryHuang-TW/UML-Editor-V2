package behavior;

import java.awt.Point;
import java.util.Vector;

import coreMember.Canvas;
import definition.DragDefine;
import uml.UMLObject;

public class CreateItem implements CreateBehavior {
	static final int TOPDEPTH = 0;

    //create item
	@Override
	public void create(Canvas canvas, UMLObject obj, Point p)
	{
		Vector<UMLObject> members = canvas.getMember();
		members.insertElementAt(obj, TOPDEPTH);
		canvas.add(obj, TOPDEPTH);
		obj.setLocation(p);
	}

	//create line, group
	@Override
	public void create(Canvas canvas, UMLObject obj, DragDefine d){}

	//create none
	@Override
	public void create(){}
}
