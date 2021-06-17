package coreMember.btn;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import coreMember.btn.mode.Mode;
import coreSection.handler.FuncHandler;

public class FuncBtn extends JButton implements ActionListener {
    protected Mode mode;

    public FuncBtn(String name, Mode mode)
    {
        super(name);
        this.mode = mode;
        this.addActionListener(this);
        init();
    }

    //design default gui
    protected void init()
    {
        this.setFocusPainted(false);
    }

    //change canvas mode and clear canvas's selectedItems vector, and call fhandler to change
    @Override
    public void actionPerformed(ActionEvent e)
    {
        ((FuncHandler) this.getParent()).pressBtn(this);
    }

    public Mode getMode()
    {
        return mode;
    }
}
