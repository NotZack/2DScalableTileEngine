package main;

import configuration.AssetLoading;
import configuration.LoadConfiguration;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tiles.regioning.BinRegion;
import tiles.regioning.BinRegionHandler;
import world.WorldHandler;

import java.util.ArrayList;
import java.util.List;

public class Engine extends Application {

    private static Group root = new Group();
    private static Scene initialScene = new Scene(root, 800, 600);
    private static Bounds viewport = new BoundingBox(0, 0, initialScene.getWidth(), initialScene.getHeight());

    private static long engineSpeed = 128_666_666L;
    private static double deltaTime = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("2D Engine");

        primaryStage.show();
        primaryStage.setScene(initialScene);

        engineInit();

    }

    private void engineInit() {
        LoadConfiguration.load();
        WorldHandler.createWorlds();
        AssetLoading.loadCurrentWorldTiles();

        WorldHandler.changeWorld(0);

        Platform.runLater(() -> root.getChildren().add(WorldHandler.getCurrentWorld()));
        startEngineLoop();
    }

    private static void startEngineLoop() {
        Input.enableInput(initialScene);

        //Timer runs constantly
        AnimationTimer engineLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long frameTime) {

                Input.updateCamera();

                //Time difference from last frame
                deltaTime = 0.00000001 * (frameTime - lastUpdate);

                if (deltaTime <= 0.1 || deltaTime >= 1.0)
                    deltaTime = 0.00000001 * engineSpeed;

                if (frameTime - lastUpdate >= engineSpeed) {
                    updateTick();
                    lastUpdate = frameTime;
                }
            }
        };
        engineLoop.start();
    }

    private static void updateTick() {

        //TODO: Implement proper bin region switching
    }

    static void drawUpdate() {
        List<List<BinRegion>> activeRegions = BinRegionHandler.getActiveWorldRegions();

        Bounds localViewport = WorldHandler.getCurrentWorld().sceneToLocal(getViewport());

        ArrayList<BinRegion> seenRegions = new ArrayList<>();
        for (List<BinRegion> regionsList : activeRegions) {
            for (BinRegion regions : regionsList) {
                if (regions.localToParent(regions.getLayoutBounds()).intersects(localViewport))
                    seenRegions.add(regions);
                else
                    seenRegions.remove(regions);
            }
        }

        for (BinRegion region : seenRegions) {
            if (!WorldHandler.getCurrentWorld().getChildren().contains(region))
                WorldHandler.getCurrentWorld().getChildren().add(WorldHandler.getCurrentWorld().getChildren().size(), region);
        }

        if ((WorldHandler.getCurrentWorld().getChildren().size() - seenRegions.size()) > 0) {
            WorldHandler.getCurrentWorld().getChildren().subList(0, (WorldHandler.getCurrentWorld().getChildren().size() - seenRegions.size())).clear();
        }
    }

    public static void clearScreen() {
        root.getChildren().clear();
    }

    static Bounds getViewport() {
        return viewport;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
