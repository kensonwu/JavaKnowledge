package com.kenson.io11.decoratorpattern.advancedexample;

/**
 * @description: 具体构件(ConcreteComponent)角色：定义一个将要接收附加责任的类。
 * @author: Kenson
 * @date: 2020/9/19
 */
public class ConcreteComponent implements Component {

    @Override
    public void sampleOperation() {
        System.out.println("ConcreteComponent");
    }
}
