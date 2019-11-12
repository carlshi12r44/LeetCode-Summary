public class WildCardMatching {
    public boolean isMatch(String s, String p) {
        // base case when both Strings are empty, return true
        if (s.isEmpty() && p.isEmpty()) {
            return true;
        }

        // if only p is empty return false
        if (p.isEmpty()) return false;

        // if s is empty check if the first character in p is star or not
        // if it is star, then we recurse to check if the s[] is matched with p[1,:]
        // else return false
        if (s.isEmpty()) {
            if (p.charAt(0) == '*') {
                return isMatch(s, p.substring(1));
            } else {
                return false;
            }
        }


        // then we check if the first characters of both Strings are equal OR the first character of p is '?'
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else {
            // if the first character in p instead is '*'
            // there are two situations: 1. return isMatch(s[1:], p) OR isMatch(s, p[1:])
            // else return false
            if (p.charAt(0) == '*') {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "cb";
        String p = "*";
        WildCardMatching test = new WildCardMatching();
        System.out.print(test.isMatch(s, p));
    }
}
