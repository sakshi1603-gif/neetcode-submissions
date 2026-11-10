
class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;
        int count = 0;

        int minlen = Integer.MAX_VALUE;
        int startidx = 0;

        while (r < s.length()) {

            char ch = s.charAt(r);

            if (map.containsKey(ch)) {

                if (map.get(ch) > 0) {
                    count++;
                }

                map.put(ch, map.get(ch) - 1);
            }

            while (count == t.length()) {

                if (r - l + 1 < minlen) {
                    minlen = r - l + 1;
                    startidx = l;
                }

                char left = s.charAt(l);

                if (map.containsKey(left)) {

                    map.put(left, map.get(left) + 1);

                    if (map.get(left) > 0) {
                        count--;
                    }
                }

                l++;
            }

            r++;
        }

        if (minlen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startidx, startidx + minlen);
    }
}
