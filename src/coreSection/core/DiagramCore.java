package coreSection.core;

import coreSection.EditorFrame;
import coreSection.handler.FuncHandler;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import coreMember.Canvas;

public class DiagramCore {
    private EditorFrame editor;
    private FuncHandler fHandler = null;
    private Canvas canvas = null;
    private JPanel corePanel = new JPanel();

    //connect core's attribute to editor
    public DiagramCore(EditorFrame editor)
    {
        this.editor = editor;
        init();
    }

    //set default core and fHandler then add to editor
    private void init()
    {
        setCanvas(new Canvas());
        setFuncHandler(new FuncHandler(canvas));
        setCorePanel();
    }

    //note: still need to work on editor reset when core change
    private void setCorePanel()
    {
        corePanel.removeAll();
        editor.remove(corePanel);
        corePanel.setLayout(new BoxLayout(corePanel, BoxLayout.X_AXIS));
        corePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        corePanel.add(fHandler);
        corePanel.add(Box.createRigidArea(new Dimension(10, 0)));
        corePanel.add(canvas);
        editor.add(corePanel);
    }

    //set canvas and add to editor
    public void setCanvas(Canvas canvas)
    {
        this.canvas = canvas;
    }

    //set funchandler and add to editor
    public void setFuncHandler(FuncHandler fHandler)
    {
        this.fHandler = fHandler;
    }

    public EditorFrame getEditor()
    {
        return editor;
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    //editor call remove(corePanel) when changing core(currently not needed)
    public JPanel getCorePanel()
    {
        return corePanel;
    }
}
