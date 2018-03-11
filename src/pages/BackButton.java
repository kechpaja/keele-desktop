package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class BackButton extends JButton implements ActionListener {

    /**
     * Need to keep the compiler happy
     */
    private static final long serialVersionUID = -8478543052255888600L;
    
    private ActivityPanel activityPanel_;
    
    protected BackButton(ActivityPanel activityPanel) {
        super("Back"); // TODO localize this
        this.activityPanel_ = activityPanel;
        this.addActionListener(this);
        this.setActionCommand("go back");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go back")) {
            this.activityPanel_.releaseScreen();
        }
    }

}
