package com.skyline.timer.event;

/**
 * 倒计时计时器的event
 */
public class CountDownEvent {
    public enum Event {
        START_ACTIVE,
        START_REST,
        END_ALL
    }

    private Event source;


    public Event getSource() {
        return source;
    }

    public void setSource(Event source) {
        this.source = source;
    }
}
