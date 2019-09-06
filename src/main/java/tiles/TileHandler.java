package tiles;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import tiles.regioning.BinRegion;
import tiles.regioning.BinRegionHandler;
import tiles.tileTypes.GenericTile;
import tiles.tileTypes.TerrainTile;
import world.WorldHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Handles the initialization for tiles to be created and the handling/searching of groups of tiles.
 */
public class TileHandler {

    /**
     * Creates necessary bin regions and the tiles to be built on them.
     */
    public static void createTileMap() {
        BinRegionHandler.createBinRegions(WorldHandler.getCurrentWorld());
        TileCreation.populateBinRegions(WorldHandler.getCurrentWorld());
    }

    /**
     * Finds and returns a random tile from a random region that meets the exclusion and open placement requirements.
     * @param size The size of the object that needs a fitting placement on a tile
     * @param terrainToExclude The terrain tiles that are excluded from the search
     * @return The tile found that meets the size and placement requirements
     */
    @Nullable
    @Contract(pure = true)
    public static TerrainTile findRandRegionTile(int size, String ... terrainToExclude) {
        Random random = new Random();
        List<String> exclusions = Arrays.asList(terrainToExclude);
        ArrayList<GenericTile> possibleTiles = new ArrayList<>();

        List<List<BinRegion>> binRegions = BinRegionHandler.getActiveWorldRegions();
        int startRegion = random.nextInt((binRegions.size() * binRegions.size()) - 1);

        return null;
    }
}