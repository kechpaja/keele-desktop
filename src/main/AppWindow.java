package main;

import javax.swing.JFrame;

import scoring.GameResults;
import tiles.TilesGame;

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
        TilesGame game = new TilesGame();
        this.setContentPane(game);

        this.pack();
        this.setVisible(true);

        GameResults results = game.play();
        System.out.println(results);
        
        this.dispose(); // TODO is this right?
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
