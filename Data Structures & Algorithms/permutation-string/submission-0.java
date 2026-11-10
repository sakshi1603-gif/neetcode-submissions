class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] windowFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        int start = 0;
        int end = s1.length() - 1;

        while (end < s2.length()) {

            if (Arrays.equals(freq1, windowFreq)) {
                return true;
            } else {
                windowFreq[s2.charAt(start) - 'a']--;

                start++;
                end++;

                if (end < s2.length()) {
                    windowFreq[s2.charAt(end) - 'a']++;
                }
            }
        }

        return false;
    }
}