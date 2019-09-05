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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import world.WorldHandler;

/**
 * Contains the initialization and configuration of the engine.
 */
public class Engine extends Application {

    private static Group root = new Group();
    private static Scene initialScene = new Scene(root, 800, 600);
    private static Bounds viewport = new BoundingBox(0, 0, initialScene.getWidth(), initialScene.getHeight());

    private static long engineSpeed = 128_666_666L;
    private static double deltaTime = 0;

    /**
     * JavaFX method that runs on application start.
     * @param primaryStage The Stage for this application
     */
    @Override
    public void start(@NotNull Stage primaryStage) {
        primaryStage.setTitle("2D Engine");

        primaryStage.show();
        primaryStage.setScene(initialScene);

        engineInit();
    }

    /**
     * Collects resources, calls configuration loading, and starts the engine.
     */
    private void engineInit() {
        LoadConfiguration.load();
        WorldHandler.createWorlds();
        AssetLoading.loadCurrentWorldTiles();

        WorldHandler.changeWorld(0);

        Platform.runLater(() -> {
            root.getChildren().add(WorldHandler.getCurrentWorld());
            Input.updateCamera(true);
        });

        startEngineLoop();
    }

    /**
     * Initializes the main loop which handles updating of the viewport and anything else.
     */
    private static void startEngineLoop() {
        Input.enableInput(initialScene);

        //Timer runs constantly
        AnimationTimer engineLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long frameTime) {

                Input.updateCamera(false);

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

    /**
     * Called during every frame of the engine.
     */
    private static void updateTick() {
    }

    /**
     * Clears the root node of all children.
     */
    public static void clearScreen() {
        root.getChildren().clear();
    }

    /**
     * @return The current Stage's viewport.
     */
    @Contract(pure = true)
    static Bounds getViewport() {
        return viewport;
    }

    public static void main(String[] args) {
        launch(args);
    }
}