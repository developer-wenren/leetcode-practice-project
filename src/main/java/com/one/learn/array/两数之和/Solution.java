package com.one.learn.array.两数之和;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author one
 * @date 2020/03/30
 */
public class Solution {
    //暴力求解，两层循环
    // 复杂度 O(N^2)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

    // 哈希表法 hash(targert-value) = otherValue
    // 空间换时间
    // O(N)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /**
     * 双指针法，先找到对应的值，再去匹配对应的索引
     * 复制，排序 Nlog(N)
     * 遍历 N 找值
     * 遍历找索引 N
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        if (nums == null)
            return null;
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        int a = 0, b = 0;
        int start = 0, end = nums2.length - 1;
        //find two nums
        while (start < end) {
            int sum = nums2[start] + nums2[end];
            if (sum < target)
                start++;
            else if (sum > target)
                end--;
            else {
                a = nums2[start];
                b = nums2[end];
                break;
            }
        }
        //find the index of two numbers
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                res[0] = i;
                break;
            }
        }
        if (a != b) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == b) {
                    res[1] = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == b && i != res[0]) {
                    res[1] = i;
                    break;
                }
            }
        }

        return res;
    }

}
