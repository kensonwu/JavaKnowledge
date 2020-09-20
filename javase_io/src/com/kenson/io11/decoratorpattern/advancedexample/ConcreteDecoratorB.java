package com.kenson.io11.decoratorpattern.advancedexample;

/**
 * @description: 具体装饰(ConcreteDecorator)角色：负责给构件对象“贴上”附加的责任。
 * @author: Kenson
 * @date: 2020/9/19
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void sampleOperation() {
        System.out.println("具体装饰者B 对被装饰者进行装饰！");
    }
}
