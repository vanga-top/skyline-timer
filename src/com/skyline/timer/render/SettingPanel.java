package com.skyline.timer.render;

import com.skyline.timer.component.BoardPad;
import com.skyline.timer.utils.TimerUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * 设置面板
 */
public class SettingPanel extends JPanel {

    private JLabel activeLab = new JLabel("竞赛时间：");
    private JLabel restLab = new JLabel("休息时间：");
    private JLabel countLab = new JLabel("组数：");
    private JComboBox activeComboBox = new JComboBox();
    private JComboBox restComboBox = new JComboBox();
    private JComboBox countComboBox = new JComboBox();

    public SettingPanel(int width, int height) {
        super.setPreferredSize(new Dimension(width, height));
        super.setBackground(new Color(0, 0, 0));
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(null);

        init();
        super.setVisible(true);
    }

    //初始化
    private void init() {
        //设置竞赛label
        activeLab.setFont(new Font("黑体", Font.BOLD, 20));
        activeLab.setForeground(Color.WHITE);
        activeLab.setVisible(true);

        // 绑定下拉框选项
        String[] strArray = {"2′", "2′30″", "3′", "5′"};
        for (String item : strArray) {
            activeComboBox.addItem(item);
        }
        activeComboBox.setFont(new Font("黑体", Font.BOLD, 18));
        activeComboBox.setPreferredSize(new Dimension(140, 50));
        activeComboBox.setVisible(true);

        //设置竞赛label
        restLab.setFont(new Font("黑体", Font.BOLD, 20));
        restLab.setForeground(Color.WHITE);
        restLab.setVisible(true);

        // 绑定下拉框选项
        String[] strArray1 = {"1′", "1′30″", "2′", "3′"};
        for (String item : strArray1) {
            restComboBox.addItem(item);
        }
        restComboBox.setFont(new Font("黑体", Font.BOLD, 18));
        restComboBox.setPreferredSize(new Dimension(140, 50));
        restComboBox.setVisible(true);

        //组数lab
        countLab.setFont(new Font("黑体", Font.BOLD, 20));
        countLab.setForeground(Color.WHITE);
        countLab.setVisible(true);
        // 绑定下拉框选项
        int[] strArray2 = {3, 5, 6, 8, 10, 12, 16, 20};
        for (int item : strArray2) {
            countComboBox.addItem(item);
        }
        countComboBox.setFont(new Font("黑体", Font.BOLD, 18));
        countComboBox.setPreferredSize(new Dimension(140, 50));
        countComboBox.setVisible(true);


        super.add(activeLab);
        super.add(activeComboBox);

        BoardPad boardPad = new BoardPad(40, 10);
        super.add(boardPad);

        super.add(restLab);
        super.add(restComboBox);

        BoardPad boardPad1 = new BoardPad(40, 10);
        super.add(boardPad1);

        super.add(countLab);
        super.add(countComboBox);
    }

    /**
     * 获取竞赛时间
     *
     * @return
     */
    public int getActiveTime() {
        String val = (String) activeComboBox.getSelectedItem();
        return TimerUtils.timeStringToInt(val);
    }


    /**
     * 获取竞赛时间
     *
     * @return
     */
    public int getRestTime() {
        String val = (String) restComboBox.getSelectedItem();
        return TimerUtils.timeStringToInt(val);
    }

    //返回组数
    public int getCount() {
        return (int) countComboBox.getSelectedItem();
    }

    public JComboBox getActiveComboBox() {
        return activeComboBox;
    }
}
