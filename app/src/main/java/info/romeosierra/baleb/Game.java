package info.romeosierra.baleb;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import info.romeosierra.baleb.math.Vec2f;

public class Game extends GLSurfaceView {
    private Context context;
    public RAGERenderer renderer;
    private String TAG = "RAGE- Game";
    private GameLoop gameLoop;
    private Vec2f touchPosition;
    private boolean isTouchEvent = false;
    public Game(Context context) {
        super(context);
        this.context = getContext();
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        renderer = new RAGERenderer(context);

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(renderer);
        gameLoop = new GameLoop(this, surfaceHolder);
        setFocusable(true);
        touchPosition = new Vec2f();
        // Init ECS
        gameLoop.startLoop();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event != null) {
            final float normalizedX =
                    (event.getX() / (float) renderer.getWidth()) * 2 - 1;
            final float normalizedY =
                    -((event.getY() / (float) renderer.getHeight()) * 2 - 1);
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {

                    isTouchEvent = true;
                    return true;
                }
                case MotionEvent.ACTION_UP: {
                    touchPosition.x = 0;
                    touchPosition.y = 0;
                    isTouchEvent = false;
                    return true;
                }
                case MotionEvent.ACTION_MOVE: {
                    touchPosition.x = normalizedX;
                    touchPosition.y = normalizedY;
                    isTouchEvent = true;
                    return true;
                }

            }
        }
        return super.onTouchEvent(event);
    }

    void update(float dt) {
        // ecs.setTouchPosition(touchPosition);
        // ecs.setScreenDimensions(renderer.getWidth, renderer.getHeight());
        // ecs.update(dt);

    }
    void render(int i) {
        // updateSounds
        queueEvent(() -> {
                renderer.setScene();
        });
    }
}
