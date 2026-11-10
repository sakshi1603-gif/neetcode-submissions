class Solution {
    public String encode(List<String> strs) {
        StringBuilder encoded_string = new StringBuilder();
        for (String str : strs) {
            encoded_string.append(str.length() + "#" + str);
        }
        return encoded_string.toString();
    }
    // 2#sa3#ksh
    public List<String> decode(String str) {
        List<String> decode = new ArrayList<>();

        if (str.isEmpty()) {
            return new ArrayList<>();
        }

        int i = 0;

        while (i < str.length()) {
            int delimiter = str.indexOf('#', i);

            int len = Integer.parseInt(str.substring(i, delimiter));

            String word = str.substring(delimiter + 1, delimiter + 1 + len);

            decode.add(word);

            i = delimiter + 1 + len;
        }

        return decode;
    }
}
