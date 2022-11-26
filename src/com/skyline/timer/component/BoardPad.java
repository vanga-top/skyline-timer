package com.skyline.timer.component;

import javax.swing.*;
import java.awt.*;

public class BoardPad extends JLabel {
    public BoardPad(int width, int height) {
        super.setPreferredSize(new Dimension(width, height));
        this.setBorder(null);
        this.setVisible(true);
    }
}
