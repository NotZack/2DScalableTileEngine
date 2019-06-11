package world;

import Configuration.LoadConfiguration;
import Configuration.WorldConfiguration;

import java.util.ArrayList;

public class WorldCreation {

    public static void createWorlds() {
        ArrayList<WorldConfiguration> worldConfigs = LoadConfiguration.getWorldConfigs();
        for (int i = 0; i < worldConfigs.size(); i++) {

        }
    }
}
