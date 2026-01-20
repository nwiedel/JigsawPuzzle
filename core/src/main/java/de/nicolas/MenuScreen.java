package de.nicolas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import de.nicolas.card.CardScreen;
import de.nicolas.puzzle.PuzzleLevel;
import de.nicolas.utils.game.BaseGame;
import de.nicolas.utils.screens.BaseScreen;

public class MenuScreen extends BaseScreen {
    @Override
    public void initialize() {
        Label title = new Label("Demo für Drag and Drop!", BaseGame.labelStyle);

        TextButton puzzleButton = new TextButton("Puzzle", BaseGame.textButtonStyle);
        puzzleButton.addListener(
            (Event e) -> {
                if (!(e instanceof InputEvent) ||
                    !((InputEvent)e).getType().equals(InputEvent.Type.touchDown)){
                    return false;
                }
                JigsawPuzzleGame.setActiveScreen(new PuzzleLevel());
                return false;
            }
        );

        TextButton cardButton = new TextButton("Karten", BaseGame.textButtonStyle);
        cardButton.addListener(
            (Event e) -> {
                if (!(e instanceof InputEvent) ||
                    !((InputEvent)e).getType().equals(InputEvent.Type.touchDown)){
                    return false;
                }
                JigsawPuzzleGame.setActiveScreen(new CardScreen());
                return false;
            }
        );

        TextButton quitButton = new TextButton("Quit", BaseGame.textButtonStyle);
        quitButton.addListener(
            (Event e) -> {
                if (!(e instanceof InputEvent) ||
                    !((InputEvent)e).getType().equals(InputEvent.Type.touchDown)){
                    return false;
                }
                Gdx.app.exit();
                return false;
            }
        );

        uiTable.add(title).colspan(2);
        uiTable.row().pad(50);
        uiTable.add(puzzleButton);
        uiTable.add(cardButton);
        uiTable.row();
        uiTable.add(quitButton).colspan(2);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void render(float delta) {
        super.render(delta);

    }
}
