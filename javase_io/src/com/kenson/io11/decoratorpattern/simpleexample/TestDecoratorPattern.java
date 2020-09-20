package com.kenson.io11.decoratorpattern.simpleexample;

/**
 * @description: 测试装饰模式
 * @author: Kenson
 * @date: 2020/9/19
 */
public class TestDecoratorPattern {
    public static void main(String[] args) {
        Voice voice = new Voice();
        voice.boradcast();
        Amplifier ap = new Amplifier(voice);
        ap.boradcast();
    }
}
