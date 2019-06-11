package Configuration;

import Configuration.LoadConfiguration;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class AssetLoading {

    private static ArrayList<Image> defaultWorldTiles = new ArrayList<>();

    static void load() {
        ArrayList<String> tileNames = LoadConfiguration.getDefaultTiles();
        try {
            for (String tileName : tileNames) {
                defaultWorldTiles.add(new Image(new FileInputStream("src/main/resources/Terrain/"
                        + tileName + ".png"),0, 0, true, false));
            }
        }
        catch (FileNotFoundException error) {
            error.printStackTrace();
        }
    }

    public static Image getDefaultWorldTile(int worldId) {
        return defaultWorldTiles.get(worldId - 1);
    }
}
