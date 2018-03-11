package pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GrammarButton extends JButton implements ActionListener {
    
    /*
     * TODO consider having all of the games and text sections available as buttons at the top at all times, 
     * and then also have a button for a lesson select screen. For now, that's not what I'm going to do, but it's
     * probably worth looking into as a refactor to make things a bit cleaner here. 
     * 
     * TODO it will also be fairly easy to generalize this button class. But let's do that refactoring when it's
     * actually time to think about it. 
     */

    /**
     * Added to keep compiler happy
     */
    private static final long serialVersionUID = 17615340441372589L;
    
    private ActivityPanel activityPanel_;
    private GrammarPage grammarPage_;
    
    protected GrammarButton(ActivityPanel activityPanel, GrammarPage grammarPage) {
        super("Grammar"); // TODO localize this
        this.activityPanel_ = activityPanel;
        this.grammarPage_ = grammarPage;
        this.addActionListener(this);
        this.setActionCommand("grammar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("grammar")) {
            this.grammarPage_.claimScreen(this.activityPanel_.getAppWindow());
        }
    }

}
