package com.one.learn.array.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author one
 * @date 2020/03/30
 */
class Solution3 {
    /**
     * 思路：
     * // 先排序
     * // 设置三个索引，最小值索引，左索引，右索引
     * // 遍历数组
     * // 当最小值大于0时跳出
     * // 当遍历相邻元素为重复元素时下一个
     * // 左索引，右索引循环叠加判断与最小值的合值
     * // 小于 0 时，左索引右移，且去重
     * // 大于 0 时，右索引左移，且去重
     * // 等于 0 时，保存，并且左索引右移，且去重,右索引左移，且去重
     * // 当左索引与右索引相碰时跳出
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) ;
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]) ;
                } else {
                    lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]) ;
                    while (left < right && nums[right] == nums[--right]) ;
                }
            }
        }
        return lists;
    }
}