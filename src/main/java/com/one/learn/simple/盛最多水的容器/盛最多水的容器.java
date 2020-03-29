package com.one.learn.simple.盛最多水的容器;

/**
 * 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author one
 * @date 2020/03/29
 */
public class 盛最多水的容器 {
    /**
     * 暴力解法
     * 两层循环，先获得较短的高,记录每一次对应索引位置差所得面积并保存，用于后续比较。
     *
     * @param height
     * @return
     */
    public int maxAreaViolence(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int maxH = Math.min(height[i], height[j]);
                max = Math.max(max, maxH * (j - i));
            }
        }
        return max;
    }

    /**
     * 双指针
     * 一个从头开始，一个从尾巴开始，获得较短的高，计算他们对应的面积，保留下来，等待笔记
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        for (; i < j; ) {
            int value = 0;
            if (height[i] > height[j]) {
                value = height[j] * (j - i);
                j--;
            } else {
                value = height[i] * (j - i);
                i++;
            }
            max = Math.max(max, value);
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        for (; i < j; ) {
            int value = height[i] > height[j] ? (j - i) * height[j--] : (j - i) * height[i++];
            max = Math.max(max, value);
        }
        return max;
    }

    public int maxArea3(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area = (height[i] < height[j]) ? (j - i) * height[i++] : (j - i) * height[j--];
            max = Math.max(area, max);
        }
        return max;
    }

}
