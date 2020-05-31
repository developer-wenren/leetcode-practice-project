package com.one.learn.math.颠倒二进制位;

/**
 * 颠倒二进制位
 *
 * @author one
 * @date 2020/05/31
 */
public class Solution {
    /**
     * 位运算
     * >>> 无符号右移
     * & 1 截取末位
     * << 左移
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int size = 31; n != 0; n = n >>> 1, size--) {
            result += (n & 1) << size;
        }
        return result;
    }

}
