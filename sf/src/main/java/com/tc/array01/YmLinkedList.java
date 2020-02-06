package com.tc.array01;

/**
 * @Auther: tianchao
 * @Date: 2020/2/6 14:23
 * @Description:
 */
public class YmLinkedList<E> implements YmList<E>{

    private YmNode head;
    private int size;

    public YmLinkedList() {
        head = null;
        size = 0;
    }

    private class YmNode{
        public YmNode next;
        private E data;
        public YmNode(YmNode next, E data) {
            this.next = next;
            this.data = data;
        }
        public YmNode(E data) {
            this(null,data);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contain(E o) {
        YmNode p = head;
        while (p != null){
            if (p.data.equals(o)){
                return true;
            }
            p = p.next;
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        int result = -1;
        int val = 0;
        YmNode temp = head;
        while (temp != null){
            if (temp.data.equals(e)){
                result = val;
            }
            val ++;
            temp = temp.next;
        }
        return result;
    }

    @Override
    public E get(int index) {
        if (index<0||size<=index){
            throw new IllegalArgumentException("超过链表长度");
        }
        YmNode result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }



    @Override
    public void set(int index, E e) {
        if (index<0||size<=index){
            throw new IllegalArgumentException("超过链表长度");
        }
        YmNode result = head;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        result = new YmNode(result.next,e);
        head = result;
    }

    @Override
    public void add(int index, E e) {
        if (index<0||size<index){
            throw new IllegalArgumentException("超过链表长度");
        }
        if (index == 0){
            addFirst(e);
        }else if (index == size){
            addLast(e);
        }else{

            YmNode pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            YmNode insert = new YmNode(pre.next,e);
            pre.next = insert;
            size ++;
        }

    }

    private void addFirst(E e){
        YmNode node = new YmNode(head, e);
        head = node;
        size ++;
    }
    private void addLast(E e){
        YmNode node = new YmNode(null, e);
        if (head == null){
            head = node;
            size ++;
            return;
        }
        YmNode prev = head;
        while (prev.next != null){
            prev = prev.next;
        }
        prev.next = node;
        size++;
    }

    @Override
    public void add(E e) {
        add(size, e);
    }

    @Override
    public E remove(int index) {
        if (index<0||size<=index){
            throw new IllegalArgumentException("超过链表长度");
        }
        if (index == 0){
            return removeFirst();
        }else if (index == size - 1){
            E data;
            YmNode pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            data = pre.next.data;
            pre.next = null;
            size --;
            return data;
        }else{
            E data;
            YmNode pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            data = pre.next.data;
            pre.next = pre.next.next;
            size--;
            return data;
        }
    }

    private E removeFirst() {
        E data;
        data = head.data;
        head = head.next;
        size --;
        return data;
    }
    private E removeLast() {
        E ret;
        YmNode pre = head;
        for (int i = 0; i < size - 1; i++) {
            pre = pre.next;
        }
        ret = pre.next.data;
        pre.next = null;
        size --;
        return ret;
    }

    public static void main(String[] args) {
        YmList<User> list = new YmLinkedList<>();
        list.add(0,new User(1));
        list.add(0,new User(2));
        list.add(0,new User(3));
        list.add(0,new User(4));
        list.add(1,new User(5));
        list.remove(0);
        list.remove(list.getSize()-2);
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(i+"==============="+list.get(i));
        }
    }
    private static class User{
        private Integer id;
        public User(Integer id) {
            this.id = id;
        }
        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    '}';
        }
    }
}
