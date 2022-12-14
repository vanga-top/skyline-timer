package com.skyline.timer.render;

import javax.swing.*;
import java.awt.*;

/**
 * 控制面板
 */
public class ControlPanel extends JPanel {

    private JButton startBtn = new JButton("开始");
    private JButton clearBtn = new JButton("清空");

    public ControlPanel(int width, int height) {
        super.setPreferredSize(new Dimension(width, height));
        super.setBackground(new Color(0, 0, 0));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(null);
        init();

        super.setVisible(true);
    }

    private void init() {
        startBtn.setPreferredSize(new Dimension(80, 40));
        super.add(startBtn);

        clearBtn.setPreferredSize(new Dimension(80, 40));
        super.add(clearBtn);
    }

    public JButton getStartBtn() {
        return startBtn;
    }

    public JButton getClearBtn() {
        return clearBtn;
    }
}
