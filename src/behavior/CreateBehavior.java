package behavior;

import java.awt.Point;

import coreMember.Canvas;
import definition.DragDefine;
import uml.UMLObject;

public interface CreateBehavior {
	//create item, setting init and add to canvas
	public void create(Canvas canvas, UMLObject obj, Point p);

	//create line, group, setting init and add to canvas
	public void create(Canvas canvas, UMLObject obj, DragDefine d);
	
	//create none
	public void create();
}
