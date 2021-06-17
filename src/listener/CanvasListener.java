package listener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import coreMember.btn.mode.Mode;
import definition.DragDefine;

public class CanvasListener implements MouseListener {
    Point from = new Point();
    Point to = new Point();
    /*UMLObject fromObj;
    UMLObject toObj;*/      //uncertain whether implement or not
    Mode mode;
    
    public CanvasListener()
    {

    }

    public void setMode(Mode mode)
    {
        this.mode = mode;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        from = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        to = e.getPoint();
        try
        {
            if(from.equals(to))
                mode.performFunc(e.getPoint());
            else
            {
                DragDefine drag = new DragDefine(from, to);
                mode.performFunc(drag);
            }
        }
        catch(Exception exception)
        {
            System.out.println("Listener pass parameter failure message: " + exception);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
