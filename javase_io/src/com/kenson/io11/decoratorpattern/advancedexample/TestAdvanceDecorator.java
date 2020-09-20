package com.kenson.io11.decoratorpattern.advancedexample;

/**
 * @description:
 * @author: Kenson
 * @date: 2020/9/19
 */
public class TestAdvanceDecorator {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        ConcreteDecoratorA cda = new ConcreteDecoratorA(component);
        ConcreteDecoratorB cda1 = new ConcreteDecoratorB(component);
        cda.sampleOperation();
        cda1.sampleOperation();
    }
}
