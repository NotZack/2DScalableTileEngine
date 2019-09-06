package tiles;

import configuration.AssetLoading;
import org.jetbrains.annotations.NotNull;
import tiles.regioning.BinRegionHandler;
import tiles.tileTypes.TerrainTile;
import world.World;

/**
 * Handles the creation of tiles.
 */
class TileCreation {

    /**
     * Creates all the tiles for a given world's bin regions according to world size.
     * @param currentWorld The current world to create tiles for
     */
    static void populateBinRegions(@NotNull World currentWorld) {

        //todo: if save exists: load save else:
        for (int i = 0; i < currentWorld.getTileLength(); i++) {
            for (int j = 0; j < currentWorld.getTileLength(); j++) {
                int xCoord = i * 400;
                int yCoord = j * 400;

                BinRegionHandler.getRegionFromCoords(xCoord, yCoord).addObject(xCoord, yCoord, new TerrainTile(AssetLoading.basicTile, "Grass"));
            }
        }

        createWorldBiomes();
    }

    /**
     * Creates all biomes for a given world. Requires that all basic terrain tiles were created first.
     */
    private static void createWorldBiomes() {
        //TODO: Implement biomes
    }
}