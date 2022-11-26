package com.skyline.timer.component;

import javax.swing.*;
import java.awt.*;

public class TimerPad extends JLabel {
    public TimerPad() {
        super.setText("00:00:00");
        super.setFont(new Font("黑体", Font.BOLD, 150));
        super.setForeground(Color.WHITE);
        super.setBorder(null);
        super.setVisible(true);
    }

    public void setTimeText(String time) {
        super.setText(time);
        super.setForeground(Color.WHITE);
    }
}
