import javax.xml.crypto.dsig.keyinfo.X509Data;

/*
 * @lc app=leetcode.cn id=1711 lang=java
 *
 * [1711] 大餐计数
 */

// @lc code=start
// class Solution {
//     public int countPairs(int[] deliciousness) {
//         long result = 0;
//         int n = deliciousness.length;
//         //时间复杂度太高需要优化
//         for (int i = 0; i < n; i ++) {
//             for (int j = i + 1; j < n; j ++) {
//                 int sum = deliciousness[i] + deliciousness[j];
//                 if (sum > 0 && (sum & (sum - 1)) == 0) {
//                     result ++;
//                 }
//             }
//         }
//         return (int ) (result % (Math.pow(10, 9) + 7));
//     }
// }
// class Solution {
//     int mod = (int)1e9+7;
//     int max = 1 << 22;
//     public int countPairs(int[] ds) {
//         Map<Integer, Integer> map = new HashMap<>();
//         for (int d : ds) map.put(d, map.getOrDefault(d, 0) + 1);
//         long ans = 0;
//         for (int x : map.keySet()) {
//             for (int i = 1; i < max; i <<= 1) {
//                 int t = i - x;
//                 if (map.containsKey(t)) {
//                     if (t == x) ans += (map.get(x) - 1) * 1L * map.get(x);
//                     else ans += map.get(x) * 1L * map.get(t);
//                 }
//             }
//         }
//         ans >>= 1;
//         return (int)(ans % mod);
//     }
// }
class Solution {
    int mod = (int)1e9+7;
    public int countPairs(int[] ds) {
        int n = ds.length;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = ds[i];
            for (int other : map.keySet()) {
                if (check(other + x)) ans += map.get(other);
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return (int)(ans % mod);
    }
    boolean check(long x) {
        // 方法一
        // long cur = 1;
        // while (cur < x) {
        //     cur = cur * 2;
        // }
        // return cur == x;
        
        // 方法二
        //return getVal(x) == x;
        return x > 0 && (x & (x - 1)) == 0;
    }
    long getVal(long x) {
        long n = x - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : n + 1;
    }
}
// @lc code=end
class Main1711 {
    public static void main(String[] args) {
        System.out.println(Math.pow(2, 20));
        System.out.println(Math.pow(10, 9) + 7);
    }
}
