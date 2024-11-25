package Solution;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        // Frequency map for characters in t
        HashMap<Character, Integer> requiredChars = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredChars.put(c, requiredChars.getOrDefault(c, 0) + 1);
        }
        
        // Sliding window variables
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0;
        int required = requiredChars.size();
        int formed = 0;
        
        // Result variables: [minLength, left, right]
        int[] result = {-1, 0, 0};  // Initialize with -1 for no valid window
        
        // Expand the window with the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            
            // Check if the current character meets the required count
            if (requiredChars.containsKey(c) && windowCounts.get(c).intValue() == requiredChars.get(c).intValue()) {
                formed++;
            }
            
            // Contract the window from the left to find the smallest valid window
            while (left <= right && formed == required) {
                char charAtLeft = s.charAt(left);
                
                // Update the result if this window is smaller
                if (result[0] == -1 || right - left + 1 < result[0]) {
                    result[0] = right - left + 1;
                    result[1] = left;
                    result[2] = right;
                }
                
                // Remove the character at the left pointer
                windowCounts.put(charAtLeft, windowCounts.get(charAtLeft) - 1);
                if (requiredChars.containsKey(charAtLeft) && windowCounts.get(charAtLeft).intValue() < requiredChars.get(charAtLeft).intValue()) {
                    formed--;
                }
                
                left++;  // Shrink the window
            }
            
            right++;  // Expand the window
        }
        
        // Return the minimum window or empty string if no valid window exists
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
        
    }
}
