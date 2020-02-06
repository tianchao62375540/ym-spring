package com.tc.c03queue;

/**
 * @Auther: tianchao
 * @Date: 2020/2/7 01:19
 * @Description:
 */
public interface YmQueue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E peek();
}
