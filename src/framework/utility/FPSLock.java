package framework.utility;

/**
 * Created by Liam Cristoforo-Dodds on 06/04/2015.
 */
public class FPSLock {
    private static int fps = 30;

    private static long lastTime;
    private static long beginTime;
    private static long timeTaken;
    private static long timeLeft;

    public static Integer fpsCounter = 0;

    public static void start(int newFPS) {
        fps = newFPS;
        beginTime = System.currentTimeMillis();
    }

    public static void start() {
        start(fps);
    }
    public static void finish() {
        timeTaken = System.currentTimeMillis() - beginTime;
        timeLeft = ((1000 / fps) - timeTaken);

        try {
            Thread.sleep(timeLeft);
        } catch (InterruptedException e) {}
    }
}
