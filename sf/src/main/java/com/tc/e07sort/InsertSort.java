package com.tc.e07sort;

import javafx.beans.binding.When;

import java.util.Arrays;

/**
 * @Auther: tianchao
 * @Date: 2020/2/28 21:48
 * @Description:
 */
public class InsertSort implements Sorter {
    /*@Override
    public void sort(int[] arr) {
        if (arr.length<=1){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0; j--) {
                if (arr[j]<arr[j-1]){
                    int temp =arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }*/

    public static void main(String[] args) {
        int[] arrayToSort = SortUtils.buildRandomIntArray(20);
        SortUtils.printArray(arrayToSort);
        int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
        Arrays.sort(arrayClone);
        InsertSort sorter = new InsertSort();
        sorter.sort(arrayToSort);
        SortUtils.printArray(arrayToSort);
        System.out.println(SortUtils.isEquals(arrayClone, arrayToSort));
    }

    @Override
    public void sort(int[] arr) {
        if (arr.length<=1){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i - 1;
            //二分查找 可以优化
            while (j>=0&&element<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }
    }
}
