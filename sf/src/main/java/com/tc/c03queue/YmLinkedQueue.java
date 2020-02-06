package com.tc.c03queue;

import java.util.NoSuchElementException;

/**
 * @Auther: tianchao
 * @Date: 2020/2/7 03:02
 * @Description: 队列 先进先出 ,放在队列头的元素是很容易拿出去的 所以先进来的放在头部
 */
public class YmLinkedQueue<E> implements YmQueue<E>{
    private Node head;
    private Node tail;
    private int size;

    public YmLinkedQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    private class Node{
        E data;
        Node next;
        public Node(E data) {
            this.data = data;
        }
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
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
        /*if (size == 0 ){
            Node node = new Node(e);
            head = node;
            tail = node;
            size ++ ;
            return;
        }
        tail.next = new Node(e);
        tail = tail.next;
        size++;
        return;*/
        //上面思路太复杂 不清晰
        //加进来的节点 肯定排在尾部 当前的tail是尾部的前一个节点
        Node pre = tail;
        tail = new Node(e, null);
        if (size == 0){
            head = tail;
        }else{
            pre.next = tail;
        }
        size++;
    }
    @Override
    public E dequeue() {
        if (size == 0){
            throw new NoSuchElementException("没有元素了");
        }
        E ret = head.data;
        head = head.next;
        size --;
        //为了严紧 但是没啥用应该  因为当size ==0 head=null tail执行了一个元素 但是添加元素的时候 tail tail赋值后从新赋值给了head,并不影响
        if (size == 0){
            tail = null;
        }
        return ret;
    }

    @Override
    public E peek() {
        if (size == 0){
            throw new NoSuchElementException("没有元素了");
        }
        return  head.data;
    }
    public static void main(String[] args) {
        YmQueue<Integer> queue = new YmLinkedQueue<>();
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
        System.out.println("=============");
        //System.out.println(queue.dequeue());
    }
}
