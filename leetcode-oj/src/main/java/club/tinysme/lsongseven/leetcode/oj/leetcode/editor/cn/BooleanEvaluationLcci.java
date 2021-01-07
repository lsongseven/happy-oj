//Given a boolean expression consisting of the symbols 0 (false), 1 (true), & (A
//ND), | (OR), and ^ (XOR), and a desired boolean result value result, implement a
// function to count the number of ways of parenthesizing the expression such that
// it evaluates to result. 
//
// Example 1: 
//
// 
//Input: s = "1^0|0|1", result = 0
//
//Output: 2
//Explanation: Two possible parenthesizing ways are:
//1^(0|(0|1))
//1^((0|0)|1)
// 
//
// Example 2: 
//
// 
//Input: s = "0&0&0&1^1|0", result = 1
//
//Output: 10 
//
// Note: 
//
// 
// There are no more than 19 operators in s. 
// 
// Related Topics 栈 字符串 
// 👍 29 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

public class BooleanEvaluationLcci {
    public static void main(String[] args) {
        Solution solution = new BooleanEvaluationLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countEval(String s, int result) {
            if (s == null) {
                return 0;
            }
            if (s.length() == 1) {
                return s.charAt(0) - '0' == result ? 1 : 0;
            }
            // 0&0&0&1^1|0
            // i<k<j, k is index of &
            // &: (0,0),(0,1),(1,0) for 0
            // dp[i][j][0]+=dp[i][k-1][0]*dp[k+1][j][0]+dp[i][k-1][0]*dp[k+1][j][1]+dp[i][k-1][1]*dp[k+1]*dp[j][0];
            // &: (1,1) for 1
            // dp[i][j][1]+=dp[i][k-1][1]*dp[k+1][j][1];
            int[][][] dp = new int[s.length()][s.length()][2];
            for (int i = 0; i < s.length(); i += 2) {
                dp[i][i][0] = s.charAt(i) - '0' == 0 ? 1 : 0;
                dp[i][i][1] = s.charAt(i) - '1' == 0 ? 1 : 0;
            }
            for (int len = 2; len < s.length(); len += 2) {
                for (int i = 0; i < s.length(); i++) {
                    int j = i + len;
                    for (int k = i + 1; k < j; k += 2) {

                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}