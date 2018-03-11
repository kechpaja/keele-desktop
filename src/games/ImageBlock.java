package games;

import java.awt.Component;
import java.util.Set;

public class ImageBlock extends AnswerableBlock {

    private String pathToImage_;

    protected ImageBlock(String pathToImage, Set<String> possibleAnswers) {
        super(7, possibleAnswers); // TODO make image height configurable?
        this.pathToImage_ = pathToImage;
    }

    protected Component toComponent(int unitHeight) {
        return ImageTile.createImageTile(this.pathToImage_, unitHeight * this.getHeightInUnits());
    }

    protected boolean isSpace() {
        return false;
    }

}
