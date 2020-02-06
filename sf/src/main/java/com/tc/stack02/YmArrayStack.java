package com.tc.stack02;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Auther: tianchao
 * @Date: 2020/2/6 20:40
 * @Description:
 */
public class YmArrayStack<E> implements YmStack<E> {
    private E[] elementData;
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private int top;

    public YmArrayStack(int capacity) {
        this.elementData = (E[])new Object[capacity];
        this.size = 0;
        this.top = -1;
    }
    public YmArrayStack(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        System.out.println("===="+size);
        return size;
    }

    @Override
    public void push(E item) {
        if (size == elementData.length){
            grow(elementData.length*2);
        }
        elementData[++top]=item;
        size++;
    }
    private void grow(int newCapacity) {
        if (newCapacity <= DEFAULT_CAPACITY){
            return;
        }
        /*E[] newElementData = (E[])new Object[elementData.length*2];
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }*/
        elementData = Arrays.copyOf(elementData,newCapacity);
        //elementData = newElementData;
    }

    @Override
    public E pop() {
        if (size == 0){
            throw new EmptyStackException();
        }
        if (size<elementData.length/2){
            grow(elementData.length/2);
        }
        size--;
        return elementData[top--];
    }

    @Override
    public E peek() {
        if (size == 0){
            throw new EmptyStackException();
        }
        return elementData[top];
    }

    public static void main(String[] args) {
        YmStack<Integer> stacks = new YmArrayStack<>();
        for (int i = 0; i < 50; i++) {
            stacks.push(i);
        }
        int size = stacks.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stacks.peek());
        }
    }
}
