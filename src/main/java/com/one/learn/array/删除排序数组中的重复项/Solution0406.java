package com.one.learn.array.删除排序数组中的重复项;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 */
class Solution0406 {
    public int removeDuplicates3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int x = 0, y = 1;
        while (y < nums.length) {
            if (nums[y] != nums[x]) {
                nums[x + 1] = nums[y];
                x++;
            }
            y++;
        }
        return x + 1;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int x = 0;
        int y = 1;
        while (y < nums.length) {
            if (nums[y] != nums[x]) {
                nums[x + 1] = nums[y];
                x++;
            }
            y++;
        }
        return x + 1;
    }

    /**
     * 思路：
     * 双指针法，数组有序，不同元素的相邻的，
     * 从头，头+1 开始循环 头+1 如果相等，设置到头+1位置，然后头右移，始终头+1右移
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[p] != nums[j]) {
                if (j - p > 1) {
                    nums[p + 1] = nums[j];
                }
                p++;
            }
            j++;
        }
        return p + 1;
    }

}