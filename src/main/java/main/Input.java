package main;

import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.jetbrains.annotations.NotNull;
import world.World;
import world.WorldHandler;

class Input {

    private static boolean northMovement = false;
    private static boolean westMovement = false;
    private static boolean southMovement = false;
    private static boolean eastMovement = false;

    private static boolean zoomIn = false;
    private static boolean zoomOut = false;

    private static int cameraMoveSpeed = 20;

    /**
     * Sets the listener for any key press or mouse event. Will update the corresponding object.
     * @param scene The initial scene, required to implement a listener
     */
    static void enableInput(@NotNull Scene scene) {

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

            KeyCode keyPressed = key.getCode();

            //ActionHandler
            if (keyPressed.equals(KeyCode.W)) northMovement = true;
            if (keyPressed.equals(KeyCode.A)) westMovement = true;
            if (keyPressed.equals(KeyCode.S)) southMovement = true;
            if (keyPressed.equals(KeyCode.D)) eastMovement = true;

            if (keyPressed.equals(KeyCode.Z)) zoomIn = true;
            if (keyPressed.equals(KeyCode.X)) zoomOut = true;

            if (keyPressed.equals(KeyCode.UP)) northMovement = true;
            if (keyPressed.equals(KeyCode.LEFT)) westMovement = true;
            if (keyPressed.equals(KeyCode.DOWN)) southMovement = true;
            if (keyPressed.equals(KeyCode.RIGHT)) eastMovement = true;

        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            KeyCode keyReleased = key.getCode();

            //ActionHandler
            if (keyReleased.equals(KeyCode.W)) northMovement = false;
            if (keyReleased.equals(KeyCode.A)) westMovement = false;
            if (keyReleased.equals(KeyCode.S)) southMovement = false;
            if (keyReleased.equals(KeyCode.D)) eastMovement = false;

            if (keyReleased.equals(KeyCode.Z)) zoomIn = false;
            if (keyReleased.equals(KeyCode.X)) zoomOut = false;

            if (keyReleased.equals(KeyCode.UP)) northMovement = false;
            if (keyReleased.equals(KeyCode.LEFT)) westMovement = false;
            if (keyReleased.equals(KeyCode.DOWN)) southMovement = false;
            if (keyReleased.equals(KeyCode.RIGHT)) eastMovement = false;

        });
    }

    static void updateCamera() {
        World currentWorld = WorldHandler.getCurrentWorld();
        if (northMovement)
            currentWorld.setLayoutY(currentWorld.getLayoutY() + cameraMoveSpeed);
        if (westMovement)
            currentWorld.setLayoutX(currentWorld.getLayoutX() + cameraMoveSpeed);
        if (southMovement)
            currentWorld.setLayoutY(currentWorld.getLayoutY() - cameraMoveSpeed);
        if (eastMovement)
            currentWorld.setLayoutX(currentWorld.getLayoutX() - cameraMoveSpeed);

        if (zoomIn)
            zoomCamera(true);
        if (zoomOut)
            zoomCamera(false);

        Engine.drawUpdate();
    }

    private static void zoomCamera(boolean direction) {
        double delta = 1.2;
        double scale = WorldHandler.getCurrentWorld().getScaleY();
        double oldScale = scale;

        if (direction && scale < 2.4) scale *= delta;
        else if (!direction && scale > 0.1) scale /= delta;

        double f = (scale / oldScale) - 1;

        //Determining the shift in position of the camera as it zooms in on the center of the screen
        Bounds bounds = WorldHandler.getCurrentWorld().localToScene(WorldHandler.getCurrentWorld().getLayoutBounds());
        double shiftX = ( (Engine.getViewport().getWidth() / 2.0) - ((bounds.getWidth() / 2) + bounds.getMinX()));
        double shiftY = ( (Engine.getViewport().getHeight() / 2.0) - ((bounds.getHeight() / 2) + bounds.getMinY()));

        //Applying the new scale
        WorldHandler.getCurrentWorld().setScaleX(scale);
        WorldHandler.getCurrentWorld().setScaleY(scale);

        //Applying the new translation
        WorldHandler.getCurrentWorld().setLayoutX(WorldHandler.getCurrentWorld().getLayoutX() - (f * shiftX));
        WorldHandler.getCurrentWorld().setLayoutY(WorldHandler.getCurrentWorld().getLayoutY() - (f * shiftY));
    }
}