package tiles;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tile extends JLabel {

    /**
     * Added to keep compiler happy
     */
    private static final long serialVersionUID = 6271081464162395185L;

    private Tile(ImageIcon image) {
        super(image);
        this.validate();
    }

    public static Tile createImageTile(String pathToImage, int height) {
        try {
            Image i = ImageIO.read(new File(pathToImage));
            ImageIcon ii = new ImageIcon(i.getScaledInstance(-1, height, 0));
            return new Tile(ii);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null; // TODO this is bad; fix
        }
    }

}
