package com.qsl.concurrency.example.atomic;

import com.qsl.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * 使用了atomicReference使得计数变得安全
 *
 * @author DanielQSL
 * @date 2018/12/12
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

    public static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0, 1);
        count.compareAndSet(0, 2);
        count.compareAndSet(1, 3);

        System.out.println(count);
    }
}
