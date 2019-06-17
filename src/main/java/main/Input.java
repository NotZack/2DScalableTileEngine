package main;

import com.sun.istack.internal.NotNull;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

class Input {

    private static boolean northMovement = false;
    private static boolean westMovement = false;
    private static boolean southMovement = false;
    private static boolean eastMovement = false;

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

            if (keyPressed.equals(KeyCode.UP)) northMovement = true;
            if (keyPressed.equals(KeyCode.LEFT)) westMovement = true;
            if (keyPressed.equals(KeyCode.DOWN)) southMovement = true;
            if (keyPressed.equals(KeyCode.RIGHT)) eastMovement = true;

        });

        scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
            KeyCode keyReleased = key.getCode();

            //ActionHandler
            if (keyReleased.equals(KeyCode.W)) northMovement = true;
            if (keyReleased.equals(KeyCode.A)) westMovement = true;
            if (keyReleased.equals(KeyCode.S)) southMovement = true;
            if (keyReleased.equals(KeyCode.D)) eastMovement = true;

            if (keyReleased.equals(KeyCode.UP)) northMovement = true;
            if (keyReleased.equals(KeyCode.LEFT)) westMovement = true;
            if (keyReleased.equals(KeyCode.DOWN)) southMovement = true;
            if (keyReleased.equals(KeyCode.RIGHT)) eastMovement = true;

        });
    }
}
