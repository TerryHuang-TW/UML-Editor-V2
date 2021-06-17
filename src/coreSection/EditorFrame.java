package coreSection;

import javax.swing.JFrame;
import java.awt.Dimension;

import coreSection.core.DiagramCore;
import coreSection.handler.MenuHandler;

public class EditorFrame extends JFrame{
    static final Dimension minFrameSize = new Dimension(800, 600);
    private DiagramCore core;
    private MenuHandler mHandler;

    public EditorFrame(String name)
    {
        super(name);
        init();
    }

    //init gui setting
    private void init()
    {
        setCore(new DiagramCore(this));
        setMenu(new MenuHandler(core.getCanvas()));
        setMainFrame();
    }

    public void setMainFrame()
    {
        this.setSize(minFrameSize);
        this.setVisible(true);
		this.setLocationRelativeTo(null);
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //create core
    public void setCore(DiagramCore core)
    {
        this.core = core;
    }

    //create menu handler
    public void setMenu(MenuHandler mHandler)
    {
        this.mHandler = mHandler;
        this.setJMenuBar(this.mHandler);
    }

    public DiagramCore getCore()
    {
        return core;
    }
}
