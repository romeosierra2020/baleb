package info.romeosierra.baleb;

import android.util.Log;
import android.view.SurfaceHolder;

public class GameLoop extends Thread {
    private String TAG = "RAGE- GameLoop";
    private static int MAX_UPS = 60;
    private static float UPS_PERIOD = 1000.0f / MAX_UPS;
    Game game;
    SurfaceHolder surfaceHolder;
    private boolean isRunning;
    private int count;
    public GameLoop(Game game, SurfaceHolder surfaceHolder) {
        this.game = game;
        this.surfaceHolder = surfaceHolder;
        count = 0;
    }

    public void startLoop() {
        isRunning = true;
        start();

    }

    @Override
    public void run() {
        super.run();
        int updateCount = 0;
        int frameCount = 0;

        long startTime, elapsedTime, sleepTime;


        startTime = System.currentTimeMillis();
        while(isRunning) {

            game.update(0.0f);
            updateCount++;
            game.render(count++);
            frameCount++;

            elapsedTime = System.currentTimeMillis() - startTime;
            sleepTime = (long) (updateCount * UPS_PERIOD - elapsedTime);
            if(sleepTime > 0) {
                try {
                    sleep(sleepTime);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while(sleepTime < 0 && updateCount < MAX_UPS - 1) {
                game.update(0.0f);
                updateCount++;
                elapsedTime = System.currentTimeMillis() - startTime;
                sleepTime = (long) (updateCount * UPS_PERIOD - elapsedTime);
            }
            elapsedTime = System.currentTimeMillis() - startTime;

            if(elapsedTime >= 1000) {
                double averageUPS = updateCount / (1E-3 * elapsedTime);
                double averageFPS = frameCount / (1E-3 * elapsedTime);
                Log.i(TAG, "UPS: " + averageUPS + ". FPS: " + averageFPS + ".");
                updateCount = 0;
                frameCount = 0;
                startTime = System.currentTimeMillis();
            }

        }
    }
}
