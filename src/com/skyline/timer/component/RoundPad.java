package com.skyline.timer.component;


import javax.swing.*;
import java.awt.*;

/**
 * round one
 */
public class RoundPad extends JLabel {

    private static final String ROUND = "R:";
    private static final String BREAK = "B:";

    /**
     * @param defValue 模式初始化值，不写就是1
     */
    public RoundPad(int defValue, int width, int height) {
        if (defValue <= 1) {
            defValue = 1;
        }
        super.setText(composeRoundString(ROUND, defValue));
        super.setSize(new Dimension(width, height));
        super.setFont(new Font("黑体", Font.BOLD, 150));
        super.setForeground(Color.RED);
        super.setBorder(null);
        super.setVisible(true);
    }

    public void setRoundText(boolean active, int round) {
        super.setText(composeRoundString(active ? ROUND : BREAK, round));
        super.setForeground(active ? Color.RED : Color.BLUE);
    }


    private String composeRoundString(String prefix, int value) {
        return prefix + value;
    }

    public void reset() {
        this.setForeground(Color.RED);
        this.setText(composeRoundString(ROUND, 1));
    }
}
