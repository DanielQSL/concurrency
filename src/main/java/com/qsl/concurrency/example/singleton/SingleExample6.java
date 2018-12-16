package com.qsl.concurrency.example.singleton;

import com.qsl.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式(优化)
 * 问题：
 * @author DanielQSL
 * @date 2018/12/16
 */
@ThreadSafe
public class SingleExample6 {

    //私有构造函数
    private SingleExample6() {

    }

    //单例对象
    private static SingleExample6 instance = null;

    static {
        instance=new SingleExample6();
    }

    //静态工厂方法
    public static SingleExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        //在写静态域和静态代码块时，一定要注意顺序，顺序不一样，执行结果有所不同


        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
