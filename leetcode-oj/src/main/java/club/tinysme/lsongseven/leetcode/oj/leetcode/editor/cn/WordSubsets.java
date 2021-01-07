//We are given two arrays A and B of words. Each word is a string of lowercase l
//etters. 
//
// Now, say that word b is a subset of word a if every letter in b occurs in a, 
//including multiplicity. For example, "wrr" is a subset of "warrior", but is not 
//a subset of "world". 
//
// Now say a word a from A is universal if for every b in B, b is a subset of a.
// 
//
// Return a list of all universal words in A. You can return the words in any or
//der. 
//
// 
//
// 
// 
//
// 
// Example 1: 
//
// 
//Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
//Output: ["facebook","google","leetcode"]
// 
//
// 
// Example 2: 
//
// 
//Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
//Output: ["apple","google","leetcode"]
// 
//
// 
// Example 3: 
//
// 
//Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
//Output: ["facebook","google"]
// 
//
// 
// Example 4: 
//
// 
//Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
//Output: ["google","leetcode"]
// 
//
// 
// Example 5: 
//
// 
//Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","
//ceo"]
//Output: ["facebook","leetcode"]
// 
//
// 
//
// Note: 
//
// 
// 1 <= A.length, B.length <= 10000 
// 1 <= A[i].length, B[i].length <= 10 
// A[i] and B[i] consist only of lowercase letters. 
// All words in A[i] are unique: there isn't i != j with A[i] == A[j]. 
// 
// 
// 
// 
// 
// 
// Related Topics 字符串 
// 👍 40 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        Solution solution = new WordSubsets().new Solution();
        solution.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"e", "o"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordSubsets(String[] A, String[] B) {
            int[] bCount = new int[26];
            int bSize = 0;
            for (String str : B) {
                int[] tmpCnt = new int[26];
                for (char c : str.toCharArray()) {
                    tmpCnt[c - 'a']++;
                    if (tmpCnt[c - 'a'] > bCount[c - 'a']) {
                        bCount[c - 'a']++;
                        bSize++;
                    }
                }
            }

            List<String> ans = new ArrayList<>();
            for (String str : A) {
                int[] tmpCnt = new int[26];
                int size = 0;
                for (char c : str.toCharArray()) {
                    tmpCnt[c - 'a']++;
                    if (tmpCnt[c - 'a'] == bCount[c - 'a']) {
                        size += bCount[c - 'a'];
                    }
                }
                if (size == bSize) {
                    ans.add(str);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}