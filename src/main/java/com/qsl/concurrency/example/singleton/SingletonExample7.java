package com.qsl.concurrency.example.singleton;

import com.qsl.concurrency.annotation.Recommend;
import com.qsl.concurrency.annotation.ThreadSafe;

/**
 * 使用枚举
 *
 * @author DanielQSL
 * @date 2018/12/16
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法只被调用一次（绝对的）
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
