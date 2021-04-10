package com.lyf.dynamic;

/**
 * @ClassName GuPiao
 * @Author Kurisu
 * @Description
 * @Date 2021-3-25 16:26
 * @Version 1.0
 **/
public class GuPiao {
    public static void main(String[] args) {
//        dp[i][0] 表示第 i 天不持有可获得的最大利润；
//        dp[i][1]表示第 i 天持有可获得的最大利润（注意是第 i 天持有，而不是第 i 天买入）。
        int[] price = {7, 1, 5, 3, 6, 4};
        int[][] dp = new int[7][2];
        //初始化
        dp[1][1] = -7;
        //状态转义方程
        for (int i = 2; i < price.length+1; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+price[i-1]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-price[i-1]);
        }
        System.out.println(dp[6][0]);
        System.out.println("--------------------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+"   ");

            }
            System.out.println();

        }
    }
}
