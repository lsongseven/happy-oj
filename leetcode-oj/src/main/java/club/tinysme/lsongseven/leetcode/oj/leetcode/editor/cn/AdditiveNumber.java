//Additive number is a string whose digits can form additive sequence. 
//
// A valid additive sequence should contain at least three numbers. Except for t
//he first two numbers, each subsequent number in the sequence must be the sum of 
//the preceding two. 
//
// Given a string containing only digits '0'-'9', write a function to determine 
//if it's an additive number. 
//
// Note: Numbers in the additive sequence cannot have leading zeros, so sequence
// 1, 2, 03 or 1, 02, 3 is invalid. 
//
// 
// Example 1: 
//
// 
//Input: "112358"
//Output: true
//Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
//             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// Example 2: 
//
// 
//Input: "199100199"
//Output: true
//Explanation: The additive sequence is: 1, 99, 100, 199. 
//             1 + 99 = 100, 99 + 100 = 199
// 
//
// 
// Constraints: 
//
// 
// num consists only of digits '0'-'9'. 
// 1 <= num.length <= 35 
// 
//
// Follow up: 
//How would you handle overflow for very large input integers? 
// Related Topics 回溯算法 
// 👍 133 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

public class AdditiveNumber {
    public static void main(String[] args) {
        Solution solution = new AdditiveNumber().new Solution();
        System.out.println(solution.isAdditiveNumber("19910011992"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAdditiveNumber(String num) {
            return dfs(num, 0, 0, 0, 0);
        }

        public boolean dfs(String num, int idx, long pre, long preSum, int k) {
            if (idx == num.length()) {
                return k > 2;
            }
            for (int right = idx + 1; right <= num.length(); ++right) {
                long current = getCurrent(num, idx, right);
                if (current < 0) {
                    continue;
                }
                if (k >= 2 && current != preSum) {
                    continue;
                }
                if (dfs(num, right, current, current + pre, k + 1)) {
                    return true;
                }
            }
            return false;
        }

        private long getCurrent(String num, int idx, int right) {
            if (idx >= num.length() || right > num.length() || (right - idx > 1 && num.charAt(idx) == '0')) {
                return -1;
            }
            return Long.parseLong(num.substring(idx, right));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}