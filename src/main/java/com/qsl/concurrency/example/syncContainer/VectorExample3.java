package com.qsl.concurrency.example.syncContainer;

import com.qsl.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Vector也有线程不安全的操作
 *
 * @author DanielQSL
 * @date 2018/12/17
 */
@Slf4j
@ThreadSafe
public class VectorExample3 {

    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }
}
