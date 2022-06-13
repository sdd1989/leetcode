# @before-stub-for-debug-begin
from operator import le
from python3problem33 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=33 lang=python3
#
# [33] 搜索旋转排序数组
#

# @lc code=start
class Solution:
    # def search(self, nums: List[int], target: int) -> int:
    #     #朴素解法，找到旋转点，两边分别二分
    #     lenth = len(nums)
    #     point = -1
    #     for i, value in enumerate(nums):
    #         if i < lenth - 1 and value > nums[i + 1]:
    #             point = i
    #     if point >= 0:       
    #         ans = self.bi_search(nums, 0, point, target)
    #         if ans != -1:
    #             return ans
    #         else:
    #             return self.bi_search(nums, point + 1, lenth - 1, target)

    #     return self.bi_search(nums, 0, lenth - 1, target)

    # def bi_search(self, nums: List[int], start: int, end: int, target: int) -> int:
    #     l = start
    #     r = end
    #     while l <= r:
    #         mid = (l + r) >> 1
    #         if nums[mid] == target:
    #             return mid
    #         elif nums[mid] > target:
    #             r = mid - 1
    #         else:
    #             l = mid + 1
    #     return -1
    def search(self, nums: List[int], target: int) -> int:
        length = len(nums)
        if length == 0:
            return -1
        if length == 1:
            return 0 if nums[0] == target else -1
        l = 0
        r = length - 1
        while l < r:
            mid = (l + r + 1) >> 1
            if nums[mid] >= nums[0]:
                l = mid
            else:
                r = mid - 1
        if target >= nums[0]:
            l = 0
        else:
            l = l + 1
            r = length - 1
        while l < r:
            mid = (l + r) >> 1
            if  nums[mid] >= target:
                r = mid
            else:
                l = mid + 1
        return r if nums[r] == target else -1

# @lc code=end

