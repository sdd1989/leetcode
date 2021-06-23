/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        // String xStr = Integer.toString(x);
        // int len = xStr.length();
        // char[] chars = new char[len];
        // char first = xStr.charAt(0);
        // int j = 0;
        // if (first == '-') {
        //     chars[0] = first;
        //     for (int i = len - 1 ; i > 0; i--) {
        //         chars[++j] = xStr.charAt(i);
        //     }
        // } else {
        //     for (int i = len - 1 ; i >= 0; i--) {
        //         chars[j++] = xStr.charAt(i);
        //     }
        // }
        // //判断越界
        // try {
        //     return Integer.parseInt(new String(chars));
        // } catch (NumberFormatException e) {
        //     return 0;
        // }
        long r = 0;
        while (x != 0) {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        if (r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE) {
            return (int)r;
        } else {
            return 0;
        }
    }
}
// @lc code=end

