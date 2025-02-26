package Solution;

import java.util.*;

import strucher.ListNode;
import strucher.TreeNode;

public class Solution {
    /*
     * 3396. Minimum Number of Operations to Make Elements in Array Distinct
     * 
     * You are given an integer array nums. You need to ensure that the elements in the array are distinct. To achieve this, you can perform the following operation any number of times:

    Remove 3 elements from the beginning of the array. If the array has fewer than 3 elements, remove all remaining elements.
    Note that an empty array is considered to have distinct elements. Return the minimum number of operations needed to make the elements in the array distinct.
     */

    public int minimumOperations(int[] nums) {
        int count =0;
        for(int i=0;i<nums.length;i=i+3){
            HashSet<Integer> set =new HashSet<>();
            for(int j=i;j<nums.length;j++){
                if(set.contains(nums[j])){
                    count++;
                    break;
                }
                set.add(nums[i]);
            }
            
        }
        return count;
    }
    /*
     3402. Minimum Operations to Make Columns Strictly Increasing
        Solved
        Easy
        Companies
        Hint
        You are given a m x n matrix grid consisting of non-negative integers.

        In one operation, you can increment the value of any grid[i][j] by 1.

        Return the minimum number of operations needed to make all columns of grid strictly increasing.

        

        Example 1:

        Input: grid = [[3,2],[1,3],[3,4],[0,1]]

        Output: 15

        Explanation:

        To make the 0th column strictly increasing, we can apply 3 operations on grid[1][0], 2 operations on grid[2][0], and 6 operations on grid[3][0].
        To make the 1st column strictly increasing, we can apply 4 operations on grid[3][1].
     */


    public int minimumOperations(int[][] grid) {
        int count=0;
        int n=grid.length;
        int m =grid[0].length;
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                if(grid[i][j]<= grid[i-1][j]){
                    count =count+(grid[i-1][j]-grid[i][j])+1;
                    grid[i][j]=grid[i-1][j]+1;
                }
                
            }
        }
        return count;
        
    }

    /*
     3407. Substring Matching Pattern

        Easy
        Companies
        Hint
        You are given a string s and a pattern string p, where p contains exactly one '*' character.

        The '*' in p can be replaced with any sequence of zero or more characters.

        Return true if p can be made a substring of s, and false otherwise.

        A substring is a contiguous non-empty sequence of characters within a string.
     */


    public boolean hasMatch(String s, String p) {
        int star = p.indexOf('*');
         String prefix = p.substring(0, star);
         String suffix = p.substring(star + 1);
         for (int start = 0; start < s.length(); start++) {
             for (int end = start; end < s.length(); end++) {
                 String sub = s.substring(start, end + 1);
                 if (sub.length() >= prefix.length() + suffix.length()
                    && sub.startsWith(prefix)
                    && sub.endsWith(suffix)) {
                     return true;
                 }
             }
         }
         return false;
         
     }

     /*
      3411. Maximum Subarray With Equal Products

        You are given an array of positive integers nums.

        An array arr is called product equivalent if prod(arr) == lcm(arr) * gcd(arr), where:

        prod(arr) is the product of all elements of arr.
        gcd(arr) is the GCD of all elements of arr.
        lcm(arr) is the LCM of all elements of arr.
        Return the length of the longest product equivalent subarray of nums.

        A subarray is a contiguous non-empty sequence of elements within an array.

        The term gcd(a, b) denotes the greatest common divisor of a and b.

        The term lcm(a, b) denotes the least common multiple of a and b.
      */

     public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        // Iterate through all possible starting points of subarrays
        for (int start = 0; start < n; start++) {
            long product = 1;
            long currentGCD = 0;
            long currentLCM = 1;

            // Extend the subarray from the current starting point
            for (int end = start; end < n; end++) {
                // Update product
                product *= nums[end];

                // Update GCD
                currentGCD = currentGCD == 0 ? nums[end] : gcd((int) currentGCD, nums[end]);

                // Update LCM
                currentLCM = lcm(currentLCM, nums[end]);

                // Check if the current subarray satisfies the condition
                if (product == currentGCD * currentLCM) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }
        }

        return maxLength;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    
    private long lcm(long a, long b) {
        return a * (b / gcd((int) a, (int) b));
    }

    /*
     3417. Zigzag Grid Traversal With Skip

        You are given an m x n 2D array grid of positive integers.

        Your task is to traverse grid in a zigzag pattern while skipping every alternate cell.

        Zigzag pattern traversal is defined as following the below actions:

        Start at the top-left cell (0, 0).
        Move right within a row until the end of the row is reached.
        Drop down to the next row, then traverse left until the beginning of the row is reached.
        Continue alternating between right and left traversal until every row has been traversed.
        Note that you must skip every alternate cell during the traversal.

        Return an array of integers result containing, in order, the value of the cells visited during the zigzag traversal with skips.
     */

    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result = new ArrayList<>();
         int m = grid.length;    // Number of rows
         int n = grid[0].length; // Number of columns
         boolean leftToRight = true;
         int cellCount = 0;      // Global cell count for skip logic
 
         for (int i = 0; i < m; i++) {
             if (leftToRight) {
                 // Traverse left to right
                 for (int j = 0; j < n; j++) {
                     if (cellCount % 2 == 0) {
                         result.add(grid[i][j]);
                     }
                     cellCount++;
                 }
             } else {
                 // Traverse right to left
                 for (int j = n - 1; j >= 0; j--) {
                     if (cellCount % 2 == 0) {
                         result.add(grid[i][j]);
                     }
                     cellCount++;
                 }
             }
             // Switch direction
             leftToRight = !leftToRight;
         }
 
         return result;
     }

     /*
      Q1. Count Partitions with Even Sum Difference

        You are given an integer array nums of length n.

        A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:

        Left subarray contains indices [0, i].
        Right subarray contains indices [i + 1, n - 1].
        Return the number of partitions where the difference between the sum of the left and right subarrays is even.
      */


     public int countPartitions(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        int count = 0;

        // Traverse the array to compute partitions
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            int rightSum = totalSum - leftSum;

            // Check if the difference between leftSum and rightSum is even
            if ((leftSum - rightSum) % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    /*
     Q1. Find Valid Pair of Adjacent Digits in String

        You are given a string s consisting only of digits. A valid pair is defined as two adjacent digits in s such that:

        The first digit is not equal to the second.
        Each digit in the pair appears in s exactly as many times as its numeric value.
        Return the first valid pair found in the string s when traversing from left to right. If no valid pair exists, return an empty string.
     */

    public String findValidPair(String s) {
        int [] freq =new int[10];
         for(int i=0;i<s.length();i++){
             int t =s.charAt(i)-'0';
             freq[t]++;
         }
 
         for (int i = 0; i < s.length() - 1; i++) {
             char first = s.charAt(i);
             char second = s.charAt(i + 1);
 
             int firstDigit = first - '0';
             int secondDigit = second - '0';
 
             // Check if they are different and both match their frequency
             if (firstDigit != secondDigit && freq[firstDigit] == firstDigit && freq[secondDigit] == secondDigit) {
                 return "" + first + second; // Return first valid pair found
             }
         }
 
         return "";
     }


     //mmsmsym
     /*
      3442. Maximum Difference Between Even and Odd Frequency I

        You are given a string s consisting of lowercase English letters. Your task is to find the maximum difference between the frequency of two characters in the string such that:

        One of the characters has an even frequency in the string.
        The other character has an odd frequency in the string.
        Return the maximum difference, calculated as the frequency of the character with an odd frequency minus the frequency of the character with an even frequency.


      */

     public int maxDifference(String s) {
        int[] freq = new int[26]; 

   
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int ans=Integer.MIN_VALUE;
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(freq[i]>0 && freq[i]%2 !=0 && freq[j]>0 && freq[j]%2 ==0){
                   ans=Math.max(ans, freq[i]-freq[j]);
                }
            }
        }

        return ans;
   
    }

    public int maxDifference2(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray()) f[c - 'a']++;
        
        int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
        for (int x : f) {
            if (x > 0) {
                if ((x & 1) == 1) mx = Math.max(mx, x);
                else mn = Math.min(mn, x);
            }
        }
        return mx - mn;
    }

    public int[] assignElements(int[] groups, int[] elements) {
        int n =groups.length;
        int m  =elements.length;
        int [] ans =new int[n];
        for(int i=0;i<n;i++){
            ans[i]=-1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;i++){
                if(ans[j] != -1){
                    if(groups[j]%elements[i]==0){
                        ans[j]=i;
                    }
                }
            }
        }
        return ans;
    }

    /*
     3446. Sort Matrix by Diagonals

        You are given an n x n square matrix of integers grid. Return the matrix such that:

        The diagonals in the bottom-left triangle (including the middle diagonal) are sorted in non-increasing order.
        The diagonals in the top-right triangle are sorted in non-decreasing order.
     */

    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, List<Integer>> diagonals = new HashMap<>();

        // Step 1: Extract diagonals and store in HashMap
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                diagonals.putIfAbsent(key, new ArrayList<>());
                diagonals.get(key).add(grid[i][j]);
            }
        }

        // Step 2: Sort each diagonal
        for (Map.Entry<Integer, List<Integer>> entry : diagonals.entrySet()) {
            List<Integer> diag = entry.getValue();
            if (entry.getKey() < 0) {  // Top-right triangle (ascending order)
                Collections.sort(diag);
            } else {  // Bottom-left triangle (descending order)
                diag.sort(Collections.reverseOrder());
            }
        }

        // Step 3: Reinsert sorted values back into the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                grid[i][j] = diagonals.get(key).remove(0); // Remove from the front
            }
        }

        return grid;
    }

    /*
     * 80. Remove Duplicates from Sorted Array II

        Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

        Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

        Return k after placing the final result in the first k slots of nums.

        Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
     */

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;  // If length <= 2, no need to modify
        
        int i = 1; // Pointer for placing elements, start from index 1
        int count = 1; // Counts occurrences of current number

        for (int j = 1; j < n; j++) {
            if (nums[j] == nums[j - 1]) {
                count++; // Increment count if duplicate
            } else {
                count = 1; // Reset count if a new number is found
            }

            if (count <= 2) { // Allow at most two occurrences
                nums[i] = nums[j];
                i++;
            }
            System.out.println(j+" -"+count+" _"+i);
        }

        return i;
    }

    public static void main(String[] args) {
        int [] arr ={0,0,1,1,1,1,2,3,3};
        removeDuplicates(arr);
    }
    /*
     * 64. Minimum Path Sum

        Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

        Note: You can only move either down or right at any point in time.
     */

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];  // Only store current row
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j]; // Start position
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j]; // First row: can only come from left
                } else if (j == 0) {
                    dp[j] += grid[i][j]; // First column: can only come from above
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j]; // Min from left or top
                }
            }
        }
        return dp[n - 1];
    }

    public int incremovableSubarrayCount(int[] nums) {
        int n =nums.length;
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;i++){

                if(incremovableSubarrayCount(nums,i,j)){
                    count++;
                }

            }
        }
        return count;
    }

    /*
     * 2970. Count the Number of Incremovable Subarrays I

        You are given a 0-indexed array of positive integers nums.

        A subarray of nums is called incremovable if nums becomes strictly increasing on removing the subarray. For example, the subarray [3, 4] is an incremovable subarray of [5, 3, 4, 6, 7] because removing this subarray changes the array [5, 3, 4, 6, 7] to [5, 6, 7] which is strictly increasing.

        Return the total number of incremovable subarrays of nums.

        Note that an empty array is considered strictly increasing.

        A subarray is a contiguous non-empty sequence of elements within an array.
     */

    public boolean incremovableSubarrayCount(int[] nums,int start,int end) {
        int pre =0;
        for(int i=0;i<nums.length;i++){
            if(i<=end && i>=start){
                continue;
            }
            if(nums[i]<=pre){
                return false;
            }
            pre=nums[i];
        }
        
        return true;
    }

    /*
     1079. Letter Tile Possibilities

        You have n  tiles, where each tile has one letter tiles[i] printed on it.

        Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
     */


    public int numTilePossibilities(String tiles) {
        boolean[] arr =new boolean[tiles.length()];
        char [] charr =tiles.toCharArray();
        List<Character> po =new ArrayList<>();
        HashSet<List<Character>> set =new HashSet<>();
        numTilePossibilities(charr,arr,po,set,0);
        return set.size();
    }

    public void numTilePossibilities(char [] charr,boolean[] arr,List<Character> po,HashSet<List<Character>> set,int ind) {
            if(po.size()>0){
             set.add(new ArrayList<>(po));
            }
            
        
        for(int i=0;i<charr.length;i++){
            if(!arr[i]){
                po.add(charr[i]);
                arr[i]=true;
                numTilePossibilities(charr,arr,po,set,ind+1);
                po.remove(po.size()-1);
                arr[i]=false;
            }
            
        }
    }



    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> arr =new ArrayList<>();
        levelOrderBottom(root,arr,0);
        Collections.reverse(arr);
        return arr;
        
    }

    public void levelOrderBottom(TreeNode root,List<List<Integer>> arr,int ind) {
        if(root==null){
            return;
        }
        if(arr.size()<=ind){
            arr.add(new ArrayList<>());
        }
        arr.get(ind).add(root.val);
        levelOrderBottom(root.left,arr,ind+1);
        levelOrderBottom(root.right,arr,ind+1);
    }

    public int sumOfGoodNumbers(int[] nums, int k) {
        int n =nums.length;
        int sum =0;
        for(int i=0;i<n;i++){
            int pri =0;
            int next =0;
            if(i-k>0){
              pri=nums[i-k];
            }
            if(i+k<n-1){
              next = nums[i+k]; 
            }
            if(pri<nums[i] && next<nums[i]){
                sum +=nums[i];
            }
        }
        return sum;
    }

    /*
     Q1. Find Special Substring of Length K

        You are given a string s and an integer k.

        Determine if there exists a substring of length exactly k in s that satisfies the following conditions:

        The substring consists of only one distinct character (e.g., "aaa" or "bbb").
        If there is a character immediately before the substring, it must be different from the character in the substring.
        If there is a character immediately after the substring, it must also be different from the character in the substring.
        Return true if such a substring exists. Otherwise, return false.

        A substring is a contiguous non-empty sequence of characters within a string.
     */


    public boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
       
       if (n < k) return false; // Not enough characters to form a valid substring

       for (int i = 0; i <= n - k; i++) {
           char ch = s.charAt(i);
           
           // Check if substring from i to i + k - 1 has only one distinct character
           boolean isValid = true;
           for (int j = i; j < i + k; j++) {
               if (s.charAt(j) != ch) {
                   isValid = false;
                   break;
               }
           }
           
           // Check the character before and after (if they exist)
           if (isValid) {
               if (i > 0 && s.charAt(i - 1) == ch) continue; // Previous char is same
               if (i + k < n && s.charAt(i + k) == ch) continue; // Next char is same
               return true;
           }
       }
       return false;
   }

   /*
    160. Intersection of Two Linked Lists

        Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

        For example, the following two linked lists begin to intersect at node c1:


        The test cases are generated such that there are no cycles anywhere in the entire linked structure.

        Note that the linked lists must retain their original structure after the function returns.

        Custom Judge:

        The inputs to the judge are given as follows (your program is not given these inputs):

        intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
        listA - The first linked list.
        listB - The second linked list.
        skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
        skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
        The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
    */



   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode p1 = headA, p2 = headB;

        while (p1 != p2) {
            // If a pointer reaches the end, switch to the other list
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        return p1;
    }
    /*
     * 209. Minimum Size Subarray Sum

        Given an array of positive integers nums and a positive integer target, return the minimal length of a 
        subarray
        whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     */

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;
    
        for (int right = 0; right < n; right++) {
            sum += nums[right]; 
    
            while (sum >= target) { 
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left]; 
                left++;
                
            }
        }
    
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
     }


     /*
      * 238. Product of Array Except Self

        Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

        The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

        You must write an algorithm that runs in O(n) time and without using the division operation.
      */


     public int[] productExceptSelf(int[] nums) {
        int n =nums.length;
        int [] ans =new int[n];
        ans[0]=1;
        for(int i=1;i<n;i++){
            ans[i] =ans[i-1]*nums[i-1];
        }
        
        int sef =1;

        for(int i=n-1;i>=0;i--){
            ans[i] *=sef;
            sef *=nums[i];
        }

        return ans;

        
    }
    /*
     * 171. Excel Sheet Column Number

            Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

            For example:

            A -> 1
            B -> 2
            C -> 3
            ...
            Z -> 26
            AA -> 27
            AB -> 28 
            ...

     */

    public int titleToNumber(String columnTitle) {
        int num =0;
        for(int i=0;i <columnTitle.length();i++){
            int nu =(columnTitle.charAt(i)-'A')+1;
            
            num =num*26+nu;
        }
        return num;
    }

    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> ans =new ArrayList<>();
        findBottomLeftValue(root,ans,1);
        int level =ans.size();
        int ans2 =ans.get(level-1).get(0);
        return ans2;
    }

    public void findBottomLeftValue(TreeNode root,List<List<Integer>> ans,int level) {
        if(root==null){
            return;
        }
        if(level >=ans.size()){
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        findBottomLeftValue(root.left,ans,level+1);
        findBottomLeftValue(root.right,ans,level+1);
        
    }

    /*
     
3461. Check If Digits Are Equal in String After Operations I

        You are given a string s consisting of digits. Perform the following operation repeatedly until the string has exactly two digits:

        For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
        Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
        Return true if the final two digits in s are the same; otherwise, return false.
     */

    public static boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder next = new StringBuilder();
            for (int i = 1; i < s.length(); i++) {
                int sum = (s.charAt(i - 1) - '0' + s.charAt(i) - '0') % 10;
                next.append(sum);
            }
            s = next.toString();
        }
        return s.charAt(0) == s.charAt(1);

    }

    /*
     * 24. Swap Nodes in Pairs

        Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
     */

    public ListNode swapPairs(ListNode head) {
        if(head ==null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
    
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;
            
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
            
        }
        
        return dummy.next;
    }

    /*
     * 43. Multiply Strings

        Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

        Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
     */

    public String multiply(String num1, String num2) {
        if(num1.equals("0") && num2.equals("0")){
              return  "0";
          }
          int m=num1.length(), n=num2.length();
          int [] result =new int[m+n];
 
          for(int i=m -1;i>=0;i--){
              for(int j=n-1;j>=0;j--){
                  int mul =(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                  int ans = mul +result[i+j+1];
 
                  result[i+j+1] =ans%10;
                  result[i+j] +=ans/10;
 
              }
          }
 
          StringBuilder sb =new StringBuilder();
         for (int num : result) {
             if (!(sb.length() == 0 && num == 0)) {
                 sb.append(num);
             }
         }
 
          return  sb.length() ==0? "0" :sb.toString(); 
         
     }


     /*
      61. Rotate List

        Given the head of a linked list, rotate the list to the right by k places.
      */

     public ListNode rotateRight(ListNode head, int k) {
        if(head ==null){
          return null;
        }
        if(k==0){
          return head;
        }
        int count =0;
          ListNode current =head;
          while (current !=null) {
              count++;
              current =current.next;
          }
          int rotet  =k%count;
          ListNode c1=head;
          for(int i=0;i<rotet;i++){
              ListNode ch =c1;
              while(c1.next.next !=null){
                  c1=c1.next;
              }
              ListNode c2 =c1;
              c1 =c1.next;
              c2.next=null;
              c1.next =ch;
              
          }
          return c1; 
      }

      public ListNode rotateRight2(ListNode head, int k) {
        int count =0;
        ListNode current =head;
        while (current !=null) {
            count++;
            current =current.next;
        }
        int rotet  =k%count;
        ListNode current1 =head;
        System.out.println(rotet);
        while(rotet>0){
            current1=current1.next;
            rotet--;
        }
        System.out.println(current1.val);
        current=current1;
        current1 =current1.next;
        ListNode temp =current1;
        current1.next =head;
        current.next=null;
        return temp;
    }

    
    
}

/*
 303. Range Sum Query - Immutable

        Given an integer array nums, handle multiple queries of the following type:

        Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
        Implement the NumArray class:

        NumArray(int[] nums) Initializes the object with the integer array nums.
        int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 */


class NumArray {

    private int [] nums;

    public NumArray(int[] nums) {
        this.nums=nums;
    }
    
    public int sumRange(int left, int right) {
        int ans =0;
        for(int i=left;i<=right;i++){
            ans =ans+this.nums[i];
        }
        return ans;
    }

    
}

class NumArray2 {

    private int [] nums2;

    public NumArray2(int[] nums) {
        nums2 = new int[nums.length + 1]; 
        for (int i = 0; i < nums.length; i++) {
            nums2[i + 1] = nums2[i] + nums[i]; 
        }
    }
    
    public int sumRange(int left, int right) {
      return nums2[right+1]- nums2[left];
    }
}
