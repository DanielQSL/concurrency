package com.qsl.concurrency.example.publish;

import com.qsl.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 这样发布对象的线程是不安全的，我们无法确定别的线程
 * 是否会对创建出来的对象进行修改
 * @author DanielQSL
 * @date 2018/12/16
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String[] states={"a","b","c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish=new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0]="d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }
}
