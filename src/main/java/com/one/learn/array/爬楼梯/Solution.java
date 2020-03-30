package com.one.learn.array.爬楼梯;

/**
 * 爬楼梯
 *
 * @author one
 * @date 2020/03/30
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(climbStairs2(34));
    }

    /**
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    /**
     * f(n)=f(n-1) + f(n-2) (n>=3)
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int i = climbStairs2(n - 1);
        int i1 = climbStairs2(n - 2);
        return i + i1;
    }
}