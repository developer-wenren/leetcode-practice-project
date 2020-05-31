package com.one.learn.math.数字反转;

/**
 * 数字反转
 *
 * @author one
 * @date 2020/05/24
 */
public class Solution7 {
    /**
     * 1. 思路分析
     * - 对反转后的数字进行判断是否溢出
     * 2. 说出可能的解法
     * - 暴力法，切割为数组，倒序遍历组成新数
     * - 首尾开始交换位置，直至相遇，组成新数
     * 3. 编码
     * 4. 测试
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int z = 0;
        while (x != 0) {
            //每次取末尾数字
            int y = x % 10;
            if (z > Integer.MAX_VALUE / 10 || (z == Integer.MAX_VALUE / 10 && y > 7)) {
                return 0;
            }
            if (z < Integer.MIN_VALUE / 10 || (z == Integer.MIN_VALUE / 10 && y < -8)) {
                return 0;
            }
            // 翻转过程的中间数字
            z = z * 10 + y;
            // 获取剩下的数
            x /= 10;
        }
        return z;
    }

    public int reverse2(int x) {
        boolean b = x > 0;
        char[] chars = (Math.abs(x) + "").toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            chars[i] = chars[j];
            chars[j--] = chars[i++];
        }
        String s = String.valueOf(chars);
        try {
            int i1 = Integer.parseInt(s);
            return i1 * (b ? 1 : -1);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int reverse = new Solution7().reverse(123);
    }
}
