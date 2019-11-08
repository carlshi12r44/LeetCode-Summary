public class longestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        // two pointers
        // [a,b,c,a,b,c,b,b]
        //  ^     ^
        //  l     r
        //
        // l moves right until r stops
        // while moving, we increase every characters' counts
        // if we see the repeating characters, we make the [l, r]
        // would be a substring without repeating characters
        // we could use a ans what would be the longest length

        if (s == null) return 0;

        // ASCII 0  ~ 255
        char[] sc = s.toCharArray();

        int[] count = new int[256];

        int ans = 0;

        for (int l = 0, r = 0; r < s.length(); r++) {
            count[sc[r]]++;
            while (count[sc[r]] > 1) {
                count[sc[l]]--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        int res = lengthOfLongestSubstring(s);

        System.out.print(res);

    }
}
