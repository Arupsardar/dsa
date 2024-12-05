package Solution;

public class TwoSumIIInputArrayIsSorted {

    /*
     * /*
     * TC O(n^2)
     * SC o(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans =new int[2];
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j]==target){
                    ans[0]=i+1;
                    ans[1]=j+1;
                }

            }
        } 
        return ans;
    }

    /*
     * /*
     * TC O(n)
     * SC o(1)
     */

    public static int[] twoSum2(int[] numbers, int target) {
        int[] ans =new int[2];
        int n =numbers.length;
        int frist=0;
        int end=n-1;
        while(frist<end){
            System.out.println(frist+" "+end);
            int sum =numbers[frist]+numbers[end];
            if(sum==target){
                ans[0]=frist+1;
                ans[1]=end+1;
                return ans;
            }else if(sum>target){
                end--;
            }else{
                frist++;
            }
        }
        return ans;
    }
}
