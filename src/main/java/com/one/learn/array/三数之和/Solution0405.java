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
class Solution0405 {
    /**
     * 1. 暴露求解 N^3：3层循环找到 -a[i] = a[j] +a[k]
     * 2. hash N^2：一层循环形成 map（-a[i],i）,两次循环找 key为(a[j]+a[k]）的键值对
     * 2. 双指针夹逼 N^2 ：排序，遍历最小值，基于最小值位置minIndex设置left和right索引,最小值大于0返回，相邻索引值相等会重复跳过，
     * 遍历去获得三个索引值的和，小于0则，left右移到不重复的位置；大于0则right左移到不重复的位置，
     * 等于0时，去除，然后左索引右移到不重复的位置，右索引左移到不重复的复制
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int minIndex = 0; minIndex < nums.length; minIndex++) {
            if (nums[minIndex] > 0) {
                break;
            }
            if (minIndex > 0 && nums[minIndex] == nums[minIndex - 1]) {
                continue;
            }
            int left = minIndex + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[minIndex] + nums[left] + nums[right];
                if (sum > 0) {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else if (sum < 0) {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    lists.add(Arrays.asList(nums[minIndex], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return lists;
    }
}