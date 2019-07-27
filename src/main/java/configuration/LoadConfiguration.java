package configuration;

import org.ini4j.Ini;
import world.WorldTemplate;

import java.io.File;
import java.io.IOException;

public class LoadConfiguration {

    private static int numberOfWorlds = 0;

    public static void load() {
        Ini ini = null;
        try {
            ini = new Ini(new File("src/main/configuration.ini"));
        } catch (IOException e) {
            System.out.println("Cannot find src/main/configuration.ini " + e);
        }
        setConfiguration(ini);
    }

    private static void setConfiguration(Ini ini) {
        setWorldConfiguration(ini);
    }

    private static void setWorldConfiguration(Ini ini) {
        numberOfWorlds = Integer.parseInt(ini.get("worldsConfig", "numberOfWorlds"));
        for (int i = 0; i < numberOfWorlds; i++) {
            new WorldTemplate(
                i,
                ini.get("world" + i, "classification"),
                Integer.parseInt(ini.get("world" + i, "size")
            ));
        }
    }

    public static int getNumberOfWorlds() {
        return numberOfWorlds;
    }
}