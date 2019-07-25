package configuration;

import javafx.scene.image.Image;
import world.WorldHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AssetLoading {

    public static final int TILE_SIZE = 400;

    private static Image basicTile;
    private static Image nonBasicTile;

    public static void loadCurrentWorldTiles() {
        try {
            if (WorldHandler.getCurrentWorld().getClassification().equals("terrestrial")) {
                basicTile = new Image(new FileInputStream("src/main/resources/Terrain/"
                        + "FlatTerrain.png"),0, 0, true, false);
                nonBasicTile = new Image(new FileInputStream("src/main/resources/Terrain/"
                        + "DesertTerrain.png"),0, 0, true, false);
            }
            else {
                basicTile = new Image(new FileInputStream("src/main/resources/Terrain/"
                        + "DesertTerrain.png"),0, 0, true, false);
                nonBasicTile = new Image(new FileInputStream("src/main/resources/Terrain/"
                        + "FlatTerrain.png"),0, 0, true, false);
            }

        }
        catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }
}
