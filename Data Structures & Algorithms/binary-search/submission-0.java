class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int sp = 0;
        int ep = n - 1;

        while (sp <= ep) {
            int mid = sp + (ep - sp) / 2;

            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] > target) {
                ep = mid - 1;
            } 
            else {
                sp = mid + 1;
            }
        }

        return -1;
    }
}