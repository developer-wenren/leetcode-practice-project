package com.one.learn.array.移动零;

/**
 * @author one
 * @date 2020/06/07
 */
public class Solution2 {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // i!=k, 当前 [k] 为 0
                nums[k] = nums[i];
                // i!=k, 当前 [k] 为 i
                if (i != k) {
                    // i!=k, 当前 [i] 为 0
                    nums[i] = 0;
                }
                k++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[k];
                nums[k] = nums[i];
                nums[i] = tmp;
                k++;
            }

        }
    }
}
