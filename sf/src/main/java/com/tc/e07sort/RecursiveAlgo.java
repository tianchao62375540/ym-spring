package com.tc.e07sort;

import com.tc.a01array.YmLinkedList;
import org.junit.Test;

/**
 * @Auther: tianchao
 * @Date: 2020/3/1 15:01
 * @Description:
 */
public class RecursiveAlgo {
    private class YmNode<E>{
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

    public void printList(YmNode node){
        if (node == null){
            return;
        }
        System.out.println(node.data);
        printList(node.next);
    }
    public void printListReverse(YmNode node){
        if (node == null){
            return;
        }
        printList(node.next);
        System.out.println(node.data);
    }



    public int sum(int n){
        if (n==1){
            return 1;
        }
        return n + sum(n-1);
    }
    public int sum(int[] arr,int startIndex, int endIndex){
        if (startIndex == endIndex){
            return arr[startIndex];
        }
        return arr[startIndex] + sum(arr,startIndex+1,endIndex);
    }

    @Test
    public void sumArray(){
        int[] array = SortUtils.buildRandomIntArray(10);
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            sum+=array[i];
        }
        System.out.println(sum == sum(array,1,array.length-1));
    }

    @Test
    public void testSum(){
        RecursiveAlgo recursiveAlgo = new RecursiveAlgo();
        System.out.println(recursiveAlgo.sum(100));
    }
}
