package pages;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JPanel;

import main.AppWindow;

public abstract class ActivityPanel extends JPanel {

    /**
     * Added to keep the compiler happy
     */
    private static final long serialVersionUID = 6341837103364062283L;
    
    private Container previousScreen_;
    private AppWindow appWindow_;
    
    protected ActivityPanel() {
        this.setLayout(new BorderLayout());
        this.add(new BackButton(this), BorderLayout.PAGE_START);
    }
    
    public void claimScreen(AppWindow appWindow) {
        this.appWindow_ = appWindow;
        this.previousScreen_ = appWindow.getContentPane();
        
        appWindow.setContentPane(this);
        appWindow.revalidate();
        
        this.init(); 
    }
    
    protected void releaseScreen() {
        this.appWindow_.setContentPane(this.previousScreen_);
        this.appWindow_.revalidate();
    }
    
    protected void init() { /* Do nothing (overridden in some subclasses) */ }
    
    protected AppWindow getAppWindow() {
        return this.appWindow_;
    }

}
