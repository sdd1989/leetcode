/*
 * @lc app=leetcode.cn id=1838 lang=java
 *
 * [1838] 最高频元素的频数
 */

// @lc code=start
class Solution {
    // public int maxFrequency(int[] nums, int k) {
    //     int n = nums.length;
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
    //     List<Integer> list = new ArrayList<>(map.keySet());
    //     Collections.sort(list);
    //     int ans = 1;
    //     for (int i = 0; i < list.size(); i++) {
    //         int x = list.get(i), cnt = map.get(x);
    //         //针对每一个目标值x，对比最大频次
    //         if (i > 0) {
    //             int p = k;
    //             //只能从x的前面找才能做加法达到x
    //             for (int j = i - 1; j >= 0; j--) {
    //                 int y = list.get(j);
    //                 int diff = x - y;// 因为排序了，x一定大于y（这一点很重要）
    //                 if (p >= diff) {
    //                     //p次操作够几个数达到x（add次）
    //                     int add = p / diff;
    //                     //y出现的次数和add次中间取最小值，就是至多能使多少个数达到x
    //                     int min = Math.min(map.get(y), add);
    //                     p -= min * diff;
    //                     cnt += min;
    //                 } else {
    //                     break;
    //                 }
    //             }
    //         }
    //         ans = Math.max(ans, cnt);
    //     }
    //     return ans;
    // }
    //排序 + 前缀和 + 二分 + 滑动窗口
    int[] nums, sum;
    int n, k;
    public int maxFrequency(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        n = nums.length;
        Arrays.sort(nums);
        sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }
    boolean check(int len) {
        for (int l = 0; l + len - 1 < n; l++) {
            int r = l + len - 1;
            int cur = sum[r + 1] - sum[l];
            int t = nums[r] * len;
            if (t - cur <= k) return true;
        }
        return false;
    }
}
// @lc code=end

