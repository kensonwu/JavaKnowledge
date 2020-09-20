package com.kenson.thread01.staticproxy;

/**
 * @description: 代理角色
 * 为真实角色添加一些附加的功能，比如：婚庆布置，准备婚车， 摄像等等
 * 真实角色值需要上台结婚就行了
 * @author: Kenson
 * @date: 2020/9/20
 */
public class WeddingCompany implements Marry {
    // 持有真实角色的应用，这里使用接口更加通用
    private Marry bridegroom;

    public WeddingCompany() {
    }

    public WeddingCompany(Marry bridegroom) {
        this.bridegroom = bridegroom;
    }

    public Marry getBridegroom() {
        return bridegroom;
    }

    public void setBridegroom(Marry bridegroom) {
        this.bridegroom = bridegroom;
    }

    private void before() {
        System.out.println("布置猪窝.....");
    }

    /**
     * 结婚这件事情还是需要真实角色来完成，婚庆公司没办法代理
     * 那么怎么让真实角色来完成呢？
     * 那就是使用真实角色对象调用真实角色的方法就行了
     */
    @Override
    public void marry() {
        before();
        bridegroom.marry();
        after();
    }

    private void after() {
        System.out.println("闹玉兔...");
    }
}
