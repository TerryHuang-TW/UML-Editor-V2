package coreMember;

import java.util.Vector;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import coreMember.btn.mode.Mode;
import listener.CanvasListener;
import uml.line.Line;
import uml.UMLObject;

public class Canvas extends JPanel {
    private Vector<UMLObject> memberItems = new Vector<>();
    private Vector<UMLObject> selectedItems = new Vector<>();
    private Vector<Line> memberLines = new Vector<>();
    private CanvasListener listener = new CanvasListener();

    //add and pass mode to listener
    public Canvas()
    {
        init();
    }

    //set default gui
    private void init()
    {
        this.setLayout(null);
        this.setBackground(Color.WHITE);     
        this.setBorder(new LineBorder(Color.BLACK));
        this.addMouseListener(listener);
    }

    //reference from "Project" project's canvashandler.repaintComp()
    //use when create, select, ungroup any kind of ui refresh
    //and including self updateUI()
    //NEED TO COMBINE UMLOBJECT AND LINE TO SET MEMBERITEMS -> MEMBERS
    public void refreshUI()
    {
        for(UMLObject obj: memberItems)
            obj.refreshUI();
        for(Line line: memberLines)
            line.refreshLine();
        this.updateUI();
    }

    //set listener's mode when button actionPerformed(), which means btn is clicked
    public void switchMode(Mode mode)
    {
        for(UMLObject obj: selectedItems)
            obj.switchSelect();
        selectedItems.clear();
        listener.setMode(mode);
        this.refreshUI();
    }

    //mode get member
    public Vector<UMLObject> getMember()
    {
        return memberItems;
    }

    //mode get select
    public Vector<UMLObject> getSelect()
    {
        return selectedItems;
    }

    //mode get memberLines
    public Vector<Line> getLines()
    {
        return memberLines;
    }
}
