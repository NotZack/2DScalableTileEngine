package tiles.regioning;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tiles.tileTypes.TerrainTile;

import java.util.ArrayList;

import static configuration.AssetLoading.TILE_SIZE;

public class BinRegion extends Rectangle {

    private ArrayList<TerrainTile> tileChildren = new ArrayList<>();

    static final int BIN_REGION_SIZE = 25;

    @Contract(pure = true)
    BinRegion(int xCoord, int yCoord) {
        this.setX(xCoord);
        this.setY(yCoord);
        this.setWidth(BIN_REGION_SIZE * TILE_SIZE);
        this.setHeight(BIN_REGION_SIZE * TILE_SIZE);
        this.setOpacity(0);
    }

    public void addObject(int x, int y, @NotNull TerrainTile objectToAdd) {
        objectToAdd.setXCoord(x);
        objectToAdd.setYCoord(y);
        tileChildren.add(objectToAdd);
    }

    public ArrayList<ImageView> getTileImageViews() {
        ArrayList<ImageView> allTileImageViews = new ArrayList<>();
        for (TerrainTile tile :tileChildren) {
            allTileImageViews.add(tile.constructImageView());
        }

        return allTileImageViews;
    }

    public int getTileSetSize() {
        return tileChildren.size();
    }
}