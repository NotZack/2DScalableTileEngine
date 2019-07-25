package world;

import configuration.AssetLoading;
import javafx.scene.layout.Pane;

public class World extends Pane {

    private int worldId;
    private String classification;

    World(WorldTemplate worldTemplate) {
        this.worldId = worldTemplate.getWorldId();
        this.classification = worldTemplate.getClassification();

        this.setWidth(worldTemplate.getSize() * AssetLoading.TILE_SIZE);
        this.setMinWidth(worldTemplate.getSize() * AssetLoading.TILE_SIZE);
        this.setMaxWidth(worldTemplate.getSize() * AssetLoading.TILE_SIZE);
        this.setHeight(worldTemplate.getSize() * AssetLoading.TILE_SIZE);
        this.setMinHeight(worldTemplate.getSize() * AssetLoading.TILE_SIZE);
        this.setMaxHeight(worldTemplate.getSize() * AssetLoading.TILE_SIZE);
    }

    int getWorldId() {
        return worldId;
    }

    public String getClassification() {
        return classification;
    }
}