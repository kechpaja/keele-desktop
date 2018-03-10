package tiles;

import java.awt.BorderLayout;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import scoring.GameResults;

public class TilesGame extends JPanel {

    /**
     * Added to make warning go away
     */
    private static final long serialVersionUID = 2920397780841193815L;

    protected int unitHeight_ = 20; // TODO set for real somewhere by dividing
                                    // screen height by height in units
    // TODO think about how to get unit height in such a way that it's always up
    // to date.
    private int tickLength_ = 100; // In milliseconds; TODO make configurable
    
    private long endTime_; // TODO to be set later when game is won. 

    private List<Block> blockList_;
    private Queue<Block> queuedBlocks_;

    public TilesGame() {
        // TODO take set as input, and convert it to list of queued blocks. Be
        // sure to shuffle.
        this.queuedBlocks_ = new LinkedList<Block>();
        
        Set<String> hornset = new HashSet<String>();
        hornset.add("horn");
        this.queuedBlocks_.add(new ImageBlock("horn.jpg", hornset));
        
        Set<String> cornuset = new HashSet<String>();
        cornuset.add("cornu");
        this.queuedBlocks_.add(new ImageBlock("horn.jpg", cornuset));
    }

    /*
     * Screen is 50 units high. A Unit is defined as one 50th of the screen's
     * height in pixels. Pictures are probably 7 units high, although that is
     * perhaps configurable and will definitely be updated. Everything moves
     * down one unit every tick, but once blocks hit the bottom they stop.
     * 
     * *OR* we can have blocks fall off the bottom, and just get lost. Then you
     * win by making a certain number of points, regardless of whether you win
     * or lose tetris-style.
     */

    public GameResults play() {
        // Initialization
        this.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        AnswerField answerField = new AnswerField(this);
        
        this.add(panel, BorderLayout.CENTER);
        this.add(answerField, BorderLayout.PAGE_END);
        this.initBlockList();

        // Running the actual game
        long startTime = System.currentTimeMillis(); // TODO where to get end time for accurate reporting of play time?
        while (!this.gameIsOver()) {
            this.incrementBlockList();
            this.displayBlockList(panel);
            this.revalidate();
            try {
                Thread.sleep(this.tickLength_);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Need to redisplay at the end.
        // TODO add some sort of victory or loss screen?
        this.displayBlockList(panel);
        this.revalidate();
        
        return new GameResults(this.endTime_ - startTime, this.gameHasBeenWon());
    }
    
    protected void checkAnswer(String answer) {
        synchronized (this.blockList_) {
            AnswerableBlock lastAnswerableBlock = null;
            if (this.blockList_.get(this.blockList_.size() - 1).isSpace()) {
                if (this.blockList_.size() <= 1) {
                    return; 
                }
                
                lastAnswerableBlock = (AnswerableBlock) this.blockList_.get(this.blockList_.size() - 2);
                
                if (lastAnswerableBlock.isPossibleAnswer(answer)) {
                    int height = lastAnswerableBlock.getHeightInUnits();
                    
                    // remove preceding block if it is space block
                    if (this.blockList_.get(this.blockList_.size() - 3).isSpace()) {
                        height += this.blockList_.get(this.blockList_.size() - 3).getHeightInUnits();
                        this.blockList_.remove(this.blockList_.size() - 3);
                    }
                    
                    // Remove last answerable block from list
                    this.blockList_.remove(lastAnswerableBlock);
                    
                    // Remove following block
                    height += this.blockList_.get(this.blockList_.size() - 1).getHeightInUnits();
                    this.blockList_.remove(this.blockList_.size() - 1);
                    
                    // insert new space block
                    this.blockList_.add(this.blockList_.size(), new Block(height));
                }
            } else {
                lastAnswerableBlock = (AnswerableBlock) this.blockList_.get(this.blockList_.size() - 1);
                
                if (lastAnswerableBlock.isPossibleAnswer(answer)) {
                    int height = lastAnswerableBlock.getHeightInUnits();
                    
                    // remove preceding block if it is space block
                    if (this.blockList_.get(this.blockList_.size() - 2).isSpace()) {
                        height += this.blockList_.get(this.blockList_.size() - 2).getHeightInUnits();
                        this.blockList_.remove(this.blockList_.size() - 2);
                    }
                    
                    // Remove last answerable block from list
                    this.blockList_.remove(lastAnswerableBlock);
                    
                    // insert new space block
                    this.blockList_.add(this.blockList_.size(), new Block(height));
                }
            }
        }
        
        if (this.gameHasBeenWon()) {
            this.endTime_ = System.currentTimeMillis();
        }
    }

    private void incrementBlockList() {
        synchronized (this.blockList_) {
            // Find bottom-most block that is space
            Block lastSpaceBlock = null;
            for (Block block : this.blockList_) {
                if (block.isSpace()) {
                    lastSpaceBlock = block;
                }
            }
    
            // If this is also top-most block, then add an ImageBlock and a space
            // block of mutually counteracting sizes
            if (lastSpaceBlock == this.blockList_.get(0)) {
                if (this.queuedBlocks_.isEmpty()) {
                    return;
                }
    
                Block nextBlock = this.queuedBlocks_.poll();
                this.blockList_.add(0, nextBlock);
                this.blockList_.add(0, new Block(0 - nextBlock.getHeightInUnits()));
            }
    
            // Remove one unit from size of bottom-most space block, and add one to
            // top-most block (which will always be a space block)
            lastSpaceBlock.decrementHeight();
            this.blockList_.get(0).incrementHeight();
    
            // Delete last space block if it has height zero
            if (lastSpaceBlock.getHeightInUnits() == 0) {
                this.blockList_.remove(lastSpaceBlock);
            }
        }
    }

    private void initBlockList() {
        this.blockList_ = new LinkedList<Block>();
        this.blockList_.add(new Block(50));
    }

    private void displayBlockList(JPanel panel) {
        synchronized (this.blockList_) {
            panel.removeAll();
            for (Block block : this.blockList_) {
                panel.add(block.toComponent(this.unitHeight_));
            }
        }
    }

    private boolean gameHasBeenLost() {
        synchronized (this.blockList_) {
            for (Block block : this.blockList_) {
                if (block.isSpace()) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean gameHasBeenWon() {
        if (!this.queuedBlocks_.isEmpty()) {
            return false;
        }

        synchronized (this.blockList_) {
            for (Block block : this.blockList_) {
                if (!block.isSpace()) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean gameIsOver() {
        return this.gameHasBeenLost() || this.gameHasBeenWon();
    }

}
