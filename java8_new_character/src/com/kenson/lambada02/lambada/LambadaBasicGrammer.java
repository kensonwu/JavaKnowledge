package com.kenson.lambada02.lambada;

import org.junit.Test;

import java.time.Year;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @description: Lambada的基础语法
 * Java中引入了一个新的操作符 -> 叫做箭头操作符/Lambada表达式操作符
 * 箭头操作符把Lambada表达式拆分成了两部分：
 * 左侧：Lambada表达式的参数列表
 * 右侧：Lambada表达式中所需执行的功能，既:Lambada体
 * 语法格式一： 无参数，无返回值
 * () -> 功能实现
 * 语法格式二： 有一个参数，并且无返回值
 * (x) -> 功能实现
 * 语法格式三： 若只有参数, 小括号可以不写
 * x -> 功能能实现
 * 语法格式四：有两个参数，有返回值，并且Lambada体中有多条语句
 * (x,y) -> {语句1; 语句2;语句3;return 结果;}
 * 语法格式五：若Lambada体中只有一条语句,return和大括号均可以不写
 * (x,y) -> 一句代码的功能处理
 * 语法格式六：Lambada表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出数据类型，即："类型推断"
 * (Integer x, Integer y) -> x.compareTo(y)
 * 上联：左右遇一括号省
 * 下联：左侧推断类型省
 * 横批：能省则省
 * Lambada表达式需要"函数式接口"的支持
 * 函数式接口：接口中只有一个抽象法的接口，称为函数式接口。可以使用注解：@FunctionalInterface 修饰
 * 注解 @FunctionalInterfaced可以检查接口是否是函数式接口
 * @author: Kenson
 * @date: 2020/9/27
 */
public class LambadaBasicGrammer {

    @Test
    public void test1() {
        // java8之前的方式
        // java8 之前如果在局部内部内中用了同级别的局部变量, 那么该局部变量只能申明为final
        // 但是在java8中 无需显示申明为final, 默认就是final的
        int num = 0;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Thread..." + num);
            }
        };
        runnable.run();
        System.out.println("----------------");
        Runnable runnable1 = () -> System.out.println("Hello Thread" + num);
        runnable1.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("Lambada表达式");
        // 只有一个参数，小括号可以不写， 一般还是给写上
        Consumer<String> con2 = x -> System.out.println(x);
        con2.accept("只有一个参数，小括号可以不写， 一般还是给写上");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("这里是逻辑处理");
            return x.compareTo(y);
        };
    }

    @Test
    public void test4() {
        // 参数类型一般可以省略不写， 如果参数列表类型要写，都需要全写。省略时，JVM会对类型进行自动推断
        Comparator<Integer> com = (Integer x, Integer y) -> x.compareTo(y);
    }

    // 需求： 使用Lambada表达式 对一个数进行运算
    @Test
    public void test5() {
        // 你需要对这个进行怎样的运算
        Integer rslt = operation(100, x -> x * 100);
        System.out.println("运算结果为： " + rslt);
        System.out.println("-------------");
        Integer num = operation(100, param -> param * 10 + 200);
        System.out.println(num);
    }

    public Integer operation(Integer t, MyCalculator<Integer> cal) {
        return cal.getValue(t);
    }
}
