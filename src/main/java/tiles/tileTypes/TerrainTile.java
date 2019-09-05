package tiles.tileTypes;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Random;

public class TerrainTile extends GenericTile {

    private boolean[][] placementMap = new boolean[4][4];

    @Contract(pure = true)
    public TerrainTile(Image tileImage, String tileCategory) {
        super(tileImage, tileCategory);

        for (int i = 0; i < placementMap.length; i++) {
            for (int j = 0; j < placementMap.length; j++) {
                placementMap[j][i] = false;
            }
        }
    }

    Point2D findRandPlacementPoint(int size) {
        Random random = new Random();
        ArrayList<Point2D> possiblePlacements = new ArrayList<>();

        for (int i = 0; i < placementMap.length - (size - 1); i++) {
            for (int j = 0; j < placementMap.length - (size - 1); j++) {
                if (!placementMap[j][i] && findIsPlacementRoom(j, i, size)){
                    possiblePlacements.add(new Point2D(j, i));
                }
            }
        }

        Point2D randPlacement = possiblePlacements.get(random.nextInt(possiblePlacements.size()));
        updatePlacementArray(randPlacement, size);
        return randPlacement;
    }

    @Contract(pure = true)
    private boolean findIsPlacementRoom(int  xIndex, int yIndex, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (placementMap[xIndex + j][yIndex + i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void updatePlacementArray(Point2D indexPoint, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                placementMap[(int) indexPoint.getX() + j][(int) indexPoint.getY() + i] = true;
            }
        }
    }
}