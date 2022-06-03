#
# @lc app=leetcode.cn id=829 lang=python3
#
# [829] 连续整数求和
#

# @lc code=start
import math
class Solution:
    def consecutiveNumbersSum(self, n: int) -> int:
        # 参考：https://leetcode.cn/problems/consecutive-numbers-sum/solution/by-ac_oier-220q/
        n *= 2
        ans = 0
        for k in range(1, math.ceil(math.sqrt(n))) :
            if n % k != 0:
                continue
            if (n / k + 1 - k) % 2 == 0:
                ans = ans + 1
        return ans

# @lc code=end
