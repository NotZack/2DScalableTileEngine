package world;

import javafx.scene.layout.Pane;

import static configuration.AssetLoading.TILE_SIZE;

public class World extends Pane {

    private int worldId;
    private String classification;

    World(WorldTemplate worldTemplate) {
        this.worldId = worldTemplate.getWorldId();
        this.classification = worldTemplate.getClassification();

        this.setWidth(worldTemplate.getSize() * TILE_SIZE);
        this.setMinWidth(worldTemplate.getSize() * TILE_SIZE);
        this.setMaxWidth(worldTemplate.getSize() * TILE_SIZE);
        this.setHeight(worldTemplate.getSize() * TILE_SIZE);
        this.setMinHeight(worldTemplate.getSize() * TILE_SIZE);
        this.setMaxHeight(worldTemplate.getSize() * TILE_SIZE);
    }

    int getWorldId() {
        return worldId;
    }

    public String getClassification() {
        return classification;
    }

    public int getTileLength() {
        return (int) this.getMaxWidth() / TILE_SIZE;
    }
}