package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import strucher.TreeNode;

public class TreeQustion {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Integer> arr =new ArrayList<>();
        levelwisesum(root,0,arr);
        long level=-1;
        int maxval=arr.get(0);
        for(int i=1;i<arr.size();i++){
            if(arr.get(i)>maxval){
                level =i;
                maxval=arr.get(i);
            }
        }
        return level;

        
    }

    public void levelwisesum(TreeNode root,int level,List <Integer> arr){
         if(root==null){
            return;
         }
         int val =arr.get(level);
         val =val+root.val;
         arr.add(level,val);
         levelwisesum(root.left,level+1,arr);
         levelwisesum(root.right,level+1,arr);
    }
}
