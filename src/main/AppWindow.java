package main;

import java.io.FileNotFoundException;

import javax.swing.JFrame;

import pages.GrammarPage;
import pages.LessonHomePage;
import lessons.Lesson;
import lessons.LessonManager;
import scoring.GameResults;
import waterfall.ImageWordWaterfall;
import waterfall.Waterfall;

public class AppWindow extends JFrame {

    /**
     * Added to make warning go away
     */
    private static final long serialVersionUID = -263880957870309107L;

    public static void main(String[] args) {
        AppWindow window = new AppWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.init();
    }

    private void init() {
        Lesson lesson = null;
        try {
            lesson = LessonManager.loadLesson("/home/kechpaja/dev/keele/test-lessons/horn");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //GrammarPage grammarPage = new GrammarPage(lesson.getGrammar());
        //grammarPage.claimScreen(this);
        
        LessonHomePage lhp = new LessonHomePage(lesson);
        lhp.claimScreen(this);
        
        
        
//        Waterfall game = new ImageWordWaterfall(lesson);
//        this.setContentPane(game);
//
        this.pack();
        this.setVisible(true);
//
//        GameResults results = game.play();
//        System.out.println(results);
        
        //this.dispose(); // TODO is this right?
    }
    
    /*
     * TODO
     * 
     *  - Some way to select which lesson to enter
     *  
     *  - More stuff in the lesson than just the game. There should be room for a brief chapter on grammar, or something like that.
     *  
     *  - A page where all vocab is presented together
     */
    
    

}
