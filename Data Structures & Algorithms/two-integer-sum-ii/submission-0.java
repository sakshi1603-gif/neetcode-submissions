class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int sp = 0;
        int ep = numbers.length - 1;
        while (ep > sp) {
            int sum = numbers[sp] + numbers[ep];
            if (sum == target) {
                return new int[]{sp + 1, ep + 1};
            }
            if (sum > target) {
                ep--;
            }
            if (sum < target) {
                sp++;
            }
        }
        return new int[]{};
    }
}
// target < max
// target > max