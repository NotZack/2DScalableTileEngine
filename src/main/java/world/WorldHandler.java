package world;

import configuration.LoadConfiguration;
import main.Engine;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import tiles.TileHandler;

import java.util.ArrayList;

public class WorldHandler {

    private static World currentWorld;

    private static ArrayList<World> worldsList = new ArrayList<>();

    static void addWorld(World worldToAdd) {
        worldsList.add(worldToAdd);
    }

    @Nullable
    private static World getWorld(int worldId) {
        for (World world : worldsList) {
            if (world.getWorldId() == worldId) {
                return world;
            }
        }
        return null;
    }

    @Contract(pure = true)
    public static ArrayList<World> getWorldsList() {
        return worldsList;
    }

    public static void createWorlds() {
        for (int i = 0; i < LoadConfiguration.getNumOfInitWorlds(); i++) {
            worldsList.add(new World(WorldTemplate.getTemplate(i)));
        }
        currentWorld = getWorld(0);
    }

    @Contract(pure = true)
    public static World getCurrentWorld() {
        return currentWorld;
    }

    public static void changeWorld(int worldId) {
        Engine.clearScreen();

        currentWorld = getWorld(worldId);
        TileHandler.createTileMap();
    }
}
