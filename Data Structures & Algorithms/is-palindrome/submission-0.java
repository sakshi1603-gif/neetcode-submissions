class Solution {
    public boolean isPalindrome(String s) {
        int sp = 0;
        int ep = s.length() - 1;

        while (sp < ep) {

            while (sp < ep && !Character.isLetterOrDigit(s.charAt(sp))) {
                sp++;
            }

            while (sp < ep && !Character.isLetterOrDigit(s.charAt(ep))) {
                ep--;
            }

            if (Character.toLowerCase(s.charAt(sp)) !=
                Character.toLowerCase(s.charAt(ep))) {
                return false;
            }

            sp++;
            ep--;
        }

        return true;
    }
}