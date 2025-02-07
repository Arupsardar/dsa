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
}
