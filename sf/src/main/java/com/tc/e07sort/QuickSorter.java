package com.tc.e07sort;

import java.util.Arrays;

/**
 * @Auther: tianchao
 * @Date: 2020/3/1 22:34
 * @Description:
 */
public class QuickSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        sortHelper(arr, 0, arr.length - 1);
    }

    void sortHelper(int[] arr,int start,int end){
        if (start >= end){
            return;
        }
        int index = partition(arr,start,end);
        sortHelper(arr, start, index-1);
        sortHelper(arr, index+1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start + 1;
        for (int j = start + 1; j <= end; j++) {
            if (arr[j] <= pivot){
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, start,i-1);
        return i-1;
    }

    private void swap(int arr[],int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arrayToSort = SortUtils.buildRandomIntArray(100);
        SortUtils.printArray(arrayToSort);
        int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
        Arrays.sort(arrayClone);
        Sorter sorter = new QuickSorter();
        sorter.sort(arrayToSort);
        SortUtils.printArray(arrayToSort);
        System.out.println(SortUtils.isEquals(arrayClone, arrayToSort));
    }


}
