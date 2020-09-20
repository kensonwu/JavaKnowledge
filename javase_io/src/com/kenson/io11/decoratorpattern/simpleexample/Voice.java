package com.kenson.io11.decoratorpattern.simpleexample;

/**
 * @description: 声音类 相当于被装饰者
 * @author: Kenson
 * @date: 2020/9/19
 */
public class Voice {
    // 音量
    private int voiceNum = 10;

    public Voice() {
    }

    public Voice(int voiceNum) {
        this.voiceNum = voiceNum;
    }

    public int getVoiceNum() {
        return voiceNum;
    }

    public void setVoiceNum(int voiceNum) {
        this.voiceNum = voiceNum;
    }

    public void boradcast() {
        System.out.println(this.voiceNum);
    }
}
