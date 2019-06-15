package world;

public class WorldCreation {

    public static void createWorld(int id, int width, int height) {
        WorldHandler.addWorld(new World(
                id, width, height
        ));
    }
}
