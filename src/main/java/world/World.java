package world;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class World extends Pane {

    private String worldId;
    private Image basicTile;

    public World(String worldId, Image basicTile, int width, int height) {
        this.worldId = worldId;
        this.basicTile = basicTile;

        this.setWidth(width);
        this.setMinWidth(width);
        this.setMaxWidth(width);
        this.setHeight(height);
        this.setMinHeight(height);
        this.setMaxHeight(height);
    }

    public String getWorldId() {
        return worldId;
    }

    public Image getBasicTile() {
        return basicTile;
    }
}
