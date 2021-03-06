# Java8新特性
### Lambada表达式
* 概念: Lambada是一个匿名函数，个人理解就是一个语法糖。理解为是一段可以传递的代码(将代码像数据一样的传递)。可以写出简洁，更灵活的代码。
* Java中引入了一个新的操作符 -> 叫做箭头操作符/Lambada表达式操作符
* 箭头操作符把Lambada表达式拆分成了两部分：
* 左侧：Lambada表达式的参数列表
* 右侧：Lambada表达式中所需执行的功能，既:Lambada体
### Lambada的基础语法
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
### Java8 四大核心接口
* Consumer<T>: 消费型接口
    * void accept(T t);
* Supplier<T>: 供给型接口
    * T get();
* Function<T, R>: 函数型接口
    * R apply(T t);
* Predicate<T>: 断言型接口
    * boolean test(T t);
### 方法引用
* 什么是方法引用：若Lambada表达式有方法已经实现了，我们可以使用"方法引用"
* 也可以理解为：方法引用是Lambada表达式的另一种表现形式
* 方法引用主要三个语法格式：
* 对象::实例方法名
* 类::静态方法名
* 类::实例方法名
* 注意事项：
    * 若Lambada体中，调用方法的参数列表和返回值类型要与函数式接口中定义的抽象方法的参数列表和返回值类型相同， 否则不能使用方法引用
    * 若Lambada体中, 参数列表中的第一个参数是实例方法调用者，而第二个参数是实例方法的参数时可以使用 "类::实例方法名" 来简化Lambada体
* 构造器引用：
    * ClassName::new
* 数组引用：
    * Type[]:new
### 强大的Stream API
* 什么是流：stream是数据渠道、用于操作数据源(集合、数组等)所生成的元素序列
* 集合讲的是数据，流讲的是计算
* 注意点：
    * Stream 不会自己存储元素
    * Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream
    * Stream操作式延迟执行的。这意味着他们会等到需要结果的时候才执行
* Stream操作三部曲：
    * 创建Stream： 一个数据源(集合、数组等)，获取一个流
    * 中间操作
    * 终止操作(终端操作)