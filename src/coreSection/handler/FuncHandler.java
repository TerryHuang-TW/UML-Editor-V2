package coreSection.handler;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import behavior.CreateItem;
import behavior.CreateLine;
import behavior.CreateNone;
import coreMember.Canvas;
import coreMember.btn.AssociationBtn;
import coreMember.btn.ClassBtn;
import coreMember.btn.CompositionBtn;
import coreMember.btn.FuncBtn;
import coreMember.btn.GeneralizationBtn;
import coreMember.btn.SelectBtn;
import coreMember.btn.UseCaseBtn;
import coreMember.btn.mode.AssociationMode;
import coreMember.btn.mode.ClassMode;
import coreMember.btn.mode.CompositionMode;
import coreMember.btn.mode.GeneralizationMode;
import coreMember.btn.mode.Mode;
import coreMember.btn.mode.SelectMode;
import coreMember.btn.mode.UseCaseMode;


public class FuncHandler extends JPanel{
    static final int boundDistance = 10;
    static final Rectangle funcBound = new Rectangle(100, 40);
    static final Dimension maxPanelSize = new Dimension(400, 600);
    static final String defaultBtnName = "Select";
    static final int defaultBtnIndex = 0;
    private Canvas canvas;
    private FuncBtn currentBtn = null;

    //add handler to editor
    public FuncHandler(Canvas canvas)
    {
        this.canvas = canvas;
        init();
    }

    //design panel and add btn
    protected void init()
    {
        this.setLayout(new GridBagLayout());
        FuncBtn[] customizeBtns = new FuncBtn[]{
            new SelectBtn("Select", new SelectMode(canvas, new CreateNone())),
            new AssociationBtn("Association", new AssociationMode(canvas, new CreateLine())),
            new GeneralizationBtn("Generalization", new GeneralizationMode(canvas, new CreateLine())),
            new CompositionBtn("Composition", new CompositionMode(canvas, new CreateLine())),
            new ClassBtn("Class", new ClassMode(canvas, new CreateItem())),
            new UseCaseBtn("Use Case", new UseCaseMode(canvas, new CreateItem()))
        };
        currentBtn = customizeBtns[defaultBtnIndex];
        pressBtn(currentBtn);
        addBtn(customizeBtns);
        //this.setBorder(new LineBorder(Color.GRAY));
        this.setMaximumSize(maxPanelSize);
    }

    //REALLY need a better implementation
    public void pressBtn(FuncBtn btn)
    {
        releaseBtn(currentBtn);
        int originwidth = btn.getPreferredSize().width;
		int originheight = btn.getPreferredSize().height;
        Dimension originalSize = new Dimension(originwidth, originheight);
        Border pressBorder = BorderFactory.createLoweredBevelBorder();
        btn.setBorder(pressBorder);
        btn.setPreferredSize(originalSize);
        setCurrentBtn(btn);  
    }

    private void releaseBtn(FuncBtn btn)
    {
        /*try
        {*/
        Border releaseBorder = new JButton().getBorder();
        btn.setBorder(releaseBorder);
        /*}
        catch(Exception exception)
        {
            System.out.println("releaseBtn method exception message: " + exception);
        }*/
    }

    private void addBtn(FuncBtn[] customizeBtns)
    {
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridy = 0;
        for(FuncBtn btn: customizeBtns)
        {
            //btn.setFocusPainted(false);     //call here beacause btn can't call at init(). Fook! -> Cause I'm dumb override init()
            this.add(btn, con);
            con.gridy += 1;
            this.add(Box.createRigidArea(new Dimension(0, 15)), con);
            con.gridy += 1;
        }
    }

    //set canvas and change btn's mode(currently not implementing)
    public void setCanvas(Canvas canvas)
    {

    }

    //change canvas mode and clear canvas's selectedItems vector, and call fhandler to change
    private void setCurrentBtn(FuncBtn btn)
    {
        currentBtn = btn;
        canvas.switchMode(currentBtn.getMode());
    }

    //pass default mode to canvas -> listener
    public Mode getDefaultMode()
    {
        return currentBtn.getMode(); 
    }

    public FuncBtn getCurrentBtn()
    {
        return currentBtn;
    }
}
