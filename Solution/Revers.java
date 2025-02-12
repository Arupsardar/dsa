package Solution;

import java.util.HashSet;

public class Revers {

    /*
     345. Reverse Vowels of a String

        Given a string s, reverse only all the vowels in the string and return it.

        The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
     */
    public String reverseVowels(String s) {
        HashSet<Character> set =new HashSet<>();
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        char [] arr =s.toCharArray();
        int i=0;
        int j=arr.length-1;
        while (i<=j) {
            if(set.contains(arr[i]) && set.contains(arr[j]) ){
                char temp =arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;

            }else if(set.contains(arr[i]) && !set.contains(arr[j])){
               j--;
            }else{
                i++;
            }
        }
        String str = new String(arr);
        return str;

        
    }

    /*
     541. Reverse String II

        Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

        If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
     */

    public String reverseStr(String s, int k) {
        char [] arr =s.toCharArray();
        for(int j=0;j<s.length();j=j+2*k){
            int end = Math.min(j + k - 1, arr.length - 1); 
            for (int i = 0; i < (end - j + 1) / 2; i++) {
                    char temp = arr[j + i];
                    arr[j + i] = arr[end - i];
                    arr[end - i] = temp;
                }
        }
        
        return new String(arr);
    }

    /*
     * 557. Reverse Words in a String III

        Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     */


    public String reverseWords(String s) {
        String [] arr =s.split(" ");
        String ans ="";
         for(int i=0;i<arr.length;i++){
             char[] chaarr =arr[i].toCharArray();
             int n =chaarr.length;
             for(int j=0;j<n/2;j++){
                 char temp =chaarr[j];
                 chaarr[j]=chaarr[n-j-1];
                 chaarr[n-j-1] =temp;
             }
             arr[i]=new String(chaarr);
 
             ans =ans+arr[i];
             if(i !=arr.length -1){
                 ans =ans+" ";
             }
         }
         return ans;  
     }

     /*
      202. Happy Number

            Write an algorithm to determine if a number n is happy.

            A happy number is a number defined by the following process:

            Starting with any positive integer, replace the number by the sum of the squares of its digits.
            Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
            Those numbers for which this process ends in 1 are happy.
            Return true if n is a happy number, and false if not.
      */

     public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = getNext(slow);       // Move one step
            fast = getNext(getNext(fast)); // Move two steps

            if (fast == 1) return true; // If 1 is reached, it's happy
        } while (slow != fast); // Detect cycle

        return false;
    }

    private int getNext(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    
}
