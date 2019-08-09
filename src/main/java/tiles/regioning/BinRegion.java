package tiles.regioning;

import configuration.AssetLoading;
import javafx.geometry.BoundingBox;
import javafx.scene.image.ImageView;


public class BinRegion extends Quadtree {

    static final int BIN_REGION_SIZE = 50;

    BinRegion(int x, int y) {
        this.setLayoutX(x);
        this.setLayoutY(y);

        rootTree = new TreeNode(x, y, BIN_REGION_SIZE * AssetLoading.TILE_SIZE);
    }

    BoundingBox getBoundLimits() {
        return new BoundingBox(this.getLayoutX(), this.getLayoutY(), BIN_REGION_SIZE * AssetLoading.TILE_SIZE, BIN_REGION_SIZE * AssetLoading.TILE_SIZE);
    }

    public void addObject(int x, int y, ImageView objectToAdd) {
        objectToAdd.setLayoutX(x - this.getLayoutX());
        objectToAdd.setLayoutY(y - this.getLayoutY());
        insert(x, y, objectToAdd);
    }
}