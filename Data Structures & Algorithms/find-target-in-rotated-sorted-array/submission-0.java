class Solution {
    public int search(int[] nums, int target) {
        int sp = 0;
        int ep = nums.length - 1;

        while (sp <= ep) {
            int mid = sp + (ep - sp) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[sp] <= nums[mid]) {

                if (target >= nums[sp] && target < nums[mid]) {
                    ep = mid - 1;
                } else {
                    sp = mid + 1;
                }
            }

            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[ep]) {
                    sp = mid + 1;
                } else {
                    ep = mid - 1;
                }
            }
        }

        return -1;
    }
}