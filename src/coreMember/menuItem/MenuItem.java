package coreMember.menuItem;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import coreMember.Canvas;

public abstract class MenuItem extends JMenuItem implements ActionListener{
    protected Canvas canvas;

    public MenuItem(String name, Canvas canvas)
    {
        super(name);
        this.canvas = canvas;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        doMethod();
        canvas.refreshUI();
    }

    //every menu item implement function here
    protected abstract void doMethod();
}
