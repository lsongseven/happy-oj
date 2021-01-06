//Given a set of distinct positive integers nums, return the largest subset answ
//er such that every pair (answer[i], answer[j]) of elements in this subset satisf
//ies: 
//
// 
// answer[i] % answer[j] == 0, or 
// answer[j] % answer[i] == 0 
// 
//
// If there are multiple solutions, return any of them. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [1,2]
//Explanation: [1,3] is also accepted.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,4,8]
//Output: [1,2,4,8]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 109 
// All the integers in nums are unique. 
// 
// Related Topics 数学 动态规划 
// 👍 184 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        Solution solution = new LargestDivisibleSubset().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            /**
             * 1 2 4 8 16
             * 1 2 3 4
             */
            Arrays.sort(nums);
            return new ArrayList<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}