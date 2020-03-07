package com.tc.e07sort;

import java.util.Arrays;

/**
 * @Auther: tianchao
 * @Date: 2020/3/1 14:27
 * @Description:
 */
public class SelectionSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        if (arr.length<=1){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //int min = arr[i];
            int minIndex = i;
            for (int j = i+1; j < arr.length ; j++) {
                if (arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] =temp;
        }
    }
    public static void main(String[] args) {
        int[] arrayToSort = SortUtils.buildRandomIntArray(20);
        SortUtils.printArray(arrayToSort);
        int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
        Arrays.sort(arrayClone);
        Sorter sorter = new SelectionSorter();
        sorter.sort(arrayToSort);
        SortUtils.printArray(arrayToSort);
        System.out.println(SortUtils.isEquals(arrayClone, arrayToSort));
    }
}
