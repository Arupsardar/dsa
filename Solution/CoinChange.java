package Solution;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if(amount<1){
            return 0;
        }
        int[] coindp = new int[amount+1];
        for(int i=1;i<= amount;i++){
            coindp[i]=Integer.MAX_VALUE;
            for(int coin: coins){
                if(coin<=i && coindp[i-coin] !=Integer.MAX_VALUE){
                    coindp[i]=Math.min(coindp[i], 1+coindp[i-coin]);
                }
            }
        }

        if(coindp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return coindp[amount];
    }

    

    

   
}
