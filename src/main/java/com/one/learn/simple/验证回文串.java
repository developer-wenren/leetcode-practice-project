
package com.one.learn.simple;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * https://leetcode-cn.com/problems/valid-palindrome/
 */
public class 验证回文串 {
    public static void main(String[] args) {
        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"
        ));
    }

    /**
     * 1. 筛查字母和数字
     * 2. 将字符串翻转，然后比较
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {

        int start = 0, last = s.length() - 1;
        while (start < last) {
            while (start < last && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < last && !Character.isLetterOrDigit(s.charAt(last))) {
                last--;
            }
            if (Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(last))) {
                return false;
            }
            start++;
            last--;
        }

        return true;
    }

    /**
     * 1. 筛查字母和数字
     * 2. 将字符串翻转，然后比较
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(chars[i])) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(chars[j])) {
                j--;
            }
            if (Character.toUpperCase(chars[i]) != Character.toUpperCase(chars[j])) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}