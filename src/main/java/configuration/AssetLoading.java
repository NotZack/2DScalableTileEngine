package configuration;

import javafx.scene.image.Image;
import world.WorldHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AssetLoading {

    public static final int TILE_SIZE = 400;

    public static Image basicTile;
    private static Image nonBasicTile;

    public static void loadCurrentWorldTiles() {
        try {
            if (WorldHandler.getCurrentWorld().getClassification().equals("terrestrial")) {
                basicTile = new Image(new FileInputStream("src/main/resources/Terrain/" + "FlatTerrain.png"));
                nonBasicTile = new Image(new FileInputStream("src/main/resources/Terrain/" + "DesertTerrain.png"));
            }
            else {
                basicTile = new Image(new FileInputStream("src/main/resources/Terrain/" + "DesertTerrain.png"));
                nonBasicTile = new Image(new FileInputStream("src/main/resources/Terrain/" + "FlatTerrain.png"));
            }
        }
        catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }


}
