#
# @lc app=leetcode.cn id=34 lang=python3
#
# [34] 在排序数组中查找元素的第一个和最后一个位置
#

# @lc code=start
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        return [self.left_round(nums, target), self.right_round(nums, target)]

    def left_round(self, nums, target):
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = l + r >> 1
            if nums[mid] < target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            elif nums[mid] == target:
                #收缩右边界
                r = mid - 1
        #判断越界
        if l >= len(nums)  or nums[l] != target:
            return -1
        return l

    def right_round(self, nums, target):
        l = 0
        r = len(nums) - 1
        while l <= r:
            mid = l + r >> 1
            if nums[mid] < target:
                l = mid + 1
            elif nums[mid] > target:
                r = mid - 1
            elif nums[mid] == target:
                #收缩左边界
                l = mid + 1
        if r < 0 or nums[r] != target:
            return -1
        return r

# @lc code=end

