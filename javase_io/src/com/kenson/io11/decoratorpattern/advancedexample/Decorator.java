package com.kenson.io11.decoratorpattern.advancedexample;

/**
 * @description: 装饰(Decorator)角色：持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口。
 * @author: Kenson
 * @date: 2020/9/19
 */
public class Decorator implements Component {
    // 持有抽象构建的对象
    private Component component;

    public Decorator() {
    }

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void sampleOperation() {
        // 增强功能
        System.out.println("增强功能，可用调用具体被装饰者的方法或者属性进行增强");
        // 也可以调用被装饰者的方法
        component.sampleOperation();
    }
}
