package com.kenson.generic1;

/**
 * @description: 在泛型类中定义泛型方法：
 * 泛型父类	子类是富二代也就是必须保留父类的泛型参数， 位置可调换
 * 1、保留父类泛型 	---> 子类有泛型
 * 2、不保留父类泛型	---> 子类按需实现
 * 子类方法的类型 随父类而定（当然是重写的方法）
 * 属性及方法 类型		---> 随位置而定
 * 子类重写方法的类型	-->  随父类而定
 * 子类新增方法的类型	-->  随子类而定
 * 子类中使用父类的属性	-->  随父类而定
 * 子类中使用自己的属性	-->  随子类而定
 *
 * @author: Kenson
 * @date: 2020/9/15
 */
public abstract class GenericMethod3<T1, T2> {
    T1 age;

    public abstract void test(T2 name);
}

//保留
//1)、 全部保留	--> 泛型子类
class C1<T1, T2> extends GenericMethod3<T1, T2> {

    @Override
    public void test(T2 name) {
        //this.age;	---> T1类型
    }

}

//2）、 部分保留
class C2<T2> extends GenericMethod3<Integer, T2> {    //需要保留T2 否则编译不能通过

    @Override
    public void test(T2 name) {
        //this.age;	//Integer 子类类型
    }

}

class C7<T2> extends GenericMethod3<String, T2> {    //需要保留T2 否则编译不能通过

    @Override
    public void test(T2 name) {
        //this.age;	//Integer 子类类型
    }

}

//不保留
//1）、具体类型
class C3 extends GenericMethod3<Integer, String> {

    @Override
    public void test(String name) {
        //this.age	-->Integer
    }

}

class C8 extends GenericMethod3<Integer, Character> {

    @Override
    public void test(Character name) {
        //this.age	-->Integer
    }

}

//2、 没有类型，就是擦除， 相当于Object
class C4 extends GenericMethod3 {

    @Override
    public void test(Object name) {
        //this.age	-->Object
    }

}
