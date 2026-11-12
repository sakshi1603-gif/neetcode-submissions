class Solution {
    public int findMin(int[] nums) {
        int sp = 0;
        int ep = nums.length - 1;

        while (sp < ep) {
            int mid = sp + (ep - sp) / 2;

            if (nums[mid] > nums[ep]) {
                sp = mid + 1;
            } else {
                ep = mid;
            }
        }

        return nums[sp];
    }
}