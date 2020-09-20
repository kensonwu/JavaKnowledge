package com.kenson.io11.decoratorpattern.advancedexample;

/**
 * @description: 具体的装饰者
 * 具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。
 * @author: Kenson
 * @date: 2020/9/19
 */
public class ConcreteDecoratorA extends Decorator {
    // 持有Component对象
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    // 重写装饰方法
    @Override
    public void sampleOperation() {
        System.out.println("具体装饰者A 对ConcreteComponet进行装饰！");
    }
}
