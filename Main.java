import java.util.*;



public class Main {
    
    public static void main(String[] args) {
        System.out.println("hello");
        int [] arr ={-10,-10};
        constructTransformedArray(arr);
    }

    public static int[] constructTransformedArray(int[] nums) {
        int n =nums.length;
        int[] rest = new int[n];
        for(int i=0;i<n;i++){
             if(nums[i]>0){
                rest[i]=nums[(i+nums[i])%n];
             }else{
                
                rest[i]=nums[(i-(Math.abs(nums[i])%n)+n)%n];
             }
             
        }
        return rest;
        
    }

    

    
}
