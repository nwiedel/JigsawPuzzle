package de.nicolas.card;

import com.badlogic.gdx.scenes.scene2d.Stage;
import de.nicolas.utils.actors.DropTargetActor;

import java.util.ArrayList;

public class Pile extends DropTargetActor {

    private ArrayList<Card> cardList;

    public Pile(float x, float y, Stage stage) {
        super(x, y, stage);
        cardList = new ArrayList<>();
        loadTexture("assets/cards/pile.png");
        setSize(100, 120);
        setBoundaryRectangle();
    }

    public void addCard( Card card){
        cardList.add(0, card);
    }

    public Card getTopCar(){
        return cardList.get(0);
    }

    public int getSize(){
        return cardList.size();
    }
}
