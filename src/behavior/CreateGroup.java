package behavior;

import java.awt.Point;

import coreMember.Canvas;
import definition.DragDefine;
import uml.UMLObject;

public class CreateGroup implements CreateBehavior {    
	//create item
	@Override
	public void create(Canvas canvas, UMLObject obj, Point p){}

	//create line, group(need to set drag to optimize size)
	@Override
	public void create(Canvas canvas, UMLObject obj, DragDefine d){}

	//create none
	@Override
	public void create(){}
}
