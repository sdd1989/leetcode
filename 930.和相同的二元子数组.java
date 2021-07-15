/*
 * @lc app=leetcode.cn id=930 lang=java
 *
 * [930] 和相同的二元子数组
 */

// @lc code=start
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // int ans = 0;
        // int n = nums.length;
        // //朴素法两层for循环，然后再优化
        // for (int i = 0; i < n; i ++) {
        //     int sum = 0;
        //     for (int j = i; j < n; j ++) {
        //         sum += nums[j];
        //         if (sum == goal) {
        //             ans ++;
        //             //后面如果是0的话结果加1
        //             while (j < n - 1 && nums[j + 1] == 0) {
        //                 ans ++;
        //                 j++;
        //             }
        //             break;
        //         }
        //     }
        // }
        // return ans;
        //todo 此方法没有调通
        // int ans = 0;
        // int n = nums.length;
        // //双指针
        // int start = 0;
        // int end = 0;
        // int sum = 0;
        // while (start < n || end < n) {
        //     sum += nums[end];
        //     if (sum < goal) {
        //         end ++;
        //     }
        //     if (sum == goal) {
        //         ans ++;
        //     }
        //     //start 往后走
        //     while (sum > goal && start < n) {
        //         sum -= nums[start];
        //         if (sum < goal) break;
        //         if (sum == goal) ans ++;
        //         start ++;
        //     }
        //     //end 往后走
        //     while (sum > goal && end < n) {
        //         sum += nums[end];
        //         if (sum > goal) break;
        //         if (sum == goal) ans ++;
        //         end ++;
        //     }
        // }
        // return ans;
        int n = nums.length;
        int ans = 0;
        for (int r = 0, l1 = 0, l2 = 0, s1 = 0, s2 = 0; r < n; r++) {
            s1 += nums[r];
            s2 += nums[r];
            while (l1 <= r && s1 > goal) s1 -= nums[l1++];
            while (l2 <= r && s2 >= goal) s2 -= nums[l2++];
            ans += l2 - l1;
        }
        return ans;
    }
}
// @lc code=end

