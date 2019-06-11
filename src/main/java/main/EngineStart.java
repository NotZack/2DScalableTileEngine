package main;

import Configuration.AssetLoading;
import Configuration.LoadConfiguration;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tiles.TileCreation;
import world.WorldCreation;

public class EngineStart extends Application {

    private Group root = new Group();
    private Scene initialScene = new Scene(root, 800, 600);

    private static long engineSpeed = 128_666_666L;
    private static double deltaTime = 0;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("2D Engine");

        primaryStage.show();
        primaryStage.setScene(initialScene);

        engineInit();
    }

    private static void engineInit() {
        LoadConfiguration.load();
        AssetLoading.load();

        WorldCreation.createWorlds();
        TileCreation.createTiles();

        startEngineLoop();
    }

    private static void startEngineLoop() {
        //Timer runs constantly
        AnimationTimer engineLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long frameTime) {
                CameraControl.updateCamera();

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

    }

    public static void main(String[] args) {
        launch(args);
    }
}
