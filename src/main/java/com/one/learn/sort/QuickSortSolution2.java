package com.one.learn.sort;

import java.util.Arrays;

/**
 * @author one
 * @date 2020/06/21
 */
public class QuickSortSolution2 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pos = partition(arr, start, end);
        quickSort(arr, start, pos - 1);
        quickSort(arr, pos + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        // 获取基准元素
        int value = arr[start];
        int left = start;
        int right = end;
        while (left != right) {
            // right 比较，左移
            while (left < right && arr[right] > value) {
                right--;
            }
            // left 比较，右移
            while (left < right && arr[left] <= value) {
                left++;
            }
            //left 与 right 元素交换
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
        int tmp = arr[left];
        arr[left] = value;
        arr[start] = tmp;
        return left;
    }

}
