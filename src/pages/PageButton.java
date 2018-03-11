package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PageButton extends JButton implements ActionListener {
    
    /*
     * TODO consider having all of the games and text sections available as buttons at the top at all times, 
     * and then also have a button for a lesson select screen. For now, that's not what I'm going to do, but it's
     * probably worth looking into as a refactor to make things a bit cleaner here.
     */

    /**
     * Added to keep compiler happy
     */
    private static final long serialVersionUID = 17615340441372589L;
    
    private static int actionNameCounter_ = 0;
    
    private ActivityPanel activityPanel_;
    private ActivityPanel nextPanel_;
    private String actionName_;
    
    protected PageButton(ActivityPanel activityPanel, ActivityPanel nextPanel, String name) {
        super(name); // TODO localize this
        this.activityPanel_ = activityPanel;
        this.nextPanel_ = nextPanel;
        this.addActionListener(this);
        
        this.actionName_ = "PageButton action " + (PageButton.actionNameCounter_++);
        this.setActionCommand(this.actionName_);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(this.actionName_)) {
            this.nextPanel_.claimScreen(this.activityPanel_.getAppWindow());
        }
    }

}
