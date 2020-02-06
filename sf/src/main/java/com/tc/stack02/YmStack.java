package com.tc.stack02;

/**
 * @Auther: tianchao
 * @Date: 2020/2/6 20:40
 * @Description:
 */
public interface YmStack<E> {

    boolean isEmpty();

    int size();

    void push(E item);

    E pop();

    E peek();
}
