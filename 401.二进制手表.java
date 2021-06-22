
import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        //假设 小时：h，分钟：m
        // 则h的二进制和m的二进制1的个数加起来等于turnOn
        // 求h和m的所有可能
        List<String> result = new ArrayList<>();
        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                //如果h和m对应的二进制数1的个数加起来等于turnOn，把此时间加入result
                int sum = 0;
                String hStr = Integer.toBinaryString(h);
                String mStr = Integer.toBinaryString(m);
                String hmStr = hStr + mStr;
                for (int i = 0;i < hmStr.length(); i++) {
                    if (hmStr.charAt(i) == '1') {
                        sum += 1;
                    }
                }
                //sum = Integer.bitCount(h) + Integer.bitCount(m);
                if (sum == turnedOn) {
                    String time = h + ":" + (m < 10 ? "0" + m : m);
                    result.add(time);
                }

            }
        }

        return result;
    }
}
// @lc code=end
class Main{
    public static void main(String[] args) {
        // Create a new Solution instance
        Solution solution = new Solution();
        // Create a test case
        int testCase = 1;
        List<String> result = solution.readBinaryWatch(testCase);
        System.out.println(result);
    }
}

