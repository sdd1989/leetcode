#一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
# def calc(h: int,  n: int):
#     sum = 0
#     #下落
#     bound = 0
#     #反弹
#     rebound = 0
#     for i in range(1, n + 1):
#         bound += h / 2**(i-1)
#         rebound += h / 2**i
#     sum = bound + rebound - h / 2**10
#     return (sum, h / 2**10)
# if __name__ == '__main__':
#     print(calc(100, 10))
tour = [] 
height = [] 
# 起始高度 
hei = 100.0 
# 次数 
tim = 10 
for i in range(1, tim + 1): 
# 从第二次开始，落地时的距离应该是反弹高度乘以2（弹到最高点再落下） 
    if i == 1: 
        tour.append(hei) 
    else: 
        tour.append(2*hei) 
        hei /= 2
        height.append(hei) 
print('总高度：tour = {0}'.format(sum(tour))) 
print('第10次反弹高度：height = {0}'.format(height[-1]))



