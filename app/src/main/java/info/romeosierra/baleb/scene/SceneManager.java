package info.romeosierra.baleb.scene;

import java.util.ArrayList;
import java.util.List;

import info.romeosierra.baleb.RenderScene;
import info.romeosierra.baleb.math.Vec2;

public class SceneManager {
    private Vec2 touchPosition;
    private boolean isTouching;
    private int screenWidth;
    private int screenHeight;
    private int currentLevel = 0;
    private List<Scene> scenes;
    private boolean isChanging = false;

    public SceneManager() {
        touchPosition = new Vec2();
        scenes = new ArrayList<>();
        scenes.add(new Scene("TEST", scenes.size()));
        scenes.add(new Scene("TEST1", scenes.size()));
        currentLevel = 0;

    }

    public void start() {
        //Load scene
    }
    public void update(float dt) {

    }

    public void setTouchPosition(Vec2 touchPosition, boolean isTouching) {
        this.touchPosition.setX(touchPosition.getX());
        this.touchPosition.setY(touchPosition.getY());
        this.isTouching = isTouching;

    }

    public void setScreenDimensions(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
    }
    public RenderScene getRenderScene() {
        return new RenderScene();
    }
}

