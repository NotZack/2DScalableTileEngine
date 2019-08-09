package main;

import configuration.AssetLoading;
import configuration.LoadConfiguration;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import tiles.regioning.BinRegion;
import tiles.regioning.BinRegionHandler;
import world.WorldHandler;

import java.util.List;

public class Engine extends Application {

    private static Group root = new Group();
    private static Scene initialScene = new Scene(root, 800, 600);

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

        root.getChildren().add(WorldHandler.getCurrentWorld());
        Input.enableInput(initialScene);

        startEngineLoop();


    }

    private static void startEngineLoop() {
        //Timer runs constantly
        AnimationTimer engineLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long frameTime) {

                Input.updateCamera(initialScene);

                //Time difference from last frame
                deltaTime = 0.00000001 * (frameTime - lastUpdate);

                if (deltaTime <= 0.1 || deltaTime >= 1.0)
                    deltaTime = 0.00000001 * engineSpeed;

                if (frameTime - lastUpdate >= engineSpeed) {
                    updateTick();
                    drawUpdate();
                    lastUpdate = frameTime;
                }
            }
        };
        engineLoop.start();
    }

    private static void updateTick() {

        //TODO: Implement proper bin region switching
    }

    private static void drawUpdate() {
        List<List<BinRegion>> activeRegions = BinRegionHandler.getActiveWorldRegions();

        Point2D pointTest = WorldHandler.getCurrentWorld().sceneToLocal(new Point2D(0, 0));
        System.out.println(pointTest);

    }

    public static void clearScreen() {
        root.getChildren().clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
