package world;

import configuration.LoadConfiguration;
import logging.LoggerHandler;
import main.Engine;
import tiles.TileHandler;

import java.util.ArrayList;

public class WorldHandler {

    private static World currentWorld;

    private static ArrayList<World> worldsList = new ArrayList<>();

    static void addWorld(World worldToAdd) {
        worldsList.add(worldToAdd);
    }

    public static World getWorld(int worldId) {
        for (World world : worldsList) {
            if (world.getWorldId() == worldId) {
                return world;
            }
        }
        LoggerHandler.logEvent(worldId, "Could not find worldId: ");
        return null;
    }

    public static ArrayList<World> getWorldsList() {
        return worldsList;
    }

    public static void createWorlds() {
        for (int i = 0; i < LoadConfiguration.getNumOfInitWorlds(); i++) {
            worldsList.add(new World(WorldTemplate.getTemplate(i)));
        }
        currentWorld = getWorld(0);
    }

    public static World getCurrentWorld() {
        return currentWorld;
    }

    public static void changeWorld(int worldId) {
        Engine.clearScreen();

        currentWorld = getWorld(worldId);
        TileHandler.createTileMap();
    }
}
