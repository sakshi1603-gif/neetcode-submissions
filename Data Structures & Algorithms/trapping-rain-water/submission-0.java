class Solution {
    public int trap(int[] height) {
        int lmax = 0 ;
        int rmax= 0 ;
        int l = 0;
        int r = height.length -1;
        int total = 0 ;
        while(r!=l){
            lmax = Math.max(lmax , height[l]);
            rmax = Math.max(rmax , height[r]);
            if(lmax<=rmax){
                total += lmax - height[l];
                l++;
            }else{
                total += rmax - height[r];
                r--;
            }
        }
        return total;
    }
}
