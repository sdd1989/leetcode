# @before-stub-for-debug-begin
from python3problem1051 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=1051 lang=python3
#
# [1051] 高度检查器
#

# @lc code=start
class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        ans = 0
        expected = heights.copy()
        expected.sort(reverse = False)
        for i in range(0, len(heights)):
            if heights[i] != expected[i]:
                ans += 1
        return ans

# @lc code=end

