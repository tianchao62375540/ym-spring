package com.tc.a01array;

/**
 * @Auther: tianchao
 * @Date: 2020/2/5 22:49
 * @Description:
 */
public interface YmList<E> {


    int getSize();

    boolean isEmpty();

    boolean contain(E o);

    int indexOf(E e);

    E get(int index);

    void set(int index , E e);

    void add(int index, E e);

    void add(E e);

    E remove (int index);
}
