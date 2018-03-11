package tiles;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageTile extends Tile {

    /**
     * Added to keep compiler happy
     */
    private static final long serialVersionUID = 6271081464162395185L;

    private ImageTile(ImageIcon image) {
        this.setIcon(image);
        this.validate();
    }

    public static ImageTile createImageTile(String pathToImage, int height) {
        try {
            Image i = ImageIO.read(new File(pathToImage));
            ImageIcon ii = new ImageIcon(i.getScaledInstance(-1, height, 0));
            return new ImageTile(ii);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null; // TODO this is bad; fix
        }
    }

}
