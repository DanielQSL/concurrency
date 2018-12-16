package com.qsl.concurrency.example.singleton;

import com.qsl.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式-双重同步锁单例模式（volatile）
 * 问题：限制指令重排
 *
 * @author DanielQSL
 * @date 2018/12/16
 */
@ThreadSafe
public class SingleExample5 {

    //私有构造函数
    private SingleExample5() {

    }

    //单例对象
    private volatile static SingleExample5 instance = null;

    //静态工厂方法
    public static synchronized SingleExample5 getInstance() {
        if (instance == null) {//双重检测机制
            synchronized (SingleExample5.class) {//同步锁
                if (instance == null) {
                    instance = new SingleExample5();
                }
            }
        }
        return instance;
    }
}
