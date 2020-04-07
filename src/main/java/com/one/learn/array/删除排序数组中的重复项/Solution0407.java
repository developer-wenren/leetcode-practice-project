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
class Solution0407 {
    /**
     * 思路：
     * 特殊条件：
     * - 数组不为null和空数组
     * - 首个位置的值不会变化
     * 双指针，从头开始，一个记录非重复元素索引末位置，另一个记录判断是否重复的元素位置
     * 有序，小大相邻
     * 时间复杂度：O（N)
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int x = 0;
        int y = 1;
        while (y < nums.length) {
            if (nums[x] != nums[y]) {
                nums[x + 1] = nums[y];
                x++;
            }
            y++;
        }
        return x + 1;
    }
}