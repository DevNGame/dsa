package DP;

public class LavenshteinDistance {

    public static int lavenshteinDistance(char[] a, char[] b){
        //a = {abcd}
        //b= {abcf}
        int al = a.length;
        int bl = b.length;

        /*
        * dp=   0 0 0 0
        *       0 0 0 0
        *       0 0 0 0
        *       0 0 0 0
        * */


        int[][] dp = new int[al+1][bl+1];


        for(int i=0; i<=al;i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=bl;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<al;i++){
            for(int j=1;j<bl;j++){
                if(a[i] == b[j]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(Math.min(
                            dp[i-1][j], dp[i][j-1]
                    ), dp[i-1][j-1]) +1;
                }
            }
        }
        return dp[al-1][bl-1];
    }

    public static void main(String[] args)
    {
        String a ="xyz";
        String b ="xyc";

        int distance = lavenshteinDistance(a.toCharArray(),b.toCharArray());
        System.out.println("Distance: " + distance);
    }
}
