def mul(a: int, k: int):
        '''
        a*k
        倍乘模版
        '''
        ans = 0
        while k > 0:
            #二进制个位数是否是1
            if k & 1 == 1:
                ans += a
            k >>= 1 #右移一位
            a += a #乘以2
        return ans

if __name__ == '__main__':
    # print(9 % 10)
    # print(-9 % 10)
    # print(-9 % 10 - 10)
    # print(9 // 10)
    # print(9 / 10)
    # print(-9 // 10)
    # print((-9 - -9) // 10)
    # print(int("-9"))
    # print(int("-91283472332",base=10))
    print(mul(10, 3))