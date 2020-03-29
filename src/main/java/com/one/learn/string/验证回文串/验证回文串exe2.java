
package com.one.learn.string.验证回文串;

import com.sun.tools.javac.util.Assert;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class 验证回文串exe2 {
    public static void main(String[] args) {
        Assert.check(isPalindrome("A man, a plan, a canal: Panama"));
        Assert.check(isPalindrome("A man, a pla a canal: Panama") == false);

        Assert.check(isPalindrome2("A man, a plan, a canal: Panama"));
        Assert.check(isPalindrome2("A man, a pla a canal: Panama") == false);
    }


    /**
     * 解法1
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    /**
     * 解法2
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome2(String s) {
        // 过滤非数字和字符
        String filteredS = filterSpecialChar(s);
        // 翻转并比较
        String reservedS = reserveString(filteredS);
        return filteredS.toUpperCase().equals(reservedS.toUpperCase());
    }

    /**
     * // 过滤非数字和字符
     *
     * @param s
     * @return
     */
    private static String filterSpecialChar(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "");
    }

    /**
     * // 翻转并比较
     *
     * @param s
     * @return
     */
    private static String reserveString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}