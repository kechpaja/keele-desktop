package main;

import javax.swing.JFrame;

import tiles.TilesGame;

public class AppWindow extends JFrame {

    /**
     * Added to make warning go away
     */
    private static final long serialVersionUID = -263880957870309107L;

    public static void main(String[] args) {
        AppWindow window = new AppWindow();
        window.init();
    }

    private void init() {
        TilesGame game = new TilesGame();
        this.setContentPane(game);

        this.pack();
        this.setVisible(true);

        game.play();
    }

}
