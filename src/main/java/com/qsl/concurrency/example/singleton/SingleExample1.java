package com.qsl.concurrency.example.singleton;

import com.qsl.concurrency.annotation.NotThreadSafe;

/**
 * 懒汉模式
 * 单例的实例在第一次使用时创建
 * 问题：单线程模式下没有问题
 * @author DanielQSL
 * @date 2018/12/16
 */
@NotThreadSafe
public class SingleExample1 {

    //私有构造函数
    private SingleExample1(){

    }

    //单例对象
    private static SingleExample1 instance=null;

    //静态工厂方法
    public static SingleExample1 getInstance(){
        if (instance == null) {
            //多线程访问到此处，会出现问题，可能两个线程同时进来
            //即便构造两次，为什么会出现问题呢？因为私有构造方法中会有大量的逻辑，若是构造两次便会出现问题
            instance=new SingleExample1();
        }
        return instance;
    }
}
