package Solution;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        String [] ans=new String[numRows];
        int n =s.length();
        for(int i=0;i<numRows;i++){
            ans[i]="";
        }
        int i=0;
        while(i<n){
            for(int index=0;index<numRows && i<n;index++){
                
                ans[index] +=s.charAt(i++);

            }
            for(int index=numRows-2;index>0&& i<n;index--){
                ans[index] +=s.charAt(i++);
            }
        }
        String as="";
        for(int j=0;i<numRows;j++){
            as +=ans[j];
        }
        return as;
        
    }
}
