package Solution;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        String trimmedInput = s.trim();
       
        s = trimmedInput.replaceAll("\\s+", " ");
        String arr[] = s.split(" ");
        
        return arr[arr.length-1].length();
    }
}
