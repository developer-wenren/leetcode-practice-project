package com.one.learn.math.数字反转;

/**
 * @author one
 * @date 2020/05/31
 */
public class Solution {
    /**
     * 取余, 余数x10 累加，判断是否溢出
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int i = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && i > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && i < -8)) {
                return 0;
            }
            result = (result * 10 + i);
            x = x / 10;
        }
        return result;
    }
}
