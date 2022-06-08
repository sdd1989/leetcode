#
# @lc app=leetcode.cn id=875 lang=python3
#
# [875] 爱吃香蕉的珂珂
#

# @lc code=start
import math
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l = 1
        r = 10**9
        while l < r:
            #mid = int((l + r) / 2)
            mid = int(l + r >> 1)
            if self.cost(piles, mid) > h:
                #右边区间
                l = mid + 1
            else:
                #左边区间
                r = mid
                
        return r

    def cost(self, piles: List[int],  mid: int):
        ans = 0
        for i, v in enumerate(piles):
            ans += math.ceil(v / mid)
        return ans
# @lc code=end



