package com.qsl.concurrency.example.threadlocal;

/**
 * @author DanielQSL
 * @date 2018/12/17
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        //requestHolder其实是一个map，key为线程id
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
