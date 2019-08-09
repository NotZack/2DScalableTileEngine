package tiles;

import configuration.AssetLoading;
import tiles.regioning.BinRegionHandler;
import world.World;

class TileCreation {

    static void populateBinRegions(World currentWorld) {

        //if save exists: load save else:

        for (int i = 0; i < currentWorld.getTileLength(); i++) {
            for (int j = 0; j < currentWorld.getTileLength(); j++) {
                int xCoord = i * 400;
                int yCoord = j * 400;

                System.out.println(xCoord);
                System.out.println(yCoord);
                BinRegionHandler.getRegionFromCoords(xCoord, yCoord).addObject(xCoord, yCoord, new Tile(AssetLoading.basicTile));
            }
        }
    }
}
