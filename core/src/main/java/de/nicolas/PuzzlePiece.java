package de.nicolas;

import com.badlogic.gdx.scenes.scene2d.Stage;
import de.nicolas.utils.actors.DragAndDropActor;

public class PuzzlePiece extends DragAndDropActor {

    private int row;
    private int col;

    private PuzzleArea puzzleArea;

    public PuzzlePiece(float x, float y, Stage stage) {
        super(x, y, stage);
    }

    @Override
    public void onDragStart() {
        if (hasPuzzleArea()){
            PuzzleArea pa = getPuzzleArea();
            pa.setTargetable(true);
            clearPuzzleArea();
        }
    }

    @Override
    public void onDrop() {
        if (hasDropTarget()){
            PuzzleArea pa = (PuzzleArea) getDropTarget();
            moveToActor(pa);
            setPuzzleArea(pa);
            pa.setTargetable(false);
        }
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

    public void setPuzzleArea(PuzzleArea puzzleArea) {
        this.puzzleArea = puzzleArea;
    }

    public PuzzleArea getPuzzleArea() {
        return puzzleArea;
    }

    public void clearPuzzleArea(){
        puzzleArea = null;
    }

    public boolean hasPuzzleArea(){
        return puzzleArea != null;
    }

    public boolean isCorrectPlace(){
        return hasPuzzleArea() && this.getRow() == puzzleArea.getRow() && this.getCol() == puzzleArea.getCol();
    }
}
