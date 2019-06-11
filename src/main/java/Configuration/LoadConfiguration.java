package Configuration;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LoadConfiguration {

    private static ArrayList<String> defaultTiles = new ArrayList<>();
    private static ArrayList<WorldConfiguration> worldConfigurations = new ArrayList<>();

    public static void load() {
        Ini ini = null;
        try {
            ini = new Ini(new File("src/main/configuration.ini"));
        }
        catch (IOException e) {
            System.out.println("Cannot find src/main/configuration.ini " + e);
        }
        setConfiguration(ini);
    }

    private static void setConfiguration(Ini ini) {
        int numOfWorlds = Integer.parseInt(ini.get("worldsConfig", "numberOfWorlds"));
        for (int i = 1; i <  numOfWorlds + 1; i++) {
            defaultTiles.add(ini.get("world" + i, "defaultTile"));

            worldConfigurations.add(
                new WorldConfiguration(
                        
                )
            );
        }
        System.out.println(defaultTiles);

    }

    public static ArrayList<String> getDefaultTiles() {
        return defaultTiles;
    }

    public static ArrayList<WorldConfiguration> getWorldConfigs() {
        return worldConfigurations;
    }
}
