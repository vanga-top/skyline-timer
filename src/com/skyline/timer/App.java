package com.skyline.timer;

import com.skyline.timer.render.BoardPanel;
import com.skyline.timer.render.ControlPanel;
import com.skyline.timer.render.SettingPanel;
import com.skyline.timer.render.TimerPanel;

import javax.swing.*;
import java.awt.*;

public class App {

    public static void main(String[] args) {

        JFrame main = new JFrame();
        main.setTitle("SKYLINE BOXING");
        main.setSize(1200, 600);
        main.setLocationRelativeTo(null);//居中
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setBackground(Color.BLACK);
        main.setResizable(false);
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(0);//去除边框间距
        main.setLayout(flowLayout);

        //top panel
        BoardPanel top = new BoardPanel(1200, 70);
        main.getContentPane().add(top);

        //logo panel
        BoardPanel logoPanel = new BoardPanel(1200, 80);
        logoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel logo = new JLabel("天际拳击-训练计时器");
        logo.setForeground(Color.WHITE);
        logo.setFont(new Font("黑体", Font.BOLD, 30));
        logoPanel.add(logo);
        main.getContentPane().add(logoPanel);

        //设置panel
        SettingPanel settingPanel = new SettingPanel(1200, 50);
        main.getContentPane().add(settingPanel);

        //倒计时panel
        TimerPanel timerPanel = new TimerPanel(1200, 180);
        main.getContentPane().add(timerPanel);

        //控制panel
        ControlPanel controlPanel = new ControlPanel(1200, 50);
        main.getContentPane().add(controlPanel);

        //绑定几者的事件关系
        ControlEventProcessor.bind(controlPanel, timerPanel, settingPanel);

        //底部
        BoardPanel bottom = new BoardPanel(1200, 170);
        main.getContentPane().add(bottom);

        main.setVisible(true);
    }

}
