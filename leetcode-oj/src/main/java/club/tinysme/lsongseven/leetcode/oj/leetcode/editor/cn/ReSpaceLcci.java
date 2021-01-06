//Oh, no! You have accidentally removed all spaces, punctuation, and capitalizat
//ion in a lengthy document. A sentence like "I reset the computer. It still didn'
//t boot!" became "iresetthecomputeritstilldidntboot''. You'll deal with the punct
//uation and capitalization later; right now you need to re-insert the spaces. Mos
//t of the words are in a dictionary but a few are not. Given a dictionary (a list
// of strings) and the document (a string), design an algorithm to unconcatenate t
//he document in a way that minimizes the number of unrecognized characters. Retur
//n the number of unrecognized characters. 
//
// Note: This problem is slightly different from the original one in the book. 
//
// 
//
// Example: 
//
// 
//Input: 
//dictionary = ["looked","just","like","her","brother"]
//sentence = "jesslookedjustliketimherbrother"
//Output:  7
//Explanation:  After unconcatenating, we got "jess looked just like tim her bro
//ther", which containing 7 unrecognized characters.
// 
//
// Note: 
//
// 
// 0 <= len(sentence) <= 1000 
// The total number of characters in dictionary is less than or equal to 150000.
// 
// There are only lowercase letters in dictionary and sentence. 
// 
// Related Topics 记忆化 字符串 
// 👍 159 👎 0


package club.tinysme.lsongseven.leetcode.oj.leetcode.editor.cn;

public class ReSpaceLcci {
    public static void main(String[] args) {
        Solution solution = new ReSpaceLcci().new Solution();
        System.out.println(solution.respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother"));
//        System.out.println(solution.respace(new String[]{"a", "ab", "c"}, "daabc"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int respace(String[] dictionary, String sentence) {
            TrieNode root = new TrieNode();
            root.next = new TrieNode[26];
            for (String word : dictionary) {
                TrieNode p = root;
                for (char c : word.toCharArray()) {
                    if (p.next[c - 'a'] == null) {
                        p.next[c - 'a'] = new TrieNode();
                        p.next[c - 'a'].next = new TrieNode[26];
                    }
                    p = p.next[c - 'a'];

                }
                p.isLeaf = true;
            }

            /**
             * dp[i]=min(dp[i],dp[j]) if j<i and [j,i) present
             * dp[i]=dp[i-1]+1
             */
            int[] dp = new int[sentence.length() + 1];
            for (int i = 1; i <= sentence.length(); i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = i - 1; j >= 0; j--) {
                    String s = sentence.substring(j, i);
                    boolean present = isPresent(root, s);
                    if (present) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    }
                }
                if (dp[i] == Integer.MAX_VALUE) {
                    dp[i] = dp[i - 1] + 1;
                }
            }
            return dp[sentence.length()];
        }

        public boolean isPresent(TrieNode root, String word) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                if (p.next[c - 'a'] == null) {
                    return false;
                }
                p = p.next[c - 'a'];
            }
            return p.isLeaf;
        }
        class TrieNode {
            public TrieNode[] next;
            public boolean isLeaf;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}