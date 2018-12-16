package com.qsl.concurrency.example.singleton;

import com.qsl.concurrency.annotation.NotRecommend;
import com.qsl.concurrency.annotation.ThreadSafe;

/**
 * 懒汉模式(synchronized线程安全版)
 * 问题：synchronized同一时间只允许一个线程访问，带来了性能问题
 * @author DanielQSL
 * @date 2018/12/16
 */
@ThreadSafe
@NotRecommend
public class SingleExample3 {

    //私有构造函数
    private SingleExample3(){

    }

    //单例对象
    private static SingleExample3 instance=null;

    //静态工厂方法
    public static synchronized SingleExample3 getInstance(){
        if (instance == null) {
            instance=new SingleExample3();
        }
        return instance;
    }
}
