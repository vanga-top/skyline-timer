package com.skyline.timer.utils;

import java.util.Objects;

public class TimerUtils {

    public static String composeCountDownTime(int time) {
        int hh = time / 60 / 60 % 60;
        int mm = time / 60 % 60;
        int ss = time % 60;

        String hhStr = String.valueOf(hh);
        if (hh == 0) {
            hhStr = "00";
        }

        String mmStr = String.valueOf(mm);
        if (mm == 0) {
            mmStr = "00";
        } else if (mm < 10) {
            mmStr = "0" + mm;
        }

        String ssStr = String.valueOf(ss);
        if (ss < 10) {
            ssStr = "0" + ss;
        }
        return hhStr + ":" + mmStr + ":" + ssStr;
    }

    /**
     * 时间转换器
     *
     * @param time
     * @return
     */
    public static int timeStringToInt(String time) {
        switch (Objects.requireNonNull(time)) {
            case "2′":
                return 60 * 2;
            case "2′30″":
                return 60 * 2 + 30;
            case "3′":
                return 60 * 3;
            case "5′":
                return 60 * 5;
            case "1′":
                return 60;
            case "1′30″":
                return 60 + 30;
        }
        //默认返回3分钟
        return 180;
    }
}
