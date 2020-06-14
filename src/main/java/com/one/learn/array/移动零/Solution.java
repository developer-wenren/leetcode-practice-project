package com.one.learn.array.移动零;

class Solution {
    public static void main(String[] args) {
        int[] ints = {1, 1, 0, 3, 12};
        new Solution().moveZeroes(ints);
    }

    /**
     * loop 找到零的位置，再 loop 从尾开始遍，将 0 元素位置放到最后非 0 元素交换
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                if (i != k) {
                    nums[i] = 0;
                }
                k++;
            }
        }
    }
}