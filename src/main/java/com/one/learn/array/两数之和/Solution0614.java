package com.one.learn.array.两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
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
 * @date 2020/06/14
 */
public class Solution0614 {
    /**
     * 暴力求解：两层循环，记录符合target 的两数索引
     * 哈希表法: 构建一个hash，一层循环
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            int e = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == e) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if (x == 0 && y == 0) {
            return nums;
        }
        return new int[]{x, y};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                return new int[]{i, hash.get(target - nums[i])};
            }
            hash.put(nums[i], i);
        }
        return null;
    }
}
