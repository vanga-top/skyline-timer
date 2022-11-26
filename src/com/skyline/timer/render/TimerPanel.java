package com.skyline.timer.render;

import com.skyline.timer.component.BoardPad;
import com.skyline.timer.component.RoundPad;
import com.skyline.timer.component.TimerPad;

import javax.swing.*;
import java.awt.*;

//倒计时的panel
public class TimerPanel extends JPanel {

    private RoundPad roundPad;
    private TimerPad timerPad;

    public TimerPanel(int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(new Color(0, 0, 0));
        this.setFont(new Font("黑体", Font.BOLD, 66));
        this.setBorder(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        init();
        this.setVisible(true);
    }

    private void init() {
        roundPad = new RoundPad(1, this.getWidth(), this.getHeight());
        timerPad = new TimerPad();
        BoardPad boardPad = new BoardPad(40, this.getHeight());

        this.add(roundPad);
        this.add(boardPad);
        this.add(timerPad);
    }

    public RoundPad getRoundPad() {
        return roundPad;
    }

    public TimerPad getTimerPad() {
        return timerPad;
    }
}
