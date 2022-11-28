package com.skyline.timer.schedule;

import com.skyline.timer.Controller;
import com.skyline.timer.component.AudioPlayer;
import com.skyline.timer.component.RoundPad;
import com.skyline.timer.component.TimerPad;
import com.skyline.timer.utils.TimerUtils;

public class CountDown implements Runnable {

    private TimerPad timerPad;
    private RoundPad roundPad;
    private int activeTime;
    private int restTime;
    private int roundCount;

    /**
     * @param timerPad   倒计时器
     * @param roundPad   第几轮
     * @param activeTime 活动时间，单位s
     * @param restTime   休息时间 单位s
     * @param roundCount 一共几轮
     */
    public CountDown(TimerPad timerPad, RoundPad roundPad, int activeTime, int restTime, int roundCount) {
        this.timerPad = timerPad;
        this.roundPad = roundPad;
        this.activeTime = activeTime;
        this.restTime = restTime;
        this.roundCount = roundCount;
    }


    @Override
    public void run() {
        for (int i = 0; i < this.roundCount; i++) {//按照轮次来
            this.roundPad.setRoundText(true, i + 1);//设置轮次
            // 播放开始音乐
            new Thread(() -> {
                AudioPlayer.Mp3Player("resources/audio/ding.mp3");
            }).start();
            //先处理活动的倒计时
            countDownWhile(true, this.activeTime);
            //设置休息时间
            this.roundPad.setRoundText(false, i + 1);
            countDownWhile(false, this.restTime);
        }

        this.roundPad.reset();
        this.timerPad.reset();
    }


    /**
     * 倒计时循环
     *
     * @param active 是否是活动期间
     * @param time
     */
    private void countDownWhile(boolean active, int time) {
        while (time > 0 && !Controller.EXIT_STATE()) {
            time--;
            try {
                if (active && time == 9) {//倒数10s的时候要播放音乐
                    new Thread(() -> {
                        AudioPlayer.Mp3Player("resources/audio/dingdingding.mp3");
                    }).start();
                }
                Thread.sleep(1000);
                if (Controller.PAUSE_STATE()) {//如果设置了暂停，就恢复时间
                    time++;
                }
                this.timerPad.setTimeText(TimerUtils.composeCountDownTime(time));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
