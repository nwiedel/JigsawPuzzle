package de.nicolas.utils.actors;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Realisiert Drag-and-Drop Funktionalität
 */
public class DragAndDropActor extends BaseActor {

    private DragAndDropActor self;

    private DropTargetActor dropTarget;

    private float grabOffsetX;
    private Float grabOffsetY;

    public DragAndDropActor(float x, float y, Stage stage) {
        super(x, y, stage);

        self = this;

        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float offsetX, float offsetY, int pointer, int button) {
                self.grabOffsetX = offsetX;
                self.grabOffsetY = offsetY;
                self.toFront();
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float offsetX, float offsetY, int pointer) {
                float deltaX = offsetX - self.grabOffsetX;
                float deltaY = offsetY - self.grabOffsetY;
                self.moveBy(deltaX, deltaY);
            }

            @Override
            public void touchUp(InputEvent event, float offsetX, float offsetY, int pointer, int button) {
                // wird später hinzugefügt
                self.setDropTarget(null);

                float closestDistance = Float.MAX_VALUE;

                for (BaseActor actor : BaseActor.getList(self.getStage(), "de.nicolas.utils.actors.DropTargetActor")){
                    DropTargetActor target = (DropTargetActor) actor;

                    
                }
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
