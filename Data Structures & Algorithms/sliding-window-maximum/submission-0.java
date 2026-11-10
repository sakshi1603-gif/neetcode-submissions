
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {

            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < nums[i]) {

                dq.removeLast();
            }

            dq.addLast(i);
        }
        int pointer = 0;
        ans[pointer++] = nums[dq.peekFirst()];

        int sp = 1;
        int ep = k;

        while (ep < nums.length) {
            if (!dq.isEmpty() && dq.peekFirst() < sp) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < nums[ep]) {

                dq.removeLast();
            }

            dq.addLast(ep);
            ans[pointer++] = nums[dq.peekFirst()];

            sp++;
            ep++;
        }

        return ans;
    }
}
