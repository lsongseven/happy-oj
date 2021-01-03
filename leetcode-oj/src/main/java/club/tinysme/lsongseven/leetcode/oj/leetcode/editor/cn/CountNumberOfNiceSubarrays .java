//Given an array of integers nums and an integer k. A continuous subarray is cal
//led nice if there are k odd numbers on it. 
//
// Return the number of nice sub-arrays. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2,1,1], k = 3
//Output: 2
//Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1
//].
// 
//
// Example 2: 
//
// 
//Input: nums = [2,4,6], k = 1
//Output: 0
//Explanation: There is no odd numbers in the array.
// 
//
// Example 3: 
//
// 
//Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//Output: 16
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// 
// Related Topics 双指针 
// 👍 147 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        Solution solution = new CountNumberOfNiceSubarrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int p1 = 0, p2 = 0, oddCount = 0, ans = 0;
            while (p2 < nums.length) {
                if (nums[p2] % 2 == 1) {
                    oddCount++;
                    if (oddCount == k) {
                        ans++;
                    }
                    if ((oddCount == k && nums[p1] % 2 == 0) || oddCount > k) {
                        p1++;
                        oddCount -= nums[p1 - 1] % 2;
                        oddCount -= nums[p2] % 2;
                        continue;
                    }
                }
                p2++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}