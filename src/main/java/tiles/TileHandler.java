package tiles;

import tiles.regioning.BinRegionHandler;
import world.WorldHandler;

public class TileHandler {

    public static void createTileMap() {
        BinRegionHandler.createBinRegions(WorldHandler.getCurrentWorld());
        TileCreation.populateBinRegions(WorldHandler.getCurrentWorld());
    }
}