package com.tc.e07sort;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;

/**
 * @Auther: tianchao
 * @Date: 2020/2/28 21:19
 * @Description:
 */
public class BubbleSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        if (arr.length<=1){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp =arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrayToSort = SortUtils.buildRandomIntArray(20);
        SortUtils.printArray(arrayToSort);
        int[] arrayClone = Arrays.copyOf(arrayToSort, arrayToSort.length);
        Arrays.sort(arrayClone);
        BubbleSorter sorter = new BubbleSorter();
        sorter.sort(arrayToSort);
        SortUtils.printArray(arrayToSort);
        System.out.println(SortUtils.isEquals(arrayClone, arrayToSort));
    }
}
