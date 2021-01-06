//Return the lexicographically smallest subsequence of s that contains all the d
//istinct characters of s exactly once. 
//
// Note: This question is the same as 316: https://leetcode.com/problems/remove-
//duplicate-letters/ 
//
// 
// Example 1: 
//
// 
//Input: s = "bcabc"
//Output: "abc"
// 
//
// Example 2: 
//
// 
//Input: s = "cbacdcbc"
//Output: "acdb"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 78 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

public class SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new SmallestSubsequenceOfDistinctCharacters().new Solution();
        System.out.println(solution.smallestSubsequence("cbacdcbcwbenw"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestSubsequence(String s) {
            char[] stack = new char[26];
            boolean[] used = new boolean[26];
            int[] cnt = new int[26];
            char[] sc = s.toCharArray();
            int top = 0;
            for (int i = 0; i < sc.length; ++i) {
                cnt[sc[i] - 'a']++;
            }
            for (int i = 0; i < sc.length; ++i) {
                if (!used[sc[i]-'a']) {
                    while (top > 0 && sc[i] < stack[top - 1] && cnt[stack[top - 1] - 'a'] > 0) {
                        used[stack[top-1]-'a'] = false;
                        top -= 1;
                    }
                    stack[top++] = sc[i];
                    used[sc[i] - 'a'] = true;
                }
                cnt[sc[i]-'a']--;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < top; ++i) {
                sb.append(stack[i]);
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}