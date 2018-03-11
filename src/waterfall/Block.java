package waterfall;

import java.awt.Component;

import javax.swing.Box;

public class Block {

    private int heightInUnits_;

    protected Block(int heightInUnits) {
        this.heightInUnits_ = heightInUnits;
    }

    protected Component toComponent(int unitHeight) {
        return Box.createVerticalStrut(unitHeight * this.getHeightInUnits());
    }

    protected boolean isSpace() {
        return true;
    }

    protected int getHeightInUnits() {
        return this.heightInUnits_;
    }

    protected void incrementHeight() {
        this.heightInUnits_ += 1;
    }

    protected void decrementHeight() {
        this.heightInUnits_ -= 1;
    }

}
