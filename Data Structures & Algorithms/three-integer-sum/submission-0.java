class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            int sp = i + 1;
            int ep = nums.length - 1;

            while (sp < ep) {

                int sum = nums[sp] + nums[ep];

                if (sum == target) {

                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[sp]);
                    temp.add(nums[ep]);

                    ans.add(temp);

                    sp++;
                    ep--;
                    while (sp < ep && nums[sp] == nums[sp - 1]) {
                        sp++;
                    }

                    while (sp < ep && nums[ep] == nums[ep + 1]) {
                        ep--;
                    }
                }
                else if (sum > target) {
                    ep--;
                }
                else {
                    sp++;
                }
            }
        }

        return ans;
    }
}