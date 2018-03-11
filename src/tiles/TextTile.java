package tiles;

public class TextTile extends Tile {
    
    /**
     * Added to keep compiler happy
     */
    private static final long serialVersionUID = -8156195669478569511L;

    private TextTile(String text) {
        this.setText(text); // TODO is this right?
        this.validate();
    }
    
    public static TextTile createTextTile(String text, int height, int width) {
        TextTile tile = new TextTile(text);
        tile.setSize(width, height); // TODO does this work? 
        return tile;
    }

}
