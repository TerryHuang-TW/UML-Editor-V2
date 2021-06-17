package behavior;

import java.awt.Point;

import coreMember.Canvas;
import definition.DragDefine;
import uml.UMLObject;

public class CreateNone implements CreateBehavior {
	//create item
	@Override
	public void create(Canvas canvas, UMLObject obj, Point p){}

	//create line, group
	@Override
	public void create(Canvas canvas, UMLObject obj, DragDefine d){}
	
	//create none
	@Override
	public void create(){}
}
