package com.skyline.timer.render;

import javax.swing.*;
import java.awt.*;

/**
 * 空白的panel
 */
public class BoardPanel extends JPanel {
    public BoardPanel(int width, int height) {
        super.setPreferredSize(new Dimension(width, height));
//       super.setBackground(new Color(222, 252, 217));
        super.setBackground(new Color(0, 0, 0));
        super.setBorder(null);
        super.setVisible(true);
    }


}
