package tiles.tileTypes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.Contract;

public abstract class GenericTile {

    private Image tileImage;
    private String tileCategory;
    private int xCoord;
    private int yCoord;

    @Contract(pure = true)
    GenericTile(Image tileImage, String tileCategory) {
        this.tileImage = tileImage;
        this.tileCategory = tileCategory;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    String getTileCategory() {
        return tileCategory;
    }

    public ImageView constructImageView() {
        ImageView newImageView = new ImageView(tileImage);
        newImageView.setX(xCoord);
        newImageView.setY(yCoord);
        return newImageView;
    }
}
