package DP.knapsack_similar;

public class MinimumSubsetSumDiff {

    static boolean[] getMaxValue(int[] arr, int range){
        int n = arr.length+1;
        int m = range + 1;
        boolean[][] dp = new boolean[n][m];
        //init
        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }
        for(int i=1;i<n;i++){
            for(int j=1; j<m;j++){
                if(arr[i-1] <= j)
                    dp[i][j] =  dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n-1];
    }

    /**
     *
     * Given an array arr[] of size n, absolute difference(Sigma(S1) , Sigma(S2)) is minimum.
     *
     * Solution: Find the range in which sum can lie which would be 0..sum(arr)
     * for each number 0 .. sum, find subset sum of arr.
     *
     * idea is to find the S1 and calculate S2 = range-S1
     *to minimize S2-S1, minimize (range-S1) - S1
     * minimize range - 2*S1
     *
     * @param args
     */
    public static void main(String args[]){
        int[] arr= new int[]{1, 34, 20}; // n =5
        int range = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
            range = range + arr[i];
        boolean[] knapsack = getMaxValue(arr, range);
        for(int i=0;i<=Math.floor(range/2);i++){
            if(knapsack[i] == true)
                res = Math.min((range-2*i), res);
        }
        System.out.println(res);
    }

}
