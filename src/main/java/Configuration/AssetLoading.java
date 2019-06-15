package Configuration;

import javafx.scene.image.Image;
import world.WorldHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AssetLoading {

    private static ArrayList<Image> defaultWorldTiles = new ArrayList<>();

    public static void load() {
        ArrayList<String> tileNames = LoadConfiguration.getDefaultTiles();
        try {
            for (int i = 0; i < tileNames.size(); i++) {
                defaultWorldTiles.add(new Image(new FileInputStream("src/main/resources/Terrain/"
                        + tileNames.get(i) + ".png"),0, 0, true, false));
                WorldHandler.getWorld(i + 1).setBasicTile(defaultWorldTiles.get(defaultWorldTiles.size() - 1));
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
