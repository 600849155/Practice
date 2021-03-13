package com.algorithm;

import java.util.HashMap;

/**
 * @author WhomHim
 * @description
 * @date Create in 2021/3/6 0:22
 */
public class LeetCode3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        if (s.equals(" ")) {
            return 1;
        }
        final char[] array = s.toCharArray();
        if (array.length == 1) {
            return 1;
        }
        final HashMap<Object, Object> hashMap = new HashMap<>(16);
        int returnCount = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            //如果hashmap 有则终止加 1，计量清0, 比较 count，returnCount 大小
            if (hashMap.get(array[i]) != null) {
                if (count > returnCount) {
                    returnCount = count;
                    count = 1;
                    hashMap.clear();
                    hashMap.put(array[i], i);
                }
            } else {
                hashMap.put(array[i], i);
                count++;
            }
        }
        return returnCount;
    }

    public static void main(String[] args) {
        final int a = lengthOfLongestSubstring("au");
        System.out.println(a);
    }
}
