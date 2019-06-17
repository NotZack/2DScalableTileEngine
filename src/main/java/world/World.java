package world;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class World extends Pane {

    private int worldId;
    private Image basicTile;

    World(int worldId, int width, int height) {
        this.worldId = worldId;

        this.setWidth(width);
        this.setMinWidth(width);
        this.setMaxWidth(width);
        this.setHeight(height);
        this.setMinHeight(height);
        this.setMaxHeight(height);
    }

    int getWorldId() {
        return worldId;
    }

    public void setBasicTile(Image basicTile) {
        this.basicTile = basicTile;
    }

    public Image getBasicTile() {
        return basicTile;
    }
}