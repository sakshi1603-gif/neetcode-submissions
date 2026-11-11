class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;

        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }
        int sp = 1;
        int ep = max;
        int ans = max;
        while (sp <= ep) {
            int mid = sp + (ep - sp) / 2;
            long totalHours = 0;
            for (int i = 0; i < piles.length; i++) {
                totalHours += ((long)piles[i] + mid - 1) / mid;
            }
            if (totalHours <= h) {
                ans = mid;
                ep = mid - 1;
            } else {
                sp = mid + 1;
            }
        }
        return ans;
    }
}
