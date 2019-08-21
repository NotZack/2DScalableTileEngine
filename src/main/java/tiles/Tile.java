package tiles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.Contract;

public class Tile {

    private Image tileImage;
    private int xCoord;
    private int yCoord;

    @Contract(pure = true)
    Tile(Image tileImage) {
        this.tileImage = tileImage;
    }

    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    public ImageView constructImageView() {
        ImageView newImageView = new ImageView(tileImage);
        newImageView.setX(xCoord);
        newImageView.setY(yCoord);
        return newImageView;
    }
}
