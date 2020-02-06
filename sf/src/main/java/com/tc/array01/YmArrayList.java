package com.tc.array01;

import java.util.Arrays;

/**
 * @Auther: tianchao
 * @Date: 2020/2/5 23:09
 * @Description:
 */
public class YmArrayList<E> implements YmList<E>{
    private static final int DEFAULT_CAPACITY = 2;

    private E[] elementData;

    private int size;


    public YmArrayList(int capacity){
        elementData = (E[])new Object[capacity];
    }

    public YmArrayList(){
        this(DEFAULT_CAPACITY);
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contain(E o) {
        for (int i =0;i<size ;i++){
            if (elementData[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        if (index<0||index>=size){
            throw new IllegalArgumentException("数组越界了...");
        }
        return elementData[index];
    }

    @Override
    public void set(int index, E e) {

    }

    @Override
    public void add(int index, E e) {
        if (index<0||index>size){
            throw new IllegalArgumentException("数组越界了...");
        }

        //grow
        if (size == elementData.length){
            grow(elementData.length*2);
        }

        //该位置后面元素挪位置
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i-1];
        }

        elementData[index] = e;
        size ++;
    }

    private void grow(int newCapacity) {
        /*E[] newElementData = (E[])new Object[elementData.length*2];
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }*/
        if (newCapacity <= DEFAULT_CAPACITY){
            return;
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
        //elementData = newElementData;
    }

    @Override
    public void add(E e) {
        add(size,e);
    }

    @Override
    public E remove(int index) {
        if (index<0||index>=size){
            throw new IllegalArgumentException("数组越界了...");
        }
        E val =  elementData[index];
        for (int i = index+1; i < size; i++) {
            elementData[i-1] = elementData[i];
        }
        if (size <= elementData.length/2){
            grow(elementData.length/2);
        }
        size -- ;
        elementData[size] = null;
        return val;
    }

    public void show(){
        for (int i = 0;i<size;i++){
            System.out.println(elementData[i]);
        }
    }


    public void removeFirst(E e){
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(e)){
                remove(i);
                return;
            }
        }
    }
    public static void main(String[] args) {
        YmArrayList<Integer> list = new YmArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(i+"   "+list.get(i));
        }

        for (int i = 0; i < 100; i++) {
            if (i%3==0){
                list.removeFirst(i);
            }
        }
        for (int i = 0; i < list.size; i++) {
            System.out.println(i+"   "+list.get(i));
        }
    }
}
