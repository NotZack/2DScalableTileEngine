package configuration;

import org.ini4j.Ini;
import saveState.LoadWorld;

import java.io.File;
import java.io.IOException;

public class LoadConfiguration {

    private static int numOfInitWorlds;

    public static void load() {
        Ini ini = null;
        try {
            ini = new Ini(new File("src/main/configuration/configuration.ini"));
        } catch (IOException e) {
            System.out.println("Cannot find src/main/configuration/configuration.ini " + e);
        }
        loadConfigurations(ini);
    }

    private static void loadConfigurations(Ini ini) {
        numOfInitWorlds = 0;

        String[] worldsDirectory = new File("src/main/configuration/worlds/").list();

        if (worldsDirectory != null)
            numOfInitWorlds = worldsDirectory.length;

        for (int i = 0; i < numOfInitWorlds; i++) {
            LoadWorld.loadWorldConfiguration(i, worldsDirectory[i]);
        }
    }

    public static int getNumOfInitWorlds() {
        return numOfInitWorlds;
    }
}