package tiles.regioning;

import configuration.AssetLoading;
import javafx.geometry.BoundingBox;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public class BinRegion extends Quadtree {

    public static final int BIN_REGION_SIZE = 50;

    public BinRegion(int x, int y) {
        this.setLayoutX(x);
        this.setLayoutX(y);
        this.getChildren().add(new Rectangle(((BIN_REGION_SIZE * AssetLoading.TILE_SIZE) - AssetLoading.TILE_SIZE), 0, AssetLoading.TILE_SIZE, AssetLoading.TILE_SIZE));
        this.getChildren().add(new Rectangle(0, ((BIN_REGION_SIZE * AssetLoading.TILE_SIZE) - AssetLoading.TILE_SIZE), AssetLoading.TILE_SIZE, AssetLoading.TILE_SIZE));

        rootTree = new TreeNode(x, y, BIN_REGION_SIZE * AssetLoading.TILE_SIZE);
    }

    static BinRegion findRegion(double x, double y) {
        double binRegionXIndex = ((x - (x % (BIN_REGION_SIZE * AssetLoading.TILE_SIZE) )) / AssetLoading.TILE_SIZE) / BIN_REGION_SIZE;
        double binRegionYIndex = ((y - (y % (BIN_REGION_SIZE * AssetLoading.TILE_SIZE) )) / AssetLoading.TILE_SIZE) / BIN_REGION_SIZE;

        return null;
    }

    BoundingBox getBoundLimits() {
        return new BoundingBox(this.getLayoutX(), this.getLayoutY(), BIN_REGION_SIZE * AssetLoading.TILE_SIZE, BIN_REGION_SIZE * AssetLoading.TILE_SIZE);
    }

    public void addObject(int x, int y, ImageView objectToAdd) {
        objectToAdd.setLayoutX(x);
        objectToAdd.setLayoutY(y);
        insert(x, y, objectToAdd);
    }
}