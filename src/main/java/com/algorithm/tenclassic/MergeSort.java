package com.algorithm.tenclassic;

import java.util.Arrays;

/**
 * @author WhomHim
 * @description <p>
 *  归并排序，    算法步骤
 * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 *
 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 *
 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 *
 * 重复步骤 3 直到某一指针达到序列尾；
 *
 * 将另一序列剩下的所有元素直接复制到合并序列尾。
 *
 *
 * </p>
 * @date Create in 2021/10/9 16:03
 */
public class MergeSort {

    public static int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length >> 1);

        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    protected static int[] merge(int[] left, int[] right) {
        int[] result = new int[getLeftAndRightLength(left, right)];
        int i = 0;
        while (leftAndRightNotEmpty(left, right)) {
            if (leftLessThanRight(left[0], right[0])) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (leftIsNotEmpty(left)) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (rightIsNotEmpty(right)) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    private static boolean leftIsNotEmpty(int[] left) {
        return left.length > 0;
    }

    private static boolean rightIsNotEmpty(int[] right) {
        return right.length > 0;
    }

    private static boolean leftLessThanRight(int i1, int i2) {
        return i1 <= i2;
    }

    private static boolean leftAndRightNotEmpty(int[] left, int[] right) {
        return leftIsNotEmpty(left) && leftIsNotEmpty(right);
    }

    private static int getLeftAndRightLength(int[] left, int[] right) {
        return left.length + right.length;
    }

    public static void main(String[] args) throws Exception {
        int[] sort = sort(new int[]{28, 5, 2, 3});
        Arrays.stream(sort).forEach(System.out::println);
    }
}
