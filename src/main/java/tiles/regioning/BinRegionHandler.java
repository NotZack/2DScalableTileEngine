package tiles.regioning;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import world.World;
import world.WorldHandler;

import java.util.ArrayList;
import java.util.List;

import static configuration.AssetLoading.TILE_SIZE;
import static tiles.regioning.BinRegion.BIN_REGION_SIZE;

/**
 * Handles the creation and searching of bin regions.
 */
public class BinRegionHandler {

    private static List<List<BinRegion>> activeWorldRegions = new ArrayList<>();

    /**
     * Creates all the bin regions for a given world according to world size.
     * @param newWorld The new world to create the bin regions for
     */
    public static void createBinRegions(@NotNull World newWorld) {

        int numOfRegions = newWorld.getTileLength() / (BIN_REGION_SIZE);

        if (newWorld.getTileLength() % BIN_REGION_SIZE > 0) numOfRegions += 1;

        for (int i = 0; i < numOfRegions; i++) {
            activeWorldRegions.add(new ArrayList<>());
            for (int j = 0; j < numOfRegions; j++) {
                BinRegion newRegion = new BinRegion(i * (BIN_REGION_SIZE * TILE_SIZE), j * (BIN_REGION_SIZE * TILE_SIZE));

                //TODO: Add dynamic drawing (add only needed bin regions to world node aka root node)
                activeWorldRegions.get(i).add(newRegion);
            }
        }
    }

    /**
     * Finds the bin region that contains the given coordinates.
     * @param x The x coordinate of the bin region search
     * @param y The y coordinate of the bin region search
     * @return The bin region whose bounds contain the given coordinate
     */
    public static BinRegion getRegionFromCoords(int x, int y) {
        int xBinRegion = (x - (x % (BIN_REGION_SIZE * TILE_SIZE))) / (BIN_REGION_SIZE * TILE_SIZE);
        int yBinRegion = (y - (y % (BIN_REGION_SIZE * TILE_SIZE))) / (BIN_REGION_SIZE * TILE_SIZE);
        return activeWorldRegions.get(xBinRegion).get(yBinRegion);
    }

    /**
     * @return The bin regions for the current active world
     */
    @Contract(pure = true)
    public static List<List<BinRegion>> getActiveWorldRegions() {
        return activeWorldRegions;
    }
}
