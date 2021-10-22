package com.algorithm.tenclassic;

import java.util.Arrays;
import java.util.Random;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/10/11 10:35
 */
public class SimpleQuickSort {

    public static void main(String[] args) {
        Random rd = new Random();
        int[] num = new int[10];
        for (int i = 0; i < num.length; i++) {
            num[i] = rd.nextInt(100) + 1;
        }
        System.out.println(Arrays.toString(num));
        quicksort(num, 0, num.length - 1);
        System.out.println(Arrays.toString(num));
    }

    public static void quicksort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int mid = arr[(left + right) / 2];
        System.out.println("mid:" + mid);
        while (i < j) {
            while (arr[i] < mid) {
                i++;
            }
            while (arr[j] > mid) {
                j--;
            }
            if (i <= j) {
                System.out.println("arr[i]:" + arr[i]);
                System.out.println("arr[j]:" + arr[j]);
                System.out.println(Arrays.toString(arr));
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quicksort(arr, left, j);
        }
        if (i < right) {
            quicksort(arr, i, right);
        }
    }
}
