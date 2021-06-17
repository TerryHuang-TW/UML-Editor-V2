package coreSection.handler;

import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import coreMember.Canvas;
import coreMember.menuItem.*;

public class MenuHandler extends JMenuBar{
    private Dictionary<String, JMenu> menuList = new Hashtable<>();
    private Canvas canvas;

    //design menu and it's menu items
    public MenuHandler(Canvas canvas)
    {
        this.canvas = canvas;
        createJMenu();
        menuDesign(this.canvas);
    }

    private void createJMenu()
    {
        String[] menuNameList = {"File", "Edit"};
        for(String name: menuNameList)
        {
            menuList.put(name, new JMenu(name));
            this.add(menuList.get(name));
        }
    }

    private void menuDesign(Canvas canvas)
    {
        JMenu nevigateMenu = menuList.get("Edit");
        nevigateMenu.add(new GroupMI("Group", canvas));
        nevigateMenu.add(new UngroupMI("Ungroup", canvas));
        nevigateMenu.add(new ChangeNameMI("Change Name", canvas));
    }

    //set such as clickable, visible etc. Set by other use cases if needed(current project not needed)
    public void setMenuItem()
    {

    }

    //set canvas when changing diagram core as well the canvas(current project not needed)
    public void setCanvas(Canvas canvas)
    {
        
    }
}
