#
# @lc app=leetcode.cn id=8 lang=python3
#
# [8] 字符串转换整数 (atoi)
#

# @lc code=start
class Solution:
    def myAtoi(self, s: str) -> int:
        max = 2**31 - 1
        min = -2**31
        n = len(s)
        idx = 0
        #去除前导空格，如果去完前导空格后无字符了，返回 0
        while idx < n and s[idx].isspace():
            idx += 1
        if idx == n:
            return 0
        #检查第一个字符：可以为正负号/数字
        negtive = False
        if s[idx] == '-':
            negtive = True
            idx += 1
        elif s[idx] == '+':
            idx +=1
        elif not s[idx].isdigit():
            return 0
        ans = 0
        while idx < n and s[idx].isdigit():
            cur = ord(s[idx]) - ord('0')
            if ans > (max - cur) / 10:
                if negtive:
                    return min
                else:
                    return max
            ans = ans * 10 + cur
            idx += 1
        if negtive:
            return -ans
        else:
            return ans 
# @lc code=end

