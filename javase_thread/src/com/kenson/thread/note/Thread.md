# Thead基础知识
#### 基本概念
- **程序**： 使用编程语言编写的并实现了一定功能的软件/应用/系统
- **线程**： 启动中的程序，才做系统会为启动的程序分配内存空间
- **进程**： CPU具体的执行单元,它是进程的组成部分，一个*进程*可能包含多个*线程*
- **并发和并行的区别：**
并发具有处理多个任务的能力，**不一定同时**进行
并行就是具有处理多个任务的能力，但是是**同时进行**
#### 线程的特点：
-    轻量级进程
-    并发执行多任务
-    独立调度的基本单位
-    共享进程资源
#### Java中创建线程的三种方式：
- 继承Threah() + run()
- 实现Runnable + run() 推荐使用此方式避免多继承以及资源共享
- 使用Callable创建线程  可以对外申明异常，同时也可以返回值
#### Java中创建线程的状态：
- 新生状态
- 就绪状态
- 运行状态
- 阻塞状态
    - 阻塞的方法：
        - join():强行插队, 会阻塞当前的线程的执行
        - yield():暂停自身线程的执行，如果无其他等待执行的线程，可立即回到运行状态
        - sleep():当前线程等待执行，如果无其他等待执行的线程，也不会立即回到运行状态
        - setDaemon():设置后台线程，只能在start()之前进行设置
        - interuput():并没有直接中断程序,需要线程自己进行处理
- 死亡状态
#### Java中线程的同步：
- 通过synchronized实现
- 同步方法
    - [ ] synchronized(引用类型变量|this|类.class){}
- 同步代码块
    - [ ] 修饰符 synchronized 方法的签名{方法体}
- 显示Lock锁
- 过多的同步可能造成死锁
    - [ ] 如果解决过多的同步造成的死锁呢？那就是生产消费者模式
#### Java中线程的通信
* Java中提供了3个方法解决线程之间的通信问题：
* final void wait() 等待, 表示线程一直等待，直到其他线程通知，  释放锁
* void wait(long timeout) 线程等待指定毫秒参数的时间，释放锁
* final void wait(long timeout, int nanos) 线程等待指定毫秒、微妙的时间
* final void notify() 唤醒一个处于等待状态的线程
* final void notifyAll() 唤醒同一个对象上所有调用wait()方法的线程，优先级别高的线程有限运行
* **wait(), notify(), notifyAll()这三个方法都是java.lang.Object类的中方法，只能用于同步方法或同步代码块中使用，否则会抛出异常**
* wait()方法用来通知那些可能等待该对象的对象锁的其他线程，如果有多个线程在等待，那么线程规划器会从等待池中任意挑选出一个来唤醒，并且使它等待获取对象，它并不会立马获得该对象的锁，
要等到线程执行完synchronized代码块/synchronized方法后，才会释放锁，被唤醒的那个线程才会获得该对象的锁。即使被唤醒的线程执行完成并且释放锁，如果不再次调用notify()方法，那么其他等待池中的线程
也会一直处理等待阻塞状态。
* notifyAll()方法是使所有原来对象的wait()的线程全部退出wait()阻塞状态，全部进入锁池中，但是此时还没获得锁，不能立马执行，
一旦对象锁被释放，被唤醒的所有对象都会去竞争对象锁，一旦对象被获取，则其他的在锁池中的对象会等待，等到执行完synchronized代码块/synchronized方法后
释放锁，其他线程就会继续竞争.. 知道所有线程都执行完毕。
* 以上三个方法的区别可以参考 [https://blog.csdn.net/weixin_42504145/article/details/85329386]()
#### Java中线程组：
- 定义： 对线程进行分组
- 目的：
    * 统一管理：便于一组线程进行批量管理线程或线程组对象
    * 安全隔离：允许线程访问有关自己的线程组信息，但是不允许它访问有关其线程组的父线程或其他任何线程组信息
- JAVA中如果创建一个线程，没有分组的话，那么默认就在main线程组中
#### Java中线程池：
- 创建和销毁对象是非常耗时的
- 创建对象： 需要分配内存资源等
- 销毁对象：虽然程序要无需关心，但是垃圾回收器会在后台一直跟踪并销毁
- 经常创建、销毁对象是相当耗时的，对性能影响很大。那如何解决呢？ 那就是事先创建好多个线程放入到线程池中，使用时，直接引用，不使用时，返回线程池，避免重复创建、销毁、海鲜重复利用(JDK1.5后提供内置线程池)
- 好处：
    * 提高响应速度
    * 降低资源消耗
    * 提供线程的可管理性
- 使用场景
    * 需要大量线程，并且完成任务时间短
    * 对性能要求苛刻
    * 接收突发性的大量请求
#### Java中封装的类：
- InetAddress
- InetSocketAddress
- URL
- TCP
- UDP
