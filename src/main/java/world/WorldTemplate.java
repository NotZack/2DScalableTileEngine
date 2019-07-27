package world;

import java.util.ArrayList;

public class WorldTemplate {

    private static ArrayList<WorldTemplate> templates = new ArrayList<>();

    private int worldId;
    private String classification;
    private int size;

    public WorldTemplate(int worldId, String classification, int size) {
        this.worldId = worldId;
        this.classification = classification;
        this.size = size;

        templates.add(this);
    }

    static WorldTemplate getTemplate(int index) {
        return templates.get(index);
    }

    int getWorldId() {
        return worldId;
    }

    String getClassification() {
        return classification;
    }

    int getSize() {
        return size;
    }
}
