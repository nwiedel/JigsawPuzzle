package de.nicolas;

import de.nicolas.utils.game.BaseGame;

public class JigsawPuzzleGame extends BaseGame {

    @Override
    public void create() {
        super.create();
        setActiveScreen(new MenuScreen());
    }
}
