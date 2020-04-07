package com.one.learn.array.加一;
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//输出: [1,2,4]
//解释: 输入数组表示数字 123。
// 
//
// 示例 2: 
//
// 输入: [4,3,2,1]
//输出: [4,3,2,2]
//解释: 输入数组表示数字 4321。
// 
// Related Topics 数组

//leetcode submit region begin(Prohibit modification and deletion)
class Solution0407 {
    /**
     * 特殊情况：数组只有一个元素0，返回1
     * 暴力法遍历整个数组，n*10^(i-1) 累计再加1
     * <p>
     * 反序遍历，给值+1 大于10就是，改为设置为0，下一个循环继续+1
     * <p>
     * 如果+1后数组需要加一位,复制出一个新的数组
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        if (digits.length == 1 && digits[0] == 0) {
            return new int[]{1};
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (digit + 1 < 10) {
                digits[i] = digit + 1;
                break;
            }
            if (i != 0) {
                digits[i] = 0;
            } else {
                int[] dest = new int[digits.length + 1];
                System.arraycopy(dest, 1, digits, 0, digits.length);
                dest[0] = 1;
                return dest;
            }

        }
        return digits;
    }


    /**
     * 第二种解法：
     * 倒叙遍历，值+1，对10取余，如果是为0，进入下一个循环；如果全是0，则新建一个数组，长度为原长度+1，首位为1
     * 对于全是9的数组，新建数组，首位为1即可
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne3(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
