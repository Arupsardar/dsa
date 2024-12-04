package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buc =new List[nums.length+1];
         Map<Integer,Integer> map =new HashMap<>();
 
         for(int n:nums){
             map.put(n, map.getOrDefault(n, 0)+1);
         }
 
         for(int key :map.keySet()){
             int feq =map.get(key);
             if(buc[feq]==null){
                 buc[feq]=new ArrayList<>();
             }
             buc[feq].add(key);
         }
 
         int[] ans =new int[k];
         int count =0;
 
         for(int pos= buc.length-1;pos>=0 && count<k;pos--){
             if(buc[pos] != null){
                 for(Integer integer:buc[pos]){
                     ans[count++]=integer;
                 }
             }
         }
 
 
 
 
         return ans; 
     }
}