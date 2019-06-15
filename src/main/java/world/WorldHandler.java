package world;

import logging.LoggerHandler;

import java.util.ArrayList;

public class WorldHandler {

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
}
