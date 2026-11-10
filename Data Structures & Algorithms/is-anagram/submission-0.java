class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Brute Force Approach
        // char[] char1 = s.toCharArray();
        // char[] char2 = t.toCharArray();
        // Arrays.sort(char1);
        // Arrays.sort(char2);
        // return Arrays.equals(char1, char2);

        // HashMap Approach
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch : t.toCharArray()) {
            if (map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) + 1);
            } else {
                map1.put(ch, 1);
            }
        }

        return map.equals(map1);
    }
}