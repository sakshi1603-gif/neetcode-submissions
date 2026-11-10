class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Add numbers according to frequency
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            buckets[frequency].add(key);
        }

        // Step 4: Collect top K elements
        int[] ans = new int[k];
        int j = 0;

        for (int i = buckets.length - 1; i >= 1; i--) {
            for (int num : buckets[i]) {
                ans[j] = num;
                j++;

                if (j == k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
