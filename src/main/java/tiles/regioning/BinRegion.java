package tiles.regioning;

import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import tiles.tileTypes.TerrainTile;

import java.util.ArrayList;

import static configuration.AssetLoading.TILE_SIZE;

/**
 * The base container for all tiles in a world.
 */
public class BinRegion extends Rectangle {

    private ArrayList<TerrainTile> tileChildren = new ArrayList<>();

    static final int BIN_REGION_SIZE = 25;

    /**
     * @param xCoord The x coordinate of the new bin region
     * @param yCoord The y coordinate of the new bin region
     */
    @Contract(pure = true)
    BinRegion(int xCoord, int yCoord) {
        this.setX(xCoord);
        this.setY(yCoord);
        this.setWidth(BIN_REGION_SIZE * TILE_SIZE);
        this.setHeight(BIN_REGION_SIZE * TILE_SIZE);
        this.setOpacity(0);
    }

    /**
     * Sets the given objects coordinates to the given coordinates and adds the given object to this bin region
     * @param x The x coordinate to put the given object at
     * @param y The y coordinate to put the given object at
     * @param objectToAdd The object whose coords are set and is added to this bin region
     */
    public void addObject(int x, int y, @NotNull TerrainTile objectToAdd) {
        objectToAdd.setXCoord(x);
        objectToAdd.setYCoord(y);
        tileChildren.add(objectToAdd);
    }

    /**
     * @return All image views for tiles in this bin region
     */
    public ArrayList<ImageView> getTileImageViews() {
        ArrayList<ImageView> allTileImageViews = new ArrayList<>();
        for (TerrainTile tile :tileChildren) {
            allTileImageViews.add(tile.constructImageView());
        }

        return allTileImageViews;
    }

    /**
     * @return The size of this bin region's tile set
     */
    public int getTileSetSize() {
        return tileChildren.size();
    }
}