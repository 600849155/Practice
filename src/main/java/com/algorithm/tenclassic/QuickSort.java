package com.algorithm.tenclassic;

import java.util.Arrays;
import java.util.Random;

/**
 * @author WhomHim
 * @description <p>
 * 快排：
 * 1. 算法步骤
 * 从数列中挑出一个元素，称为 "基准"（pivot）;
 * <p>
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，
 * 该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * <p>
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 * </p>
 * @date Create in 2021/10/9 17:13
 */
public class QuickSort {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = rd.nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(num));
        quicksort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void quicksort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            // 一趟快排，并返回交换后基数的下标
            int index = partition(arr, left, right);
            // 递归排序基数左边的数组
            sort(arr, left, index - 1);
            // 递归排序基数右边的数组
            sort(arr, index + 1, right);
        }

    }

    public static int partition(int[] arr, int left, int right) {
        // p为基数，即待排序数组的第一个数
        int p = arr[left];
        int i = left;
        int j = right;
        while (i < j) {
            // 从右往左找第一个小于基数的数
            while (arr[j] >= p && i < j) {
                j--;
            }
            // 从左往右找第一个大于基数的数
            while (arr[i] <= p && i < j) {
                i++;
            }
            // 找到后交换两个数
            swap(arr, i, j);
        }
        // 使划分好的数分布在基数两侧
        swap(arr, left, i);
        return i;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
