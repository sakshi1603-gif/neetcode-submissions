class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if (nums.length == 0) {
            return 0;
        }
        int maxlen = 1;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                int sp = num;
                int count = 1;
                int i = 0;
                while (set.contains(sp + 1)) {
                        count++;
                        sp ++;
                }
                maxlen = Math.max(maxlen, count);
            }
        }
        return maxlen;
    }
}
