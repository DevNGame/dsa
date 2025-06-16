package DP.KnapsackSimilar;

public class Knapsack {

    static int getMaxRecursion(int[] wt, int[] val, int W, int idx){
        if(idx < 0 || W <= 0){
            return 0;
        }
        else{
            int take = 0, notTake = 0;
            //choose weight
            if(wt[idx] <= W){
               take = val[idx] + getMaxRecursion(wt, val, W - wt[idx], idx - 1) ;
            }
            else{
                notTake = getMaxRecursion(wt, val, W, idx - 1);
            }
            return Math.max(take, notTake);
        }
    }


    static int getMaxDP(int[] wt, int[] val, int W, int idx, int[][] dp){
        if(idx < 0 || W <= 0){
            return 0;
        }
        else{
            if(dp[idx][W] != 0){
                return dp[idx][W];
            }
            int take = 0, notTake = 0;
            //choose weight
            if(wt[idx] <= W){
                take = val[idx] + getMaxDP(wt, val, W - wt[idx], idx - 1, dp) ;
            }
            else{
                notTake = getMaxDP(wt, val, W, idx - 1, dp);
            }
            dp[idx][W] = Math.max(take, notTake);
            return dp[idx][W];
        }
    }

    static int getMaxDPTopDown(int[] wt, int[] val, int W, int[][] dp) {
        int n = wt.length +1;
        int m = W + 1;
        for(int i=1; i<n;i++){
            for(int j=1; j<m;j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(
                            val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]
                    );
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][m-1];
    }

    static int getMaxValue(int[] wt, int[] val, int W){
        int[][] dp = new int[wt.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }
        return getMaxDPTopDown(wt, val, W, dp);
    }

    public static void main(String args[]){
        int[] wt= new int[]{1,2,1,4,2,3,2,3,1};
        int[] val= new int[]{4,1,4,1,1,2,3,1,4};
        int W = 6;
        int knapsack = getMaxValue(wt, val, W);
        System.out.println(knapsack);
    }
}
