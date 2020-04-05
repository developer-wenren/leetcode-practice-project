package com.one.learn.array.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，
 * 并返回他们的数组下标。
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
public class Solution0405 {
    /**
     * 1. 暴露求解 n^2 :两层循环，比较 a[i]=a[j]
     * 2. 双指针 n :排序，两指针向内夹逼，一层循环找到相对的值,另一层循环找到值对应的index
     * 3. hash表 n : 循环放到map，key为value，value = index；判断 target-value 是否存在于map ,没有就存到map里，
     * 等待下一个值来判断，找到就返回
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>(64);
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        int[] targets = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                Integer j = hash.get(target - nums[i]);
                // 只能出现一个
                if (i != j) {
                    targets[0] = i;
                    targets[1] = j;
                    return targets;
                }
            }
        }
        return targets;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>(64);
        int[] targets = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                targets[0] = hash.get(target - nums[i]);
                targets[1] = i;
            } else {
                hash.put(nums[i], i);
            }
        }
        return targets;
    }

}
