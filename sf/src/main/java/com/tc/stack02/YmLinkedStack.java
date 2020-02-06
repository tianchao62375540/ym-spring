package com.tc.stack02;

import java.util.EmptyStackException;

/**
 * @Auther: tianchao
 * @Date: 2020/2/6 21:23
 * @Description:
 */
public class YmLinkedStack<E> implements YmStack<E> {

    private Node head;

    private int size;

    public YmLinkedStack() {
        this.head = null;
        this.size = 0;
    }


    private class Node{
        E item;
        Node next;

        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(E item) {
           this(item,null);
        }
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E item) {
        head = new Node(item, head);
        size ++;
    }

    @Override
    public E pop() {
        if (size==0){
            throw new EmptyStackException();
        }
        E ret = head.item;
        head = head.next;
        size --;
        return ret;
    }

    @Override
    public E peek() {
        if (size==0){
            throw new EmptyStackException();
        }
        return head.item;
    }
    public static void main(String[] args) {
        YmStack<Integer> stacks = new YmLinkedStack<>();
        for (int i = 0; i < 50; i++) {
            stacks.push(i);
        }
        int size = stacks.size();
        for (int i = 0; i < size; i++) {
            System.out.println(stacks.pop());
        }
    }
}
