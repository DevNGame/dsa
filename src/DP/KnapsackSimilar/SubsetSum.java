package DP.KnapsackSimilar;

public class SubsetSum {

    static boolean getMaxValue(int[] arr, int sum){
        int n = arr.length + 1;
        int m = sum + 1;
        boolean[][] dp = new boolean[n][m];
        for(int j=0;j<n;j++)
            dp[j][0] = true;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n-1][m-1];
    }

    /**
     *
     * Given an array arr[] of size n and sum, determine if there is a subset of the array
     *
     * Solution: For each 0..sum, check if the subset sum exists.
     *
     * to calculate for whole array, find the sum which is true for each arr[n-1]
     *
     *example: arr = {3, 5, 2}, sum = 8
     * dp array initially will look like this:
     * * dp =    0 1 2 3 4 5 6 7 8
     * * arr = 0 T F F F F F F F
     * * arr = 1 T F F F F F F F
     * * arr = 2 T F F F F F F F
     * * arr = 3 T F F F F F F F
     *
     * we calculate for dp[i][j] to see if we can form sum j using first i elements of arr.
     * if we can, then dp[i][j] will be true, else false.
     * The final answer will be in dp[n-1][sum] where n is the length of the array.
     *
     * @param args
     */
    public static void main(String args[]){
        int[] arr= new int[]{3, 5, 2};
        int sum = 8;
        boolean knapsack = getMaxValue(arr, sum);
        System.out.println(knapsack);
    }
}
