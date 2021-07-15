/*
 * @lc app=leetcode.cn id=1818 lang=java
 *
 * [1818] 绝对差值和
 */

// @lc code=start
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int)1e9+7;
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        long sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            if (a == b) continue;
            int x = Math.abs(a - b);
            sum += x;
            int l = 0, r = n - 1;
            //二分找nums1中最接近b的数
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (sorted[mid] <= b) l = mid;
                else r = mid - 1;
            }
            int nd = Math.abs(sorted[r] - b);
            //sorted[r] 或 sorted[r + 1]是最接近b的数，比较二者取绝对值最小的，那么这个数nb就是当前位置i绝对值差和最小的值
            if (r + 1 < n) nd = Math.min(nd, Math.abs(sorted[r + 1] - b));
            //x - nb 就是假设替换为nums[i]替换为nb时，绝对值减少的值，那么挨个比较nb，取最大的值，就是结果
            if (nd < x) max = Math.max(max, x - nd);
        }
        return (int)((sum - max) % mod);
    }
}
// @lc code=end

