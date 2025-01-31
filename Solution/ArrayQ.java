package Solution;

import java.util.*;

public class ArrayQ {
    
    /*
     3184. Count Pairs That Form a Complete Day I

        Given an integer array hours representing times in hours, return an integer denoting the number of pairs i, j where i < j and hours[i] + hours[j] forms a complete day.

        A complete day is defined as a time duration that is an exact multiple of 24 hours.

        For example, 1 day is 24 hours, 2 days is 48 hours, 3 days is 72 hours, and so on
     */

    public int countCompleteDayPairs(int[] hours) {
        int count =0;
        for(int i=0;i<hours.length-1;i++){
            for(int j=i+1;j<hours.length;j++){
                int total =hours[i]+hours[j];
                System.out.println(total);
                if(total %24==0){
                    count++;
                }
            }
        }
        return count;
        
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>>  arr =new HashSet<>();
        List<Integer> arr2 =new ArrayList<>();
        boolean[] visit =new boolean[nums.length];
        permuteUnique(nums,arr,arr2,visit);
        List<List<Integer>> ans =new ArrayList<>(arr);

        return ans;
        

    }

    /*
     47. Permutations II

        Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
     */

    public void permuteUnique(int[] nums,HashSet<List<Integer>>  arr,List<Integer> arr2,boolean[] visit ) {
        if(arr2.size()==nums.length){
            arr.add(new ArrayList<>(arr2));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!visit[i]){
                visit[i]=true;
                arr2.add(nums[i]);
                permuteUnique(nums,arr,arr2,visit);
                visit[i]=false;
                arr2.remove(arr2.size()-1);
            }
        }
        
    }

    /*
     3074. Apple Redistribution into Boxes

        You are given an array apple of size n and an array capacity of size m.

        There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.

        Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.

        Note that, apples from the same pack can be distributed into different boxes.
     */

    public int minimumBoxes(int[] apple, int[] capacity) {
        int total =0;
        for(int i=0;i<apple.length;i++){
            total +=apple[i];
        }
        Arrays.sort(capacity);
        int tota=0;
        int count =0;
        for(int i=capacity.length-1;i>=0;i--){
            tota =tota+capacity[i];
            count++;
            if(tota >=total){
                break;
            }
        }
        return count;
    }
}
