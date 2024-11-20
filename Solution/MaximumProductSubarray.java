package Solution;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n =nums.length;
        int pre=1;
        int sef =1;
        int max =Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(pre ==0){
                pre=1;
            }
            if(sef==0){
                sef =1;
            }
            pre =pre*nums[i];
            sef =sef *nums[n-i-1];
            max =Math.max(max, Math.max(pre,sef));
        }
        return max;
    }
}
