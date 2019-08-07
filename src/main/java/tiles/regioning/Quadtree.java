package tiles.regioning;

import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

class Quadtree extends Group {

    private static final int BUCKET_SIZE = 68;

    TreeNode rootTree;

    class TreeNode {
        TreeNode NW, NE, SW, SE;

        //TODO: Change x, y, and size into a bounds object
        double x;
        double y;
        int size;

        ArrayList<ImageView> children = new ArrayList<>();

        TreeNode(double x, double y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    void insert(double x, double y, ImageView objectToInsert) {
        if ( (x < (rootTree.x + rootTree.size)) && (y < (rootTree.y + rootTree.size)) && (x >= rootTree.x && y >= rootTree.y) ) {
            insert(rootTree, x, y, objectToInsert);
            this.getChildren().add(objectToInsert);
        }

        else
            System.out.println("Wrong BinRegion!");
    }

    private void insert(TreeNode leaf, double x, double y, ImageView objectToInsert) {
        TreeNode targetLeaf = determineQuadrant(leaf, x, y);

        if (targetLeaf.children.size() == BUCKET_SIZE) insert(targetLeaf, x, y, objectToInsert);
        else targetLeaf.children.add(objectToInsert);
    }

    private TreeNode determineQuadrant(TreeNode leaf, double x, double y) {
        if ( (x < (leaf.x + (leaf.size / 2.0))) && (y < leaf.y + (leaf.size / 2.0)) ) {
            if (leaf.NW == null) leaf.NW = new TreeNode(leaf.x, leaf.y, leaf.size / 2);
            return leaf.NW;
        }
        else if ( (x >= (leaf.x + (leaf.size / 2.0))) && (y < (leaf.y + (leaf.size / 2.0))) ) {
            if (leaf.NE == null) leaf.NE = new TreeNode(leaf.x + (leaf.size / 2.0), leaf.y, leaf.size / 2);
            return leaf.NE;
        }
        else if ( (x < (leaf.x + (leaf.size / 2.0))) && (y >= (leaf.y + (leaf.size / 2.0))) ) {
            if (leaf.SW == null) leaf.SW = new TreeNode(leaf.x, leaf.y + (leaf.size / 2.0), leaf.size / 2);
            return leaf.SW;
        }
        else if ( (x >= (leaf.x + (leaf.size / 2.0))) && (y >= (leaf.y + (leaf.size / 2.0))) ) {
            if (leaf.SE == null) leaf.SE = new TreeNode(leaf.x + (leaf.size / 2.0), leaf.y + (leaf.size / 2.0), leaf.size / 2);
            return leaf.SE;
        }
        else return null;
    }
}