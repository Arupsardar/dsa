package Solution;

public class ButtonwithLongestPushTime {
    public int buttonWithLongestTime(int[][] events) {
        int maxTime = events[0][1]; 
        int result = events[0][0];

        
        for (int i = 1; i < events.length; i++) {
           
            int pushTime = events[i][1] - events[i - 1][1];

           
            if (pushTime > maxTime) {
                maxTime = pushTime;
                result = events[i][0];
            } 
            
            else if (pushTime == maxTime) {
                result = Math.min(result, events[i][0]);
            }
        }

        return result;
    }
}
