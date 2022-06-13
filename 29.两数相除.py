# @before-stub-for-debug-begin
from python3problem29 import *
from typing import *
# @before-stub-for-debug-end

#
# @lc app=leetcode.cn id=29 lang=python3
#
# [29] 两数相除
#

# @lc code=start
from audioop import mul


class Solution:
    def divide(self, x: int, y: int) -> int:
        max = 2**31 - 1
        min = -2**31
        negtive = False
        if (x > 0 and y < 0) or (x < 0 and y > 0):
            negtive = True
        if x < 0:
            x = -x
        if y < 0:
            y = -y
        l = 0
        r = x
        ans = 0
        while l < r:
            mid = (l + r + 1) >> 1
            if self.mul(mid, y) <= x:
                l = mid
            else:
                r = mid - 1
        ans = l
        #这个模版不行？
        # while l < r:
        #     mid = (l + r) >> 1
        #     if self.mul(mid, y) >= x:
        #         r = mid
        #     else:
        #         l = mid + 1
        # ans = r
        ans = -ans if negtive else ans
        if ans > max or ans < min:
            return max
        return ans

    def mul(self, a: int, k: int):
        '''
        a*k
        倍乘模版，可以按k个a来理解，将k表示为2进制，比如是11001，那么k*a = 2**4 * a + 2**3 * a + 2**0 * a
        '''
        ans = 0
        while k > 0:
            #二进制个位数是否是1，如果为1说明要累加a
            if k & 1 == 1:
                ans += a
            k >>= 1 #右移一位
            a += a #乘以2
        return ans

# @lc code=end

