package com.one.learn.array.合并两个有序数组;//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0408 {
    /**
     * 思路：
     * 两个数组有序，将小数组的每一元素在大数组里每一位比较，若有出现小了，就放置于前一位，然后大数组后移一位
     * 记录当前大数组遇到的最大的位置
     * <p>
     * 解法1：先合并，在排序，时间复杂度 O(n+m)log(n+m)
     * 解法2：双指针，时间复杂度 O（n+m）
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 解法2：双指针，时间复杂度 O（n+m）
     * 从后向前设置，限定新数组最大索引位置 (m+n-1)
     * 比较两个数组的值，大的设置，并且小标左移
     * 直到有数组的下标移至为0
     * 将num2 的剩下数据复制到num1 中的剩下位置。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1, len2 = n - 1, len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
