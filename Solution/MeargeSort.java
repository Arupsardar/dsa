package Solution;

public class MeargeSort {

    /*
     912. Sort an Array

        Given an array of integers nums, sort the array in ascending order and return it.

        You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
     */
    public int[] sortArray(int[] nums) {
        sort(nums,0,nums.length-1);
        return nums;
    }

    public void sort(int[] nums,int l,int r){
        if(l<r){
            int m =l+(r-l)/2;
            sort(nums,l,m);
            sort(nums,m+1,r);
            marge(nums,l,m,r);
        }
    }

    public void marge(int[] nums,int l,int m,int r) {
        int n1=m-l+1;
        int n2=r-m;
        int [] arr1=new int[n1];
        int [] arr2=new int[n2];

        for(int i=0;i<n1;i++){
            arr1[i]=nums[l+i];
        }
        for (int j = 0; j < n2; j++) {
                arr2[j] = nums[m + 1 + j];
            }
        int i=0;
        int j=0;
        int k=l;
        while(i<n1 &&j<n2){
            if (arr1[i] <= arr2[j]) { 
            nums[k] = arr1[i];
            i++;
        } else {
            nums[k] = arr2[j];
            j++;
        }
        k++;
        }

        while(i<n1){
           nums[k]=arr1[i];
           i++;
           k++;  
        }

        while(j<n2){
           nums[k]=arr2[j];
           j++;
           k++;  
        }
    }
}
