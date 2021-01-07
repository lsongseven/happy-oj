//Given two integers a and b, return any string s such that: 
//
// 
// s has length a + b and contains exactly a 'a' letters, and exactly b 'b' lett
//ers, 
// The substring 'aaa' does not occur in s, and 
// The substring 'bbb' does not occur in s. 
// 
//
// 
// Example 1: 
//
// 
//Input: a = 1, b = 2
//Output: "abb"
//Explanation: "abb", "bab" and "bba" are all correct answers.
// 
//
// Example 2: 
//
// 
//Input: a = 4, b = 1
//Output: "aabaa"
// 
//
// 
// Constraints: 
//
// 
// 0 <= a, b <= 100 
// It is guaranteed such an s exists for the given a and b. 
// 
// Related Topics 贪心算法 
// 👍 52 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

public class StringWithoutAaaOrBbb {
    public static void main(String[] args) {
        Solution solution = new StringWithoutAaaOrBbb().new Solution();
        System.out.println(solution.strWithout3a3b(1, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String strWithout3a3b(int a, int b) {
            char charA = 'a', charB = 'b';
            if (a <= b) {
                int tmp = a;
                a = b;
                b = tmp;
                charA = 'b';
                charB = 'a';
            }
            int diff = a - b;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b; i++) {
                if (diff-- > 0) {
                    sb.append(charA);
                }
                sb.append(charA);
                sb.append(charB);
            }
            while (diff-- > 0) {
                sb.append(charA);
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}