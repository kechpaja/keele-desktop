package tiles;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class TilesGame extends JPanel {

    /**
     * Added to make warning go away
     */
    private static final long serialVersionUID = 2920397780841193815L;

    protected int unitHeight_ = 20; // TODO set for real somewhere by dividing
                                    // screen height by height in units
    // TODO think about how to get unit height in such a way that it's always up
    // to date.

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

    public void play() {
        // Initialization
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.initBlockList();

        // Running the actual game
        while (!this.gameIsOver()) {
            this.incrementBlockList();
            this.displayBlockList();
            this.validate();
            try {
                Thread.sleep(100); // TODO make this speed configurable
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void incrementBlockList() {
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

        // Delete all blocks with size zero
        if (lastSpaceBlock.getHeightInUnits() == 0) {
            this.blockList_.remove(lastSpaceBlock);
        }
    }

    private void initBlockList() {
        this.blockList_ = Collections.synchronizedList(new LinkedList<Block>());
        this.blockList_.add(new Block(50));
    }

    private void displayBlockList() {
        this.removeAll();
        for (Block block : this.blockList_) {
            this.add(block.toComponent(this.unitHeight_));
        }
    }

    private boolean gameHasBeenLost() {
        for (Block block : this.blockList_) {
            if (block.isSpace()) {
                return false;
            }
        }

        return true;
    }

    private boolean gameHasBeenWon() {
        if (!this.queuedBlocks_.isEmpty()) {
            return false;
        }

        for (Block block : this.blockList_) {
            if (!block.isSpace()) {
                return false;
            }
        }

        return true;
    }

    private boolean gameIsOver() {
        return this.gameHasBeenLost() || this.gameHasBeenWon();
    }

}
