package com.skyline.timer;

import com.skyline.timer.event.CountDownEvent;
import com.skyline.timer.event.CountDownEventListener;

import java.util.ArrayList;
import java.util.List;

public class ActionProcessor {

    private static List<CountDownEventListener> countDownEventListeners = new ArrayList<>(16);

    /**
     * 注册时间
     *
     * @param listener
     */
    public static void registerCountDownListener(CountDownEventListener listener) {
        countDownEventListeners.add(listener);
    }

    /**
     * 发送事件
     *
     * @param event
     */
    public static void countDownEvent(CountDownEvent event) {
        countDownEventListeners.forEach(listener -> {
            listener.onEvent(event);
        });
    }

}
