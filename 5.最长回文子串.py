#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        max = ''
        for i in range(0, len(s)):
            #奇数
            temp = self.get_string(s, i - 1 , i + 1)
            if len(temp) > len(max):
                max = temp
            #偶数
            temp = self.get_string(s, i - 1 , i)
            if len(temp) > len(max):
                max = temp
        return max
    
    def get_string(self, s: str, l: int, r: int) -> str:
            while l >= 0 and r < len(s) and s[l] == s[r]:
                 l = l - 1
                 r = r + 1
            return s[l +1 : r]
# @lc code=end