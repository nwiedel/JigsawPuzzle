package de.nicolas.card;

import com.badlogic.gdx.scenes.scene2d.Stage;
import de.nicolas.utils.actors.DragAndDropActor;

public class Card extends DragAndDropActor {

    public static String[] rankNames = {"A", "2", "3", "4", "5", "6", "7",
                                        "8", "9", "10", "J", "Q", "K"};
    public static String[] suitNames = {"Clubs", "Hearts", "Spades", "Diamonds"};

    private int rankValue;
    private int suitValue;

    public Card(float x, float y, Stage stage) {
        super(x, y, stage);
    }

    public void setRankValue(int rankValue){
        this.rankValue = rankValue;
    }

    public int getRankValue() {
        return rankValue;
    }

    public String getRankName() {
        return rankNames[getRankValue()];
    }

    public void setSuitValue(int suitValue) {
        this.suitValue = suitValue;
    }

    public int getSuitValue() {
        return suitValue;
    }

    public String getSuitName() {
        return suitNames[getSuitValue()];
    }

    public void setRankSuitValue(int r, int s){
        setRankValue(r);
        setSuitValue(s);
        String imageFileName = "assets/cards/card" + getSuitName() +
            getRankName() + ".png";
        loadTexture(imageFileName);
        setSize(80, 100);
        setBoundaryRectangle();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        boundToWorld();
    }

    @Override
    public void onDrop() {
        if(hasDropTarget()){
            Pile pile = (Pile)getDropTarget();
            Card topCard = pile.getTopCar();

            if (this.getRankValue() == topCard.getRankValue() + 1
                && this.getSuitValue() == topCard.getSuitValue()){
                moveToActor(pile);
                pile.addCard(this);
            }
            else{
                moveToStart();
            }
        }
    }
}
