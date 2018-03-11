package games;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class AnswerField extends JTextField implements KeyListener {

    /**
     * Added to make warning go away. 
     */
    private static final long serialVersionUID = 3983519022395130284L;
    
    private TilesGame game_;
    
    protected AnswerField(TilesGame game) {
        this.game_ = game;
        this.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.game_.checkAnswer(this.getText().trim());
            this.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) { /* Do nothing. */ }

    @Override
    public void keyTyped(KeyEvent arg0) { /* Do nothing. */ }

}
