package Solution;

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
}
