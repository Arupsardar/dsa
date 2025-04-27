package Solution;

import java.util.*;
import java.util.stream.Collectors;

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

    /*
     189. Rotate Array

        Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
     */


    public void rotate(int[] nums, int k) {
        int n =nums.length;
         int rot =k%n;
         int [] rot_arr =new int[rot];
         for(int i=0;i<rot;i++){
             
             rot_arr[rot-1-i]=nums[n-1-i];
         }
         for(int i=0;i<n-rot;i++){
             nums[n-1-i]=nums[n-rot-i-1];
         }
        for(int i=0;i<rot;i++){
            nums[rot-1-i]=rot_arr[rot-1-i];
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode [] ans =new ListNode[k];
        int nodecount =0;
        ListNode current =head;
        while (current !=null) {
           current =current.next;
           nodecount++;  
        }
        double submit_val =nodecount/k;
        if(submit_val<0){
            current =head;
            
        }else{

        }
        return ans;
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       HashSet<List<Integer>> set =new HashSet<>();
        boolean[] use =new boolean[nums.length];
        List<Integer> arr =new ArrayList<>();
        subsetsWithDup(nums,set,use,arr,0);
        List<List<Integer>> ans =new ArrayList<>(set);
        return  ans; 
    }

    /*
     90. Subsets II

        Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

        The solution set must not contain duplicate subsets. Return the solution in any order.
 */

    public void subsetsWithDup(int[] nums,HashSet<List<Integer>> set,boolean[] use,List<Integer> arr,int ind) {
        
        if(ind == nums.length){
            set.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[ind]);
        subsetsWithDup(nums,set,use,arr,ind+1);
        arr.remove(arr.size()-1);
        subsetsWithDup(nums,set,use,arr,ind+1);
    }

    /*
     Q1. Transform Array by Parity

        You are given an integer array nums. Transform nums by performing the following operations in the exact order specified:

        Replace each even number with 0.
        Replace each odd numbers with 1.
        Sort the modified array in non-decreasing order.
        Return the resulting array after performing these operations.
     */

    public int[] transformArray(int[] nums) {
        int n =nums.length;
        int [] ans =new int[n];
        for(int i=0;i<n;i++){
            ans[i]=nums[i]%2==0?0:1;
        }
        Arrays.sort(ans);
        return ans;
    }

    /*
     3471. Find the Largest Almost Missing Integer

        You are given an integer array nums and an integer k.

        An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.

        Return the largest almost missing integer from nums. If no such integer exists, return -1.

        A subarray is a contiguous sequence of elements within an array.
     */


    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> countInSubarrays = new HashMap<>();
        int n = nums.length;

        // Generate all subarrays of size k
        for (int i = 0; i <= n - k; i++) {
            Set<Integer> uniqueNumbers = new HashSet<>();
            
            // Process subarray [i, i+k-1]
            for (int j = i; j < i + k; j++) {
                uniqueNumbers.add(nums[j]);
            }

            // Update occurrence count for numbers in this subarray
            for (int num : uniqueNumbers) {
                countInSubarrays.put(num, countInSubarrays.getOrDefault(num, 0) + 1);
            }
        }

        int maxAlmostMissing = -1;

        // Find the largest number that appears in exactly one subarray
        for (int num : countInSubarrays.keySet()) {
            if (countInSubarrays.get(num) == 1) {
                maxAlmostMissing = Math.max(maxAlmostMissing, num);
            }
        }

        return maxAlmostMissing;
    }

    /*
     60. Permutation Sequence

        The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

        By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

        "123"
        "132"
        "213"
        "231"
        "312"
        "321"
        Given n and k, return the kth permutation sequence.
     */


    public String getPermutation(int n, int k) {
        List<List<Integer>> arr =new ArrayList<>();
        boolean [] vit =new boolean[n+1];
        List<Integer> ans =new ArrayList<>();
        getPermutation(n,0,vit,arr,ans);
        String result = arr.get(k-1).stream().map(String::valueOf).collect(Collectors.joining());
        return result;
    }

    public static void getPermutation(int n, int ind, boolean [] vit,List<List<Integer>> arr,List<Integer> ans) {
        if(ind==n){
            arr.add(new ArrayList<>(ans));
            return;
        }
        for(int i=1;i<=n;i++){
            if(!vit[i]){
                vit[i]=true;
                ans.add(i);
                getPermutation(n,ind+1,vit,arr,ans);
                ans.remove(ans.size()-1);
                vit[i]=false;
            }
        }

    }

    /*
     88. Merge Sorted Array

        You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

        Merge nums1 and nums2 into a single array sorted in non-decreasing order.

        The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // Pointer for nums1's actual elements
        int j = n - 1; // Pointer for nums2
        int k = m + n - 1; // Pointer for the merged array (nums1)

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 is not fully merged, copy remaining elements
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        
    }

    /*
     258. Add Digits

        Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
     */


    public int addDigits(int num) {
        while(num >=10){
            int i =0;
            while(num>0){
                i =i+num%10;
                num =num/10;
            }
            num =i;
        }
        
        
        return num;
    }

    /*
     264. Ugly Number II

        An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

        Given an integer n, return the nth ugly number.
     */

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
    
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    /*
     263. Ugly Number

        An ugly number is a positive integer which does not have a prime factor other than 2, 3, and 5.

        Given an integer n, return true if n is an ugly number.
     */

    public boolean isUgly(int n) {
        
        if(n<=0){
            return false;
        }
        while (n>1) {
           if(n%2==0){
              n=n/2;
           }
           else if(n%3==0){
            n=n/3;
           }else if(n%5==0){
            n=n/5;
           }else{
             return false;
           }
        }
        return true;
    }

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        pq.add(1L);
        seen.add(1L);
        
        int[] primes = {2, 3, 5};
        long ugly = 1;
        
        for (int i = 0; i < n; i++) {
            ugly = pq.poll();  // Get the smallest ugly number
            
            for (int prime : primes) {
                long next = ugly * prime;
                if (!seen.contains(next)) {
                    pq.add(next);
                    seen.add(next);
                }
            }
        }
        return (int) ugly;
        
    }

    public int nthUglyNumber2(int n) {
        int count =0;
        int num =1;
        int ans=1;
        while(count<n){
             boolean val =isUgly(num);
            
             if(val){
                count++;
             }
            num++;
            
        }
        return num-1;
        
    }

    /*
     * 204. Count Primes

        Given an integer n, return the number of prime numbers that are strictly less than n.
     */


    public int countPrimes(int n) {
        if(n<2)return 0;
        boolean[] isprime =new boolean[n];
        Arrays.fill(isprime,true);
        isprime[0]=isprime[1] =false;

        for(int i=2;i*i<n;i++){
            for(int j=i*i;j<n;j +=i){
                if(isprime[j]){
                    isprime[j]=false;
                }
            }
        }

        int count =0;
        for(int i=0;i<n;i++){
            if(isprime[i]){
                count++;
            }
        }
        return count;
    }

    //boot froce approch
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int j = 0; j < n; j++) {
                if (nums1[j] < nums1[i]) {
                    maxHeap.add(nums2[j]);
                }
            }

            int sum = 0, count = 0;
            while (!maxHeap.isEmpty() && count < k) {
                sum += maxHeap.poll();
                count++;
            }

            answer[i] = sum;
        }

        return answer;
    }

    /*
     3477. Fruits Into Baskets II

        You are given two arrays of integers, fruits and baskets, each of length n, where fruits[i] represents the quantity of the ith type of fruit, and baskets[j] represents the capacity of the jth basket.

        From left to right, place the fruits according to these rules:

        Each fruit type must be placed in the leftmost available basket with a capacity greater than or equal to the quantity of that fruit type.
        Each basket can hold only one type of fruit.
        If a fruit type cannot be placed in any basket, it remains unplaced.
        Return the number of fruit types that remain unplaced after all possible allocations are made.
     */

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] used = new boolean[baskets.length]; // Track used baskets
        int unplaced = 0;

        for (int i = 0; i < fruits.length; i++) {
            boolean placed = false;
            for (int j = 0; j < baskets.length; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true; // Mark basket as used
                    placed = true;
                    break; // Stop searching once placed
                }
            }
            if (!placed) {
                unplaced++; // No suitable basket found
            }
        }
        return unplaced;
    }

    /*
     * 

        414. Third Maximum Number

        Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
     */

    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> arr = new ArrayList<>(set);
        arr.sort(Comparator.reverseOrder()); // Sort in descending order

        return arr.size() >= 3 ? arr.get(2) : arr.get(0);
    }

    /*
     * 56. Merge Intervals

        Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     */

    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
             return  intervals;
         }
 
         Arrays.sort(intervals, Comparator.comparingInt(i ->i[0]));
         List<int[]> arr =new ArrayList<>();
         int [] newInervale =intervals[0];
         arr.add(newInervale);
 
         for(int [] interval : intervals){
             if(interval[0]<=newInervale[1]){
                 newInervale[1]=Math.max(interval[1],newInervale[1]);
             }else{
                 newInervale =interval;
                 arr.add(newInervale);
             }
         }
 
         return  arr.toArray(new int[arr.size()][]); 
     }

     /*
      57. Insert Interval

        You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

        Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

        Return intervals after the insertion.

        Note that you don't need to modify intervals in-place. You can make a new array and return it.
      */


     public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] mergedArray = new int[intervals.length + 1][];

          for(int i=0;i<intervals.length;i++){
            mergedArray[i]=intervals[i];
          }
          mergedArray[intervals.length]=newInterval;
        
       return merge(mergedArray);
    }

    /*
     3340. Check Balanced String

        You are given a string num consisting of only digits. A string of digits is called balanced if the sum of the digits at even indices is equal to the sum of digits at odd indices.

        Return true if num is balanced, otherwise return false.
     */


    public boolean isBalanced(String num) {
        int n =num.length();
        int evensum =0,odd_sum =0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                evensum +=num.charAt(i)-'0';
            }else {
                odd_sum +=num.charAt(i)-'0';
            }
        }
        return evensum==odd_sum;
    

    }
    /*
     * 51. N-Queens

        The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

        Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

        Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
     */

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        String[][] bord = new String[n][n];

        // Initialize board with "."
        for (int i = 0; i < n; i++) {
            Arrays.fill(bord[i], ".");
        }

        recurtionfunction(bord, 0, n, ans);
        return ans;
    }

    public boolean check(String[][] bord, int n, int row, int col) {
        // Check upper column
        for (int i = 0; i < row; i++) {
            if (bord[i][col].equals("Q")) {
                return false;
            }
        }

        // Check upper left diagonal
        int r = row, c = col;
        while (r >= 0 && c >= 0) {
            if (bord[r][c].equals("Q")) {
                return false;
            }
            r--;
            c--;
        }

        // Check upper right diagonal
        r = row;
        c = col;
        while (r >= 0 && c < n) {
            if (bord[r][c].equals("Q")) {
                return false;
            }
            r--;
            c++;
        }

        return true; // If no queen attacks this position
    }

    public void recurtionfunction(String[][] bord, int row, int n, List<List<String>> ans) {
        if (row == n) {
            List<String> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(String.join("", bord[i])); // Correct way to store board row
            }
            ans.add(arr);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (check(bord, n, row, col)) {
                bord[row][col] = "Q"; // Place the queen
                recurtionfunction(bord, row + 1, n, ans);
                bord[row][col] = "."; // Backtrack
            }
        }
    }

    /*
     * 52. N-Queens II

        The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

        Given an integer n, return the number of distinct solutions to the n-queens puzzle.
     */


    public int totalNQueens(int n) {
        return solve(0, 0, 0, 0, n);
    }
    
    private int solve(int row, int cols, int diags, int antiDiags, int n) {
        if (row == n)
            return 1;

        int availablePositions = ((1 << n) - 1) & ~(cols | diags | antiDiags);

        int solutions = 0;
        while (availablePositions != 0) {
            int pos = availablePositions & -availablePositions;
            availablePositions &= availablePositions - 1;
            solutions += solve(row + 1, cols | pos, (diags | pos) << 1, (antiDiags | pos) >> 1, n);
        }

        return solutions;
    }

    public int totalNumbers(int[] digits) {
        HashSet<Integer> set = new HashSet<>(); // Store unique numbers
        boolean[] used = new boolean[digits.length]; // Track used digits
        backtrack(digits, used, new ArrayList<>(), set);
        return set.size();
    }

    /*
     * 3483. Unique 3-Digit Even Numbers

        You are given an array of digits called digits. Your task is to determine the number of distinct three-digit even numbers that can be formed using these digits.

        Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.
     */

    private void backtrack(int[] digits, boolean[] used, List<Integer> num, HashSet<Integer> set) {
        if (num.size() == 3) {
            if (num.get(2) % 2 == 0) { // Ensure last digit is even
                int number = num.get(0) * 100 + num.get(1) * 10 + num.get(2); // Convert to integer
                set.add(number);
            }
            return;
        }

        for (int i = 0; i < digits.length; i++) {
            if (used[i]) continue; // Skip used digits
            if (num.size() == 0 && digits[i] == 0) continue; // Skip leading zero

            used[i] = true; // Mark as used
            num.add(digits[i]);

            backtrack(digits, used, num, set);

            num.remove(num.size() - 1); // Backtrack
            used[i] = false; // Unmark for other permutations
        }
    }

    /*
     * 3300. Minimum Element After Replacement With Digit Sum

        You are given an integer array nums.

        You replace each element in nums with the sum of its digits.

        Return the minimum element in nums after all replacements.
     */


    public int minElement(int[] nums) {
        int min_num =Integer.MAX_VALUE;
       for(int i=0;i<nums.length;i++){
           min_num=Math.min(min_num,addDigits2(nums[i]));
       }
       return  min_num;
    }

    public int addDigits2(int num) {
         int i=0;
        while(num>0){
            i =i+num%10;
            num =num/10;
        }
        return i;
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

    /*
     * 3487. Maximum Unique Subarray Sum After Deletion

        You are given an integer array nums.

        You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:

        All elements in the subarray are unique.
        The sum of the elements in the subarray is maximized.
        Return the maximum sum of such a subarray.
     */


    public int maxSum(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        boolean hasNonNegative = false;
        
        // Include one copy of each non-negative number
        for (int num : nums) {
            if (num >= 0) {
                hasNonNegative = true;
                if (!seen.contains(num)) {
                    seen.add(num);
                    sum += num;
                }
            }
        }
        
        // If there is at least one non-negative, return the sum of distinct non-negatives.
        if (hasNonNegative) {
            return sum;
        } else {
            // All elements are negative: return the maximum (least negative) element.
            int maxNegative = nums[0];
            for (int num : nums) {
                if (num > maxNegative) {
                    maxNegative = num;
                }
            }
            return maxNegative;
        }
    }

    public static int sum(int a)
    {
        if(a<=9)
        {return a;}
        int sum =0;
        
        while(a!=0)
        {
            int take= a%10;
            sum+=take;
            a/=10;
        }
     return sum;

    }

    /*
     * 1945. Sum of Digits of String After Convert

        You are given a string s consisting of lowercase English letters, and an integer k. Your task is to convert the string into an integer by a special process, and then transform it by summing its digits repeatedly k times. More specifically, perform the following steps:

        Convert s into an integer by replacing each letter with its position in the alphabet (i.e. replace 'a' with 1, 'b' with 2, ..., 'z' with 26).
        Transform the integer by replacing it with the sum of its digits.
        Repeat the transform operation (step 2) k times in total.
        For example, if s = "zbax" and k = 2, then the resulting integer would be 8 by the following operations:

        Convert: "zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
        Transform #1: 262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
        Transform #2: 17 ➝ 1 + 7 ➝ 8
        Return the resulting integer after performing the operations described above.
     */

    //Bast time

    public int getLucky2(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int it = s.charAt(i) - 'a' + 1;
            sum += sum(it);

        }

        if(k>=2)
        {
            for(int i=2;i<=k;i++)
            {
                
               sum= sum(sum);

            }
        }
        return(sum);
    }

    //My solution
    public int getLucky(String s, int k) {
        String num ="";
         for(int i=0;i<s.length();i++){
             int num1 =s.charAt(i)-'a';
            
             num +=(num1+1);
         }
        
         for(int i=0;i<k;i++){
            int ans=0;
            for(int j=0;j<num.length();j++){
                int n =num.charAt(j)-'0';
                ans +=n;
            }
            num ="";
            num +=ans;

         }
         return  Integer.parseInt(num);
    }

    /*
     2180. Count Integers With Even Digit Sum

        Given a positive integer num, return the number of positive integers less than or equal to num whose digit sums are even.

        The digit sum of a positive integer is the sum of all its digits.
     */

    public int countEven(int num) {
        int count =0;
        for(int i=1;i<=num;i++){
            
            int nu =countnum(i);
            if(nu%2==0){
                count++;
            }
        }
        return count;
    }

    public int countnum(int num){
        int ans=0;
        while(num>0){
            ans +=num%10;
            num=num/10; 
        }
        
        return ans;
    }

    /*
     2553. Separate the Digits in an Array

        Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums after separating them in the same order they appear in nums.

        To separate the digits of an integer is to get all the digits it has in the same order.

        For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
     */

    public int[] separateDigits(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();
        int count=0;
        for(int i=0;i<nums.length;i++){
            int num =nums[i];
            List<Integer> arr =new ArrayList<>();
            while (num>0){
                arr.add(num%10);
                num=num/10;
                count++;
            }
            list.add(arr);
        }
        
        int [] ans =new int[count];
        int i=0;
        for(List<Integer> arr:list){
            for (int j=arr.size()-1;j>=0;j--){
                ans[i]=arr.get(j);
                i++;
            }
        }
        return ans;
    }

    /*
     2310. Sum of Numbers With Units Digit K

        Given two integers num and k, consider a set of positive integers with the following properties:

        The units digit of each integer is k.
        The sum of the integers is num.
        Return the minimum possible size of such a set, or -1 if no such set exists.

        Note:

        The set can contain multiple instances of the same integer, and the sum of an empty set is considered 0.
        The units digit of a number is the rightmost digit of the number.
     */

    public int minimumNumbers(int num, int k) {
        if(num==0){
            return 0;
        }
        int count =0;
        for(int i=1;i<=10;i++){
            int sum =i*k;
            if(sum>num){
                break;
            }
            if((num-sum)%10==0){
                return i;
            }
        }
        return -1;
        
    }

    /*
     * 63. Unique Paths II

        You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

        An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

        Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

        The testcases are generated so that the answer will be less than or equal to 2 * 109.
     */

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n =obstacleGrid.length;
        int m =obstacleGrid[0].length;
        int [][] arr =new int[n][m];
        if(obstacleGrid[0][0]==1) return 0;
        arr[0][0]=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    arr[i][j]=0;
                }else{
                    if(i>0) arr[i][j] +=arr[i-1][j];
                    if(j>0) arr[i][j] +=arr[i][j-1];
                }
            }
        }
        return arr[n-1][m-1];
    }

    /*
     * 3492. Maximum Containers on a Ship

        You are given a positive integer n representing an n x n cargo deck on a ship. Each cell on the deck can hold one container with a weight of exactly w.

        However, the total weight of all containers, if loaded onto the deck, must not exceed the ship's maximum weight capacity, maxWeight.

        Return the maximum number of containers that can be loaded onto the ship.
     */

    public int maxContainers(int n, int w, int maxWeight) {
        int numberOfCells = n * n; 
        int containerCount = 0;
        int totalWeight = 0;

        while (containerCount < numberOfCells) { 
            if (totalWeight + w > maxWeight) {  
                break;
            }
            totalWeight += w;
            containerCount++;
        }
        
        return containerCount;
        
    }

    /*
     * 3493. Properties Graph

        You are given a 2D integer array properties having dimensions n x m and an integer k.

        Define a function intersect(a, b) that returns the number of distinct integers common to both arrays a and b.

        Construct an undirected graph where each index i corresponds to properties[i]. There is an edge between node i and node j if and only if intersect(properties[i], properties[j]) >= k, where i and j are in the range [0, n - 1] and i != j.

        Return the number of connected components in the resulting graph.
     */

    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        List<List<Integer>> graph = new ArrayList<>();
        
        // Convert each row into a set for faster intersection computation
        List<Set<Integer>> sets = new ArrayList<>();
        for (int[] row : properties) {
            Set<Integer> set = new HashSet<>();
            for (int num : row) {
                set.add(num);
            }
            sets.add(set);
            graph.add(new ArrayList<>());
        }

        // Build the graph by checking intersection counts
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intersect(sets.get(i), sets.get(j)) >= k) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        // Count connected components using DFS
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                components++;
            }
        }

        return components;
    }

    private int intersect(Set<Integer> a, Set<Integer> b) {
        int count = 0;
        for (int num : a) {
            if (b.contains(num)) {
                count++;
            }
        }
        return count;
    }
     
    private void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(graph, visited, neighbor);
            }
        }
    }

    /*
     162. Find Peak Element

            A peak element is an element that is strictly greater than its neighbors.

            Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

            You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

            You must write an algorithm that runs in O(log n) time.
     */


    public int findPeakElement(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int left =0;
        int right =nums.length;
        while(left<right){
            int mid =left+(right-left)/2;
            if(mid < nums.length - 1 && nums[mid]<nums[mid+1]){
                left =mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    /*
     * 852. Peak Index in a Mountain Array
        You are given an integer mountain array arr of length n where the values increase to a peak element and then decrease.

        Return the index of the peak element.

        Your task is to solve it in O(log(n)) time complexity.
     */

    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length==1){
            return 0;
        }
        int left =0;
        int right =arr.length;
        while(left<right){
            int mid =left+(right-left)/2;
            if(mid < arr.length - 1 && arr[mid]<arr[mid+1]){
                left =mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }

    /*
     * 2210. Count Hills and Valleys in an Array

        You are given a 0-indexed integer array nums. An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i]. Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i]. Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].

        Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.

        Return the number of hills and valleys in nums.
     */

    public int countHillValley(int[] nums) {

        int result = 0;
        
        int prev = nums[0];
        for(int i = 1 ; i < nums.length -1; i++){

            int curr = nums[i];
            if(prev == curr)
                continue;

            
            int next = nums[i+1];
            if(next == curr)
            continue;

            //System.out.printf("%d, %d, %d\n", prev, curr,next);

            if(curr < prev && curr < next){
                // valley 
                result++;
            }else if (curr > prev && curr > next){
                result++;
            }

            prev = curr;

             //System.out.printf("i=%d\n", i);
            

        }

        return result;

        
    }

    /*
     896. Monotonic Array

        An array is monotonic if it is either monotone increasing or monotone decreasing.

        An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

        Given an integer array nums, return true if the given array is monotonic, or false otherwise.
     */


    public boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            }
            if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
        }
        
        return increasing || decreasing;
    }

    /*
     16. 3Sum Closest

        Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

        Return the sum of the three integers.

        You may assume that each input would have exactly one solution.
     */

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
         int closestSum = nums[0] + nums[1] + nums[2]; // Start with the first three numbers
         
         for (int i = 0; i < nums.length - 2; i++) {
             int left = i + 1, right = nums.length - 1;
             
             while (left < right) {
                 int sum = nums[i] + nums[left] + nums[right];
 
                 // Update closest sum if the new sum is closer to the target
                 if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                     closestSum = sum;
                 }
 
                 // Move pointers based on comparison with target
                 if (sum < target) {
                     left++;  // Increase sum
                 } else if (sum > target) {
                     right--; // Decrease sum
                 } else {
                     return sum; // Exact match found
                 }
             }
         }
         return closestSum;
     }
     /*
      * 3498. Reverse Degree of a String

        Given a string s, calculate its reverse degree.

        The reverse degree is calculated as follows:

        For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
        Sum these products for all characters in the string.
        Return the reverse degree of s.
      */

     public int reverseDegree(String s) {
        int count =0;
        for(int i=0;i<s.length();i++){
            count +=(i+1)*(26-(int)(s.charAt(i)-'a'));
        }
        return count;
        
    }

    /*
     * 3503. Longest Palindrome After Substring Concatenation I

        You are given two strings, s and t.

        You can create a new string by selecting a substring from s (possibly empty) and a substring from t (possibly empty), then concatenating them in order.

        Return the length of the longest palindrome that can be formed this way.
     */

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public int longestPalindrome(String s, String t) {
        int maxLength = 0;
        int n = s.length(), m = t.length();

        // Iterate over all substrings of s
        for (int i = 0; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                String subS = s.substring(i, j);

                // Iterate over all substrings of t
                for (int k = 0; k <= m; k++) {
                    for (int l = k; l <= m; l++) {
                        String subT = t.substring(k, l);

                        // Concatenate and check if it's a palindrome
                        String concatStr = subS + subT;
                        if (isPalindrome(concatStr)) {
                            maxLength = Math.max(maxLength, concatStr.length());
                        }
                    }
                }
            }
        }

        return maxLength;
    }

    /*
     * Count Digits

        Given a positive integer n, count the number of digits in n that divide n evenly (i.e., without leaving a remainder). Return the total number of such digits.

        A digit d of n divides n evenly if the remainder when n is divided by d is 0 (n % d == 0).
        Digits of n should be checked individually. If a digit is 0, it should be ignored because division by 0 is undefined.
     */

    static int evenlyDivides(int n) {
        int count =0;
        int num =n;
        while(n>0){
            int mod=n%10;
            n=n/10;
            if(mod != 0 && num%mod==0){
                count++;
            }
        }
        return count;
    }

    /*
     * Given two integers a and b, the task is to compute their LCM and GCD and return an array containing their LCM and GCD.
     */

    public static int[] lcmAndGcd(int a, int b) {
        int max =Math.max(a,b);
        int min =Math.min(a,b);
        while(max%min!=0){
            int mod =max%min;
            max =min;
            min =mod;
        }
        int [] ans =new int[2];
        ans[1]=min;
        int lcm =(a*b)/min;
        ans[0]=lcm;
        return ans;
    }

    /*
     * 74. Search a 2D Matrix

        You are given an m x n integer matrix matrix with the following two properties:

        Each row is sorted in non-decreasing order.
        The first integer of each row is greater than the last integer of the previous row.
        Given an integer target, return true if target is in matrix or false otherwise.

        You must write a solution in O(log(m * n)) time complexity.
     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int n =matrix.length;
        int m =matrix[0].length;
        boolean ans =false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }

        return ans;
    }

    /*
     * Armstrong Numbers

            You are given a 3-digit number n, Find whether it is an Armstrong number or not.

            An Armstrong number of three digits is a number such that the sum of the cubes of its digits is equal to the number itself. 371 is an Armstrong number since 33 + 73 + 13 = 371. 


     */

    static boolean armstrongNumber(int n) {
        long num =0;
        int num2=n;
        while(n>0){
            int mod =n%10;
            num +=(mod*mod*mod);
            n=n/10;
        }
        return num ==num2;
     }

     /*
      81. Search in Rotated Sorted Array II

        There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

        Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

        Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

        You must decrease the overall operation steps as much as possible.
      */

     public boolean search(int[] nums, int target) {
        int left =0;
        int right =nums.length-1;
        while(left<=right){
            int mid =left+(right-left)/2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[left]==nums[mid] && nums[right]==nums[mid]){
                left++;
                right--;
                continue;
            }

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; 
                } else {
                    left = mid + 1; 
                }
            } 
            
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; 
                } else {
                    right = mid - 1; 
                }
            }

        }
        return false;
    }

    /*
     * Sum Of Digits

        Given a number n. Find the sum of all the digits of n.
     */

    static int sumOfDigits(int n) {
        int sum =0;
        while(n>0){
            sum +=n%10;
            n=n/10;
        }
        return sum;
    }

    /*
     * 203. Remove Linked List Elements

        Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
     */

    public ListNode removeElements(ListNode head, int val) {
        if(head ==null){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode c1 = dummy;
        
        while(c1.next !=null){
            if(c1.next.val ==val){
                c1.next =c1.next.next;
            }else{
                c1=c1.next;
            }
        
        }
        

        return dummy.next;
    }

    /*
     * 

        50. Pow(x, n)

        Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
     */

    public double myPow(double x, int n) {
        if (n == 0) return 1.0; // Base case: x^0 = 1
    
            long exp = n; // Convert to long to avoid overflow for INT_MIN case
            if (exp < 0) {
                x = 1 / x;
                exp = -exp;
            }
            
            double result = 1.0;
            while (exp > 0) {
                if (exp % 2 == 1) { // If exponent is odd, multiply the result with x
                    result *= x;
                }
                x *= x;  // Square the base
                exp /= 2; // Reduce exponent by half
            }
            
        return result;
    }

    /*
     * 137. Single Number II

        Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

        You must implement a solution with a linear runtime complexity and use only constant extra space.
     */

    public int singleNumber(int[] nums) {
        int ones=0,twos=0;
         for (int num: nums) {
             ones =(ones ^ num) & ~ twos;
             twos =(twos ^ num) & ~ones;
         }
         return  ones;
     }


     /*
      * 3158. Find the XOR of Numbers Which Appear Twice

        You are given an array nums, where each number in the array appears either once or twice.

        Return the bitwise XOR of all the numbers that appear twice in the array, or 0 if no number appears twice.
      */
     public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        boolean[] has = new boolean[51];
        for (int num : nums) {
            if (has[num]) ans ^= num;
            has[num] = true;
        }
        return ans;
    }

    public int duplicateNumbersXOR2(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
     
         for (int num : nums) {
             freq.put(num, freq.getOrDefault(num, 0) + 1);
         }
         
         int xor = 0;
         for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
             if (entry.getValue() == 2) {
                 xor ^= entry.getKey();
             }
         }
         
         return xor;
    }

    /*
     
     */


    public static int findMinReplacements(List<Integer> pack) {
        int n = pack.size();
        Map<Integer, Integer> evenFreq = new HashMap<>();
        Map<Integer, Integer> oddFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int val = pack.get(i);
            if (i % 2 == 0) evenFreq.put(val, evenFreq.getOrDefault(val, 0) + 1);
            else oddFreq.put(val, oddFreq.getOrDefault(val, 0) + 1);
        }

        List<int[]> evenTop = getTopTwo(evenFreq);
        List<int[]> oddTop = getTopTwo(oddFreq);

        int maxFreqEven1 = evenTop.get(0)[1], evenKey1 = evenTop.get(0)[0];
        int maxFreqOdd1 = oddTop.get(0)[1], oddKey1 = oddTop.get(0)[0];

        if (evenKey1 != oddKey1) {
            return n / 2 - maxFreqEven1 + n / 2 - maxFreqOdd1;
        } else {
            int opt1 = n / 2 - maxFreqEven1 + n / 2 - (oddTop.size() > 1 ? oddTop.get(1)[1] : 0);
            int opt2 = n / 2 - (evenTop.size() > 1 ? evenTop.get(1)[1] : 0) + n / 2 - maxFreqOdd1;
            return Math.min(opt1, opt2);
        }
    }

    private static List<int[]> getTopTwo(Map<Integer, Integer> freqMap) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        List<int[]> topTwo = new ArrayList<>();
        if (!pq.isEmpty()) topTwo.add(pq.poll());
        if (!pq.isEmpty()) topTwo.add(pq.poll());
        return topTwo;
    }

    /*
     * 
     */

    public static int minRetailersToRelocate(List<Integer> regionStart, List<Integer> regionEnd) {
        int n = regionStart.size();
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = regionStart.get(i);
            ends[i] = regionEnd.get(i);
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int minToRelocate = n;

        for (int i = 0; i < n; i++) {
            int left = regionStart.get(i);
            int right = regionEnd.get(i);

            int before = upperBound(ends, left - 1); // ends before current start
            int after = n - lowerBound(starts, right + 1); // starts after current end
            int nonIntersecting = before + after;

            minToRelocate = Math.min(minToRelocate, nonIntersecting);
        }

        return minToRelocate;
    }

    private static int upperBound(int[] arr, int val) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= val) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private static int lowerBound(int[] arr, int val) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < val) low = mid + 1;
            else high = mid;
        }
        return low;
        
    }

    /*
     * Q1. Minimum Pair Removal to Sort Array I

        Given an array nums, you can perform the following operation any number of times:

        Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
        Replace the pair with their sum.
        Return the minimum number of operations needed to make the array non-decreasing.

        An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).


     */

    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
        
            int operations = 0;
        
            while (!isSorted(list)) {
                int minSum = Integer.MAX_VALUE;
                int minIndex = -1;
        
                // Find the leftmost adjacent pair with the minimum sum
                for (int i = 0; i < list.size() - 1; i++) {
                    int sum = list.get(i) + list.get(i + 1);
                    if (sum < minSum) {
                        minSum = sum;
                        minIndex = i;
                    }
                }
        
                // Replace the pair with their sum
                list.set(minIndex, minSum);
                list.remove(minIndex + 1); // shrink the list
                operations++;
            }
        
            return operations; 
     }
 
    private boolean isSorted(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    /*
     * 29. Divide Two Integers

        Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

        The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

        Return the quotient after dividing dividend by divisor.

        Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.
     */

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
    
        // Convert both numbers to long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
    
        int result = 0;
    
        // Repeatedly subtract multiples of divisor (doubling strategy)
        while (a >= b) {
            long temp = b, multiple = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            a -= temp;
            result += multiple;
        }
    
        // Determine sign
        return (dividend > 0) == (divisor > 0) ? result : -result;
     }

     /*
      * 260. Single Number III

        Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

        You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
      */

     public int[] singleNumberIII(int[] nums) {
        long xor =0;
        for (int num: nums) {
           xor =xor ^num;
        }
        long rit =(xor&xor-1)^xor;
        int b1=0,b2=0;
        for (int num: nums) {
            if((rit & num)>0){
                b1 =b1^num;
            }else{
                b2 =b2^num;
            }
        }

        return new int[] {b1,b2};
    }

     public int[] singleNumberIIIBoot(int[] nums) {
        HashMap<Integer,Integer> map =new HashMap<>();
        for (int num:nums) {
           if(map.containsKey(num)){
               map.put(num,map.get(num)+1);
           }else{
               map.put(num,1);
           }
        }
        List<Integer> arr =new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                arr.add(entry.getKey());
            }
        }
        int[] result = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            result[i] = arr.get(i);
        }

        return result;
    }

    /*
     * 2433. Find The Original Array of Prefix Xor

        You are given an integer array pref of size n. Find and return the array arr of size n that satisfies:

        pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i].
        Note that ^ denotes the bitwise-xor operation.

        It can be proven that the answer is unique.
     */
        
    public int[] findArray(int[] pref) {
        int n =pref.length;
        int [] ans =new int[n];
        int xor =pref[0];
        ans[0]=pref[0];
        for(int i=1;i<pref.length;i++){
            xor =pref[i-1]^pref[i];
            ans[i]=xor;
        }
        return  ans;
    }

    /*
     * 1720. Decode XORed Array


        There is a hidden integer array arr that consists of n non-negative integers.

        It was encoded into another integer array encoded of length n - 1, such that encoded[i] = arr[i] XOR arr[i + 1]. For example, if arr = [1,0,2,1], then encoded = [1,2,3].

        You are given the encoded array. You are also given an integer first, that is the first element of arr, i.e. arr[0].

        Return the original array arr. It can be proved that the answer exists and is unique.
     */

    public int[] decode(int[] encoded, int first) {
        int n =encoded.length;
        int[] ans =new int[n+1];
        ans[0]=first;
        for(int i=0;i<n;i++){
            ans[i+1]=ans[i]^encoded[i];
        }
        return ans;
    }

    /*
     * 1442. Count Triplets That Can Form Two Arrays of Equal XOR

        Given an array of integers arr.

        We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

        Let's define a and b as follows:

        a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
        b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
        Note that ^ denotes the bitwise-xor operation.

        Return the number of triplets (i, j and k) Where a == b.
     */


    public int countTriplets(int[] arr) {
        int n=arr.length;
       int ans=0;
       for(int i=0;i<n;i++){
           int xora =0;
           for(int j=i+1;j<n;j++){
               xora =xora^arr[j-1];
               int xorb=0;
               for(int k=j;k<n;k++){
                   xorb =xorb^arr[k];
                   if(xora==xorb) ans++;
               }
           }

       }
       return  ans;
    }

    /*
     * 724. Find Pivot Index

        Given an array of integers nums, calculate the pivot index of this array.

        The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

        If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

        Return the leftmost pivot index. If no such index exists, return -1.
     */


    public int pivotIndex(int[] nums) {
        int totalSum = 0;
            for (int num : nums) {
                totalSum += num;
            }

            int leftSum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (leftSum == totalSum - leftSum - nums[i]) {
                    return i;
                }
                leftSum += nums[i];
            }
            return -1;
    }

    /*
     * 3516. Find Closest Person

        You are given three integers x, y, and z, representing the positions of three people on a number line:

        x is the position of Person 1.
        y is the position of Person 2.
        z is the position of Person 3, who does not move.
        Both Person 1 and Person 2 move toward Person 3 at the same speed.

        Determine which person reaches Person 3 first:

        Return 1 if Person 1 arrives first.
        Return 2 if Person 2 arrives first.
        Return 0 if both arrive at the same time.
        Return the result accordingly.
     */

    public int findClosest(int x, int y, int z) {
       int p1 =Math.abs(x-z);
       int p2 =Math.abs(y-z);
       if(p1>p2){
           return 2;
       }else if(p1<p2){
           return 1;
       }
       return 0;
    }

    /*
     * 71. Simplify Path

        You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

        The rules of a Unix-style file system are as follows:

        A single period '.' represents the current directory.
        A double period '..' represents the previous/parent directory.
        Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
        Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
        The simplified canonical path should follow these rules:

        The path must start with a single slash '/'.
        Directories within the path must be separated by exactly one slash '/'.
        The path must not end with a slash '/', unless it is the root directory.
        The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
        Return the simplified canonical path.
     */


    public String simplifyPath(String path) {
        String [] arr =path.split("/");
       Stack<String> stack =new Stack<>();
       for(String i :arr){
           if (i.equals("..")) {
            if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!i.equals("") && !i.equals(".") && !i.equals("..")) {
                stack.push(i);
            }
       }

       StringBuilder sb =new StringBuilder();
        for (String st: stack) {
            sb.append("/");
            sb.append(st);
        }

        return  sb.length()==0 ? "/" : sb.toString();
    }

    /*
     * 443. String Compression

        Given an array of characters chars, compress it using the following algorithm:

        Begin with an empty string s. For each group of consecutive repeating characters in chars:

        If the group's length is 1, append the character to s.
        Otherwise, append the character followed by the group's length.
        The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

        After you are done modifying the input array, return the new length of the array.

        You must write an algorithm that uses only constant extra space.
     */

    public int compress(char[] chars) {
        int n = chars.length;
      int write = 0;
      int read = 0;
  
      while (read < n) {
          int start = read;
          while (read < n && chars[read] == chars[start]) {
              read++;
          }
  
          // Write the character
          chars[write++] = chars[start];
  
          // Write the count if more than 1
          int count = read - start;
          if (count > 1) {
              for (char c : String.valueOf(count).toCharArray()) {
                  chars[write++] = c;
              }
          }
      }
  
      return write;
  
      }


    /*
     * 228. Summary Ranges

        You are given a sorted unique integer array nums.

        A range [a,b] is the set of all integers from a to b (inclusive).

        Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

        Each range [a,b] in the list should be output as:

        "a->b" if a != b
        "a" if a == b
     */
      public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();
        int index = 0;
        while (index < nums.length){
            int start = index;
            while (index + 1 < nums.length && nums[index + 1] == nums[index] + 1) {
                index++;
            }
            StringBuilder s = new StringBuilder();
            s.append(nums[start]);
            if (start != index){
                s.append("->").append(nums[index]);
            }
            output.add(s.toString());
            index++;
        }
        return output;
    }

    /*
     * 342. Power of Four

        Given an integer n, return true if it is a power of four. Otherwise, return false.

        An integer n is a power of four, if there exists an integer x such that n == 4x.
     */

    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n % 3 == 1);
    }

    /*
     * 18. 4Sum

            Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

            0 <= a, b, c, d < n
            a, b, c, and d are distinct.
            nums[a] + nums[b] + nums[c] + nums[d] == target
            You may return the answer in any order.
     */


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for left and right
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
        
    }


    /*
     * 32. Longest Valid Parentheses

        Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.


     */



    public int longestValidParentheses(String s) {
        int maxLen = 0;
        int open = 0, close = 0;

        // Left to right pass
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                maxLen = Math.max(maxLen, 2 * close);
            } else if (close > open) {
                open = close = 0; // reset
            }
        }

        open = close = 0;

        // Right to left pass
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                open = close = 0; // reset
            }
        }

        return maxLen;
    }

    /*
     * Q1. Calculate Score After Performing Instructions

        You are given two arrays, instructions and values, both of size n.

        You need to simulate a process based on the following rules:

        You start at the first instruction at index i = 0 with an initial score of 0.
        If instructions[i] is "add":
        Add values[i] to your score.
        Move to the next instruction (i + 1).
        If instructions[i] is "jump":
        Move to the instruction at index (i + values[i]) without modifying your score.
        The process ends when you either:

        Go out of bounds (i.e., i < 0 or i >= n), or
        Attempt to revisit an instruction that has been previously executed. The revisited instruction is not executed.
        Return your score at the end of the process.
     */


    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int i = 0;
        int n = instructions.length;
        boolean[] visited = new boolean[n];

        while (i >= 0 && i < n && !visited[i]) {
            visited[i] = true;

            if (instructions[i].equals("add")) {
                score += values[i];
                i++; // move to next instruction
            } else if (instructions[i].equals("jump")) {
                i += values[i]; // jump to i + values[i]
            } else {
                // Optional: handle invalid instruction
                break;
            }
        }

        return score;
    }

    /*
     * 59. Spiral Matrix II

        Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     */


    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];

        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;

        while (top <= bottom && left <= right) {
            // Left to right
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            top++;

            // Top to bottom
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            right--;

            // Right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = num++;
                }
                bottom--;
            }

            // Bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = num++;
                }
                left++;
            }
        }

        return ans;
    }

    /*
     * 38. Count and Say

        The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

        countAndSay(1) = "1"
        countAndSay(n) is the run-length encoding of countAndSay(n - 1).
        Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

        Given a positive integer n, return the nth element of the count-and-say sequence.
     */


    public String countAndSay(int n) {
        String st ="1";
        for(int i=1;i<n;i++){
            char[] arr =st.toCharArray();
            StringBuilder sb =new StringBuilder();
            int p1=0;
            int p2 =0;
            int n1 =arr.length;
            while (p2<n1){
                if(arr[p1] != arr[p2]){
                    int count =p2-p1;
                    sb.append(count);
                    sb.append(arr[p1]);
                    p1=p2;
                }else {
                    p2++;
                }
            }
            if (p1 < n1) {
                sb.append(p2 - p1);
                sb.append(arr[p1]);
            }
            st = sb.toString();

        }
        return  st;
    }

    public String countAndSay2(int n) {
        if (n == 1) return "1";

        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < prev.length()) {
            int count = 1;
            while (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
                i++;
            }
            res.append(count).append(prev.charAt(i));
            i++;
        }

        return res.toString();
    }

    /*
     * 82. Remove Duplicates from Sorted List II

        Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
     */


    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr =head;
        ListNode prev =null;
        while(curr !=null){
            if(curr.next !=null && curr.val ==curr.next.val){
                int val =curr.val;
                while ((curr !=null && curr.val==val)) {
                    curr =curr.next;
                }
                if(prev != null){
                   prev.next =curr;
                }else{
                    head=curr;
                }
            }else{
                prev =curr;
                curr =curr.next;
            }
        }
        return head; 
    }

    /*
     * 2799. Count Complete Subarrays in an Array

        You are given an array nums consisting of positive integers.

        We call a subarray of an array complete if the following condition is satisfied:

        The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
        Return the number of complete subarrays.

        A subarray is a contiguous non-empty part of an array.
     */


     public int countCompleteSubarrays(int[] nums) {
        int n =nums.length;
        int ans=0;
        HashSet<Integer> set =new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }
        HashMap<Integer, Integer> map =new HashMap<>();
        int st =0;
        int end =0;
        int k =set.size();
        while (end<n){
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            while (map.size()==k){
                ans +=n-end;
                map.put(nums[st],map.get(nums[st])-1);
                if(map.get(nums[st])==0){
                    map.remove(nums[st]);
                }
                st++;
            }
            end++;
        }
        return ans;
    }

    /*
     * 89. Gray Code

        An n-bit gray code sequence is a sequence of 2n integers where:

        Every integer is in the inclusive range [0, 2n - 1],
        The first integer is 0,
        An integer appears no more than once in the sequence,
        The binary representation of every pair of adjacent integers differs by exactly one bit, and
        The binary representation of the first and last integers differs by exactly one bit.
        Given an integer n, return any valid n-bit gray code sequence.
     */


    public List<Integer> grayCode(int n) {
        List<Integer> list =new ArrayList<>();
        list.add(0);
        if(n==0) return list;
        list.add(1);
        int cur =1;
        for(int i=2;i<=n;i++){
           cur *=2;
           for(int j=list.size()-1;j>=0;j--){
               list.add(cur+list.get(j));
           }
        }
        return list; 
    }

    /*
     Q1. Find the Most Common Response

        You are given a 2D string array responses where each responses[i] is an array of strings representing survey responses from the ith day.

        Return the most common response across all days after removing duplicate responses within each responses[i]. If there is a tie, return the lexicographically smallest response.

        A string a is lexicographically smaller than a string b if in the first position where a and b differ, string a has a letter that appears earlier in the alphabet than the corresponding letter in b.
        If the first min(a.length, b.length) characters do not differ, then the shorter string is the lexicographically smaller one.
     */


    public String findCommonResponse(List<List<String>> responses) {
        List<HashSet<String>> arr = new ArrayList<>();
        for (List<String> response : responses) {
            arr.add(new HashSet<>(response));
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (HashSet<String> set : arr) {
            for (String st : set) {
                map.put(st, map.getOrDefault(st, 0) + 1);
            }
        }

        String ans = "";
        int max_val = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max_val) {
                max_val = entry.getValue();
                ans = entry.getKey();
            } else if (entry.getValue() == max_val) {
                if (ans.equals("") || entry.getKey().compareTo(ans) < 0) {
                    ans = entry.getKey();
                }
            }
        }

        return ans;
    }

    /*
     * Q2. Unit Conversion I

        There are n types of units indexed from 0 to n - 1. You are given a 2D integer array conversions of length n - 1, where conversions[i] = [sourceUniti, targetUniti, conversionFactori]. This indicates that a single unit of type sourceUniti is equivalent to conversionFactori units of type targetUniti.

        Return an array baseUnitConversion of length n, where baseUnitConversion[i] is the number of units of type i equivalent to a single unit of type 0. Since the answer may be large, return each baseUnitConversion[i] modulo 109 + 7.
     */


    static final int MOD = 1_000_000_007;
    
    public int[] baseUnitConversions(int[][] conversions) {
        int n = conversions.length + 1;
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int[] conv : conversions) {
            int u = conv[0], v = conv[1], factor = conv[2];
            graph.get(u).add(new int[]{v, factor});
            graph.get(v).add(new int[]{u, -factor});  // Negative factor to indicate "reverse" direction
        }
        
        int[] ans = new int[n];
        boolean[] visited = new boolean[n];
        
        ans[0] = 1;
        dfs(0, graph, ans, visited);
        
        for (int i = 0; i < n; i++) {
            ans[i] = (ans[i] % MOD + MOD) % MOD;
        }
        
        return ans;
    }

    private void dfs(int node, List<List<int[]>> graph, int[] ans, boolean[] visited) {
        visited[node] = true;
        for (int[] next : graph.get(node)) {
            int neighbor = next[0];
            int factor = next[1];
            if (!visited[neighbor]) {
                if (factor > 0) {
                    ans[neighbor] = (int)((1L * ans[node] * factor) % MOD);
                } else {
                    ans[neighbor] = (int)((1L * ans[node] * modInverse(-factor, MOD)) % MOD);
                }
                dfs(neighbor, graph, ans, visited);
            }
        }
    }
    
    private int modInverse(int a, int mod) {
        return pow(a, mod - 2, mod);
    }
    
    private int pow(int a, int b, int mod) {
        int result = 1;
        while (b > 0) {
            if ((b & 1) == 1) result = (int)((1L * result * a) % mod);
            a = (int)((1L * a * a) % mod);
            b >>= 1;
        }
        return result;
    }


    /*
     * 3531. Count Covered Buildings

        You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].

        A building is covered if there is at least one building in all four directions: left, right, above, and below.

        Return the number of covered buildings.
     */
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();

        // Build rowMap and colMap
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            rowMap.putIfAbsent(x, new TreeSet<>());
            rowMap.get(x).add(y);

            colMap.putIfAbsent(y, new TreeSet<>());
            colMap.get(y).add(x);
        }

        int count = 0;

        // Check each building
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            boolean hasLeft = false, hasRight = false, hasUp = false, hasDown = false;

            // Check left and right in row
            TreeSet<Integer> rowSet = rowMap.get(x);
            if (rowSet.lower(y) != null) hasLeft = true;
            if (rowSet.higher(y) != null) hasRight = true;

            // Check up and down in column
            TreeSet<Integer> colSet = colMap.get(y);
            if (colSet.lower(x) != null) hasUp = true;
            if (colSet.higher(x) != null) hasDown = true;

            if (hasLeft && hasRight && hasUp && hasDown) {
                count++;
            }
        }

        return count;
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
