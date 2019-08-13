package tiles.regioning;

import configuration.AssetLoading;
import javafx.geometry.BoundingBox;
import javafx.scene.Group;
import javafx.scene.image.ImageView;


public class BinRegion extends Group {

    static final int BIN_REGION_SIZE = 25;

    BinRegion(int x, int y) {
        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    BoundingBox getBoundLimits() {
        return new BoundingBox(this.getLayoutX(), this.getLayoutY(), BIN_REGION_SIZE * AssetLoading.TILE_SIZE, BIN_REGION_SIZE * AssetLoading.TILE_SIZE);
    }

    public void addObject(int x, int y, ImageView objectToAdd) {
        objectToAdd.setLayoutX(x - this.getLayoutX());
        objectToAdd.setLayoutY(y - this.getLayoutY());
        this.getChildren().add(objectToAdd);
    }
}