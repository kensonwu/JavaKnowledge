package com.kenson.io11.decoratorpattern.simpleexample;

/**
 * @description: 扩音器类 相当于具体的装饰着
 * 使用Amplifier去装饰Voice 把声音扩大
 * @author: Kenson
 * @date: 2020/9/19
 */
public class Amplifier {
    // 持有被装饰者的应用
    public Voice voiceInstance;

    public Amplifier() {
    }

    public Amplifier(Voice voiceInstance) {
        this.voiceInstance = voiceInstance;
    }

    public Voice getVoiceInstance() {
        return voiceInstance;
    }

    public void setVoiceInstance(Voice voiceInstance) {
        this.voiceInstance = voiceInstance;
    }

    /**
     * 定义一个装饰方法,一般与被装饰者方法名相同
     * 用于获取被装饰者属性或者方法扩充功能以达到扩充功能母的
     */
    public void boradcast() {
        System.out.println(voiceInstance.getVoiceNum()*100);
    }
}
