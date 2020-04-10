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


//leetcode submit region begin(Prohibit modification and deletion)
class Solution0409 {
    /**
     * 1. 暴力法：
     * 先合并，再排序，复杂度 O（m+n）Log(m+n)
     * <p>
     * 2. 双指针法：
     * 倒序遍历，取出较大的数放到元素后面，依次进行，知道有一方元素迭代完毕，然后将小数组的剩下元素都放进去
     * 复杂度 O(N)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        while (len2 >= 0) {
            nums1[len--] = nums2[len2--];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
