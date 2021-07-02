import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1833 lang=java
 *
 * [1833] 雪糕的最大数量
 */

// @lc code=start
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int result = 0;
        int n = costs.length;
        //从小到大排序，然后从前往后决策
        Arrays.sort(costs);
        for (int i = 0; i < n; i++) {
            if (coins >= costs[i]) {
                result++;
                coins-=costs[i];
            }
        }
        return result;
    }
}
// @lc code=end

