package tiles;

import world.World;
import world.WorldHandler;

import static configuration.AssetLoading.TILE_SIZE;
import static tiles.regioning.BinRegion.BIN_REGION_SIZE;

public class TileHandler {

    public static void createTileMap() {
        World currentWorld = WorldHandler.getCurrentWorld();

        int numberOfBinRegions = (currentWorld.getSize() / (BIN_REGION_SIZE * TILE_SIZE));
        if (currentWorld.getSize() % (BIN_REGION_SIZE * TILE_SIZE) > 0) numberOfBinRegions +=1;

        //TODO: Implement partially filled bin regions
        for (int i = 0; i < numberOfBinRegions; i++) {
            System.out.println("# of binRegions: " + (i + 1));
        }
    }
}