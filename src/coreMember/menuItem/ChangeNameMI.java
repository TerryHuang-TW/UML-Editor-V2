package coreMember.menuItem;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import coreMember.Canvas;
import coreMember.menuItem.tool.NameDialog;
import coreSection.EditorFrame;
import uml.UMLObject;

public class ChangeNameMI extends MenuItem {
    static final int ITEMINDEX = 0;

    public ChangeNameMI(String name, Canvas canvas)
    {
        super(name, canvas);
    }

    @Override
    protected void doMethod() {
        Vector<UMLObject> selects = canvas.getSelect();
        if(selects.size() != 1)
            return;
        UMLObject theSelected = selects.get(ITEMINDEX);
        /*if(theSelected.getMember() != null)
            return;*/
        NameDialog dialog = new NameDialog(theSelected);
    }
}
