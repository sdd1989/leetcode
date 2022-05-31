#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        #####方案1#####
        # for i in range(0, len(nums)):
        #     for j in range(i + 1, len(nums)):
        #         if nums[i] + nums[j] == target:
        #             return [i , j]

        #####方案2#####
        # dict = {}
        # for i, value in enumerate(nums):
        #     dict[value] = i
    
        # for i, value in enumerate(nums):
        #     remain = target - nums[i]
        #     if dict[nums[i]] == i:
        #         #因为同一个元素在答案里不能重复所以这里删掉
        #         dict.pop(nums[i])
        #     if remain in dict:
        #         return [i ,dict[remain]]

        #####方案3#####
        # 遍历过程中敲定第二个数，使用哈希表在第二个数的前面去找第一个数。
        # 具体的做法是，边遍历边存入哈希表，遍历过程中使用的下标 i 用作敲定第二个数，
        # 再从现有的哈希表中去找另外一个目标数
        # （由于下标 i 前面的数都被加入哈希表了，即在下标 i 前面去找第一个数）。

        sceen = {}
        for i, value in enumerate(nums):
            remaining = target - nums[i]
            if remaining in sceen:
                return [i, sceen[remaining]]
            else:
                sceen[value] = i

# @lc code=end            
