# @before-stub-for-debug-begin
from python3problem1011 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=1011 lang=python3
#
# [1011] 在 D 天内送达包裹的能力
#

# @lc code=start
class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        l = 0
        r = 1
        for i,value in enumerate(weights):
            l = max(value, l)
            r += value
        while l <= r:
            mid = l + r >> 1
            mid_days = self.get_days(mid, weights)
            if mid_days > days:
                l = mid + 1
            elif mid_days < days:
                r = mid - 1
            elif mid_days == days:
                r = mid - 1
        return l
        # while l < r:
        #     # mid = l + r >> 1
        #     mid = l + (r - l) // 2
        #     mid_days = self.get_days(mid, weights)
        #     if mid_days <= days:
        #         r = mid
        #     else:
        #         l = mid + 1
        #     if mid_days > days:
        #         l = mid + 1
        #     elif mid_days <= days:
        #         r = mid
        # return l


    def get_days(self, weight: int, weights: List[int]) -> int:
        days = 0
        sum = 0
        length = len(weights)
        i = 0
        while i < len(weights):
            value = weights[i]
            sum += value
            if sum == weight:
                days += 1
                sum = 0
            elif sum > weight:
                days += 1
                i -= 1
                sum = 0
            elif sum < weight:
                if i == length - 1:
                    days += 1
            i += 1  
        return days
    # def get_days(self, weight: int, weights: List[int]) -> int:
    #     days = 0
    #     length = len(weights)
    #     i = 0
    #     while i < length:
    #         cap = weight
    #         while i < length:
    #             if cap < weights[i]:
    #                 break
    #             else:
    #                 cap -= weights[i]
    #             i += 1
    #         days += 1
    #     return days


# @lc code=end

