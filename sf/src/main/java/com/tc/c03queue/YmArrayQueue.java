package com.tc.c03queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @Auther: tianchao
 * @Date: 2020/2/7 01:21
 * @Description:
 */
public class YmArrayQueue<E> implements YmQueue<E> {

    private E[] element;

    private int size;
    /**
     *  头指针
     */
    private int head;
    /**
     * 尾指针
     */
    private int tail;

    private static final int DEFAULT_CAPACITY = 10;

    public YmArrayQueue(int capacity) {
        this.size = 0;
        this.head = -1;
        this.tail = -1;
        this.element = (E[])new Object[capacity];
    }

    public YmArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (element.length == size){
            //扩容
            grow(element.length*2);
        }
        //尾部位置
        tail = (tail + 1)% element.length;
        element[tail] = e;
        //只有size是0的时候，需要维护头的位置 时候头的位置和尾的位置一样，并不一定是0
        if(size == 0){
            head = tail;
        }
        size++;
    }

    private void grow(int newCapacity) {
        //不能无限缩小容量
        if (newCapacity<=DEFAULT_CAPACITY){
            return;
        }
        //element = Arrays.copyOf(element, newCapacity);
        E[] oldElement =  element;
        element = (E[])new Object[newCapacity];
        for (int i = 0;i<size;i++){
            element[i] = oldElement[(head+i)%oldElement.length];
        }
        head = 0;
        tail = size - 1;
    }

    @Override
    public E dequeue() {
        if (size==0){
            throw new NoSuchElementException("队列size为0，无法取出数据");
        }
        E ret = element[head];
        head = (head + 1)% element.length;
        size -- ;
        if (size<=element.length/2){
            grow(element.length/2);
        }
        return ret;
    }

    @Override
    public E peek() {
        if (size==0){
            throw new NoSuchElementException("队列size为0，无法取出数据");
        }
        return element[head];
    }

    public static void main(String[] args) {
        YmQueue<Integer> queue = new YmArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println("================");
        int size = queue.size();
        for (int i = 0; i <size ; i++) {
            System.out.println(queue.dequeue());
        }
        queue.enqueue(500);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println("=========");
        System.out.println(queue.dequeue());
    }
}
