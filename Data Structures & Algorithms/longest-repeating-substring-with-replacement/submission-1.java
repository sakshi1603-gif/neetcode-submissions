class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        while (end < s.length()) {

            char ch = s.charAt(end);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            maxFrequency = Math.max(maxFrequency, map.get(ch));

            int windowLength = end - start + 1;

            if (windowLength - maxFrequency > k) {

                char leftChar = s.charAt(start);

                map.put(leftChar, map.get(leftChar) - 1);

                start++;

            } else {

                maxLength = Math.max(maxLength, windowLength);
            }

            end++;
        }

        return maxLength;
    }
}