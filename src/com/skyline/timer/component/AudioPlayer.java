package com.skyline.timer.component;


import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class AudioPlayer {
    /**
     * JLayer提供的AdvancedPlayer类是最灵活、功能最全的播放器类。
     * 该类提供了很多方法
     **/
    public static void Mp3AdvancedPlayer(String path) {
        try {
            FileInputStream fIn = new FileInputStream((path));
            BufferedInputStream bis = new BufferedInputStream(fIn);
            AdvancedPlayer player = new AdvancedPlayer(bis);
            player.play(); //播放音频文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * javazoom.jl.player.Player类是JLayer提供的标准播放器类，
     * 该类的使用方法非常简单，在创建播放器对象时将MP3文件的文件输入流当做参数，
     * 然后执行播放器的play()方法即可播放。
     **/
    public static void Mp3Player(String path) {
        try {
            Player player = new Player(new FileInputStream(path));
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
//        String filePath = "D:\\test\\music\\三步舞曲.mp3";
//        System.out.println("\n高级播放器，开始播放：" + filePath);
//        Mp3AdvancedPlayer(filePath);
//        System.out.println("\n标准播放器类，开始播放：" + filePath);
        String path = "/Users/chenhui/github/skylinetimer/resources/audio/dingdingding.mp3";
        Mp3Player(path);
    }
}
