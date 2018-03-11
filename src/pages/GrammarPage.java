package pages;

import java.awt.BorderLayout;


//import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class GrammarPage extends ActivityPanel {

    /**
     * Added to keep compiler happy
     */
    private static final long serialVersionUID = 3301859358004448722L;
    
    private JTextPane text_;
    
    // Content should be formatted using HTML. 
    public GrammarPage(String content) {
        this.text_ = new JTextPane();
        this.text_.setContentType("text/html");
        this.text_.setText(content);
        this.text_.setEditable(false);
        
        JScrollPane scrollable = new JScrollPane(this.text_);
        
        //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        //this.setLayout(new BorderLayout());
        this.add(scrollable, BorderLayout.CENTER);
        this.validate();
    }

}
