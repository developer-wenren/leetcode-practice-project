package com.one.learn.array.长度最小的子数组;

/**
 * @author one
 */
public class Solution {
    /**
     * 暴力求解
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= s) {
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                num += nums[j];
                if (num >= s) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


    /**
     * 双指针法
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        if (nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end++];
            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}