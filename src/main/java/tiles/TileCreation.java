package tiles;

import configuration.AssetLoading;
import org.jetbrains.annotations.NotNull;
import tiles.regioning.BinRegionHandler;
import tiles.tileTypes.TerrainTile;
import world.World;

class TileCreation {

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

    private static void createWorldBiomes() {
        //TODO: Implement biomes
    }
}