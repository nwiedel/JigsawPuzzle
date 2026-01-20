package de.nicolas.utils;

import com.badlogic.gdx.scenes.scene2d.Stage;
import de.nicolas.utils.actors.DropTargetActor;

public class PuzzleArea extends DropTargetActor {

    private int row;
    private int col;

    public PuzzleArea(float x, float y, Stage stage) {
        super(x, y, stage);
        loadTexture("assets/border.jpg");
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
