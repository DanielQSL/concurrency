package com.qsl.concurrency.example.singleton;

import com.qsl.concurrency.annotation.NotThreadSafe;

/**
 * 懒汉模式-双重同步锁单例模式
 * 问题：为什么不是线程安全的呢？
 * instance = new SingleExample4();cpu创建过程
 * 1、memory=allocate() 分配对象的内存空间
 * 2、ctorInstance()初始化对象
 * 3、instance=memory 设置instance指向刚分配的内存
 * <p>
 * 以上步骤单线程没有任何问题，但是在多线程的情况下有问题
 * JVM和cpu优化，发生了指令重排
 * 1、memory=allocate() 分配对象的内存空间
 * 3、instance=memory 设置instance指向刚分配的内存
 * 2、ctorInstance()初始化对象
 *
 * 注：虽然发生概率不大，但是也是存在线程不安全的
 * @author DanielQSL
 * @date 2018/12/16
 */
@NotThreadSafe
public class SingleExample4 {

    //私有构造函数
    private SingleExample4() {

    }

    //单例对象 volatile+双重检测机制 -》禁止指令重排
    private static SingleExample4 instance = null;

    //静态工厂方法
    public static synchronized SingleExample4 getInstance() {
        if (instance == null) {//双重检测机制
            synchronized (SingleExample4.class) {//同步锁
                if (instance == null) {
                    instance = new SingleExample4();
                }
            }
        }
        return instance;
    }
}
