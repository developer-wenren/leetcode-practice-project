package com.one.learn.array.移动零;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 双指针，快慢指针
 *
 * @author one
 * @date 2020/03/29
 */
public class 移动零 {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 0, 1});
        moveZeroes2(new int[]{0, 0, 1});
    }

    /**
     * 双指针
     * 记录0最初索引,将非0元素设置到前一位去，最后更新掉剩下该为0的索引。
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        // 非0元素要移动的目标位置
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
//        for (int k = j; k < nums.length; k++) {
//            nums[k] = 0;
//        }
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    /**
     * 非0元素交换方式
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }
}
