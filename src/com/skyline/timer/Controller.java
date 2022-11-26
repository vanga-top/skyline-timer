package com.skyline.timer;

/**
 * 全局控制器
 */
public class Controller {

    //暂停状态
    private static boolean PAUSE = false;
    //是否运行中
    private static boolean RUNNING = false;
    //是否强制退出状态
    private static boolean EXIT = false;

    /**
     * 暂停
     */
    public synchronized static void PAUSE() {
        Controller.PAUSE = true;
        RUNNING = false;
    }

    /**
     * 重新开始
     */
    public synchronized static void RESTART() {
        Controller.PAUSE = false;
        RUNNING = true;
    }

    public static boolean PAUSE_STATE() {
        return PAUSE;
    }

    public synchronized static void START() {
        RUNNING = true;
    }

    public static boolean RUNNING_STATE() {
        return RUNNING;
    }

    public static boolean EXIT_STATE() {
        return EXIT;
    }

}
