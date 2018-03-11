package pages;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import lessons.Lesson;

public class LessonHomePage extends ActivityPanel {

    /**
     * Added to keep compiler happy
     */
    private static final long serialVersionUID = 7755506559336630453L;
    
    private Lesson lesson_;
    
    public LessonHomePage(Lesson lesson) {
        this.lesson_ = lesson;
        //this.add(new JLabel("<h1>Welcome to lesson X!</h1>"), BorderLayout.PAGE_START); // TODO localize
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        
        // TODO add necessary buttons
        GrammarButton grammarButton = new GrammarButton(this, new GrammarPage(lesson.getGrammar()));
        panel.add(grammarButton);
        
        
        this.add(panel, BorderLayout.CENTER);
    }

}
