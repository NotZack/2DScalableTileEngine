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

public class TileHandler {

    public static void createTileMap() {
        BinRegionHandler.createBinRegions(WorldHandler.getCurrentWorld());
        TileCreation.populateBinRegions(WorldHandler.getCurrentWorld());
    }

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