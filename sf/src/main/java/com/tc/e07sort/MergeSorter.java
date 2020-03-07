package com.tc.e07sort;

import java.util.Arrays;

/**
 * @Auther: tianchao
 * @Date: 2020/3/1 15:34
 * @Description:
 */
public class MergeSorter implements Sorter{
    @Override
    public void sort(int[] arr) {
        sortHelper(arr, 0, arr.length-1,new int[arr.length]);
    }

    public void sortHelper(int[] arr,int start,int end,int[] temp){
        if (start>=end){
            return;
        }
        int mid = (start + end)/2;
        sortHelper(arr, start, mid, temp);
        sortHelper(arr, mid+1, end, temp);
        merge(arr, start, mid,mid+1, end, temp);
    }
    public void merge(int[] arr,int s1,int e1,int s2,int e2,int[] temp){
        int i = s1,j = s2,k = 0;
        while (i<=e1&&j<=e2){
            if (arr[i]<=arr[j]){
                temp[k++] = arr[i];
                i++;
            }else{
                temp[k++] = arr[j];
                j++;
            }
        }
        while (i<=e1){
            temp[k++] = arr[i];
            i++;
        }
        while (j<=e1){
            temp[k++] = arr[j];
            j++;
        }
        for (int l = 0;l<k;l++){
            arr[s1+l] = temp[l];
        }
    }
    public static void main(String[] args) {
        int[] arrayToSort = SortUtils.buildRandomIntArray(1000);
        SortUtils.printArray(arrayToSort);
        int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
        Arrays.sort(arrayClone);
        Sorter sorter = new MergeSorter();
        sorter.sort(arrayToSort);
        SortUtils.printArray(arrayToSort);
        System.out.println(SortUtils.isEquals(arrayClone, arrayToSort));
    }
}
