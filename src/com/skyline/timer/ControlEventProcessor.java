package com.skyline.timer;

import com.skyline.timer.render.ControlPanel;
import com.skyline.timer.render.SettingPanel;
import com.skyline.timer.render.TimerPanel;
import com.skyline.timer.schedule.CountDown;
import com.skyline.timer.utils.TimerUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 处理核心事件
 */
public class ControlEventProcessor {


    public static void bind(ControlPanel cp, TimerPanel tp, SettingPanel sp) {
        //设置默认选中的时间
        tp.getTimerPad().setTimeText(TimerUtils.composeCountDownTime(sp.getActiveTime()));

        JButton startBtn = cp.getStartBtn();
        startBtn.addActionListener(e -> {
            if (e.getSource() == startBtn) {//click事件？
                if (!Controller.RUNNING_STATE() && !Controller.PAUSE_STATE()) {//初始化状态
                    Controller.START();
                    startBtn.setText("暂停");
                    //增加业务逻辑
                    new Thread(new CountDown(tp.getTimerPad(), tp.getRoundPad(),
                            sp.getActiveTime(), sp.getRestTime(), sp.getCount())).start();
                } else if (Controller.RUNNING_STATE() && !Controller.PAUSE_STATE()) {//运行中，点击了暂停
                    //设置状态为暂停
                    Controller.PAUSE();
                    startBtn.setText("继续");
                } else if (!Controller.RUNNING_STATE()) { //暂停后，点了继续
                    Controller.RESTART();
                    startBtn.setText("暂停");
                }
            }
        });

        //切换时间
        JComboBox box = sp.getActiveComboBox();
        box.addActionListener(e -> {
            if (e.getSource() == box) {
                if (!Controller.RUNNING_STATE() && !Controller.PAUSE_STATE()) {
                    int time = TimerUtils.timeStringToInt((String) box.getSelectedItem());
                    tp.getTimerPad().setTimeText(TimerUtils.composeCountDownTime(time));
                }
            }
        });
    }
}
