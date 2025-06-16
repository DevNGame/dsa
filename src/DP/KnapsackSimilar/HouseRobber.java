package DP.KnapsackSimilar;

public class HouseRobber {

    static int calculate(int[] nums){
        int len = nums.length; //3
        int[] dp= new int[len+1];
        dp[0] = Math.max(0, nums[0]);
        dp[1] = Math.max(dp[0], nums[0]);
        for(int i=1;i<len;i++){
            dp[i+1] = Math.max(
                    dp[i], nums[i] + dp[i-1]
            );
        }
        return dp[len];

    }
    public static void main(String... a) {
        int[] nums = {2,3,2};
        int sum = calculate(nums);
        System.out.println("Max sum: " + sum);
    }
}
