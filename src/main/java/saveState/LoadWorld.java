package saveState;

import org.apache.commons.io.FileUtils;
import world.World;
import world.WorldTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LoadWorld {

    public static WorldTemplate loadWorldConfiguration(int worldId, String fileName) {

        try {
            List<String> fileLines = FileUtils.readLines(new File("src/main/configuration/worlds/" + fileName), "UTF-8");

            return new WorldTemplate(
                    worldId,
                    trimConfigValue(fileLines.get(0)),
                    Integer.parseInt( trimConfigValue(fileLines.get(1))) );

        } catch (IOException e) {
            System.out.println("Failed reading " + fileName);
        }

        return null;
    }

    private static String trimConfigValue(String untrimmed) {
        return untrimmed.substring(untrimmed.indexOf('=') + 1);
    }

    public static World loadWorldSave() {
        return null;
    }
}
