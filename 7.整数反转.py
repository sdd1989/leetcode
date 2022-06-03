#
# @lc app=leetcode.cn id=7 lang=python3
#
# [7] 整数反转
#

# @lc code=start
class Solution:
    def reverse(self, x: int) -> int:
        # 参考：https://leetcode.cn/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
        max = 2 ** 31 - 1
        min = -2 ** 31
        res = 0
        while x != 0 :
            num = x % 10
            if (res > max / 10) or (res == max / 10 and num > max % 10):
                return 0
            if (res < min / 10) or (res == min / 10 and num < min % 10):
                return 0
            # Python3 的取模运算在 x 为负数时也会返回 [0, 9) 以内的结果，因此这里需要进行特殊判断
            if x < 0 and num > 0:
                num -= 10
            # 同理，Python3 的整数除法在 x 为负数时会向下（更小的负数）取整，因此不能写成 x //= 10
            x = (x - num) // 10
            res = res * 10 + num
        return res

# @lc code=end

