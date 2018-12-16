package com.qsl.concurrency.example.singleton;

import com.qsl.concurrency.annotation.ThreadSafe;

/**
 * 饿汉模式
 * 单例的实例在类装载时创建
 * 问题：1、若是构造方法中有过多的处理，会在类加载时非常慢，因此可能会引起性能问题
 * 2、若是没有进行调用的话，会导致资源的浪费
 * @author DanielQSL
 * @date 2018/12/16
 */
@ThreadSafe
public class SingleExample2 {

    //私有构造函数
    private SingleExample2() {

    }

    //单例对象
    private static SingleExample2 instance = new SingleExample2();

    //静态工厂方法
    public static SingleExample2 getInstance() {
        return instance;
    }
}
