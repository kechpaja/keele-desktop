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

}
