package com.one.learn.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author one
 * @date 2020/06/21
 */
public class QuickSortSolution {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] array, int startIndex, int endIndex) {
        // 递归结束条件
        if (startIndex >= endIndex) {
            return;
        }
        // 获取基准元素位置
        int pivotIndex = partition(array, startIndex, endIndex);
        // 以基准元素为界，分成两部分递归排序
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        // 取第一个位置为基准元素（0）
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        // 控制 left 指针右移，right 指针左移，直至相碰结束
        while (left != right) {
            // right 比较，大于基准就左移，小了停止；
            while (left < right && array[right] > pivot) {
                right--;
            }
            // left 比较，小于基准就右移，大了停止；
            while (left < right && array[left] <= pivot) {
                left++;
            }
            // right 和 left 都停止后进行交换
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        //基准与 left和right相交位置进行交换
        int tmp = array[left];
        array[left] = array[startIndex];
        array[startIndex] = tmp;

        // 返回当前的基准位置
        return left;
    }

}
