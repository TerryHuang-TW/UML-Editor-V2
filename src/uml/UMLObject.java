package uml;

import java.awt.Point;
import java.util.Vector;
import java.awt.Graphics;

import javax.swing.JPanel;

import uml.item.Item;

public class UMLObject extends JPanel {
    protected boolean isSelected = false;

    //switch select to true or false
    public void switchSelect()
    {
        if(isSelected == false)
            isSelected = true;
        else
            isSelected = false;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // implement graphic here
    }

    //check if selected(click)
    public boolean checkSelected(Point p)
    {
        //implement by Item, GroupItem
        return false;
    }

    //check if selected(drag)
    public boolean checkSelected(Point from, Point to)
    {
        //implement by Item, GroupItem
        return false;
    }

    //pass been connected item
    public Item passItem()
    {
        //implement by Item, GroupItem
        return null;
    }

    //use for ungroup
    public Vector<UMLObject> getMember()
    {
        return null;
    }

    //implement by Item
    public void changeName(String text)
    {

    }

    //implement by Item / GroupItem / Line(wait to better)
    public void refreshUI()
    {

    }
}
