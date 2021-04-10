package com.lyf.dynamic;

/**
 * @ClassName Bage
 * @Author Kurisu
 * @Description
 * @Date 2021-3-25 15:13
 * @Version 1.0
 **/
public class Bag{
    public static void main(String[] args) {
        int[] w = {0,1, 4, 3};//物品的重量
        int[] val = {0,1500, 3000, 2000}; //物品的价值 这里val[i] 就是前面讲的v[i]
        int n = 3; //物品的个数
        int m = 4; //背包的容量

        //创建二维数组，
        //v[i][j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        //消除数组从0开始的差异 需要第0行和第0列补齐，所以创建表格需要多创建一行一列
        int[][] v = new int[n+1][m+1];

        //TODO 1.初始化第一行和第一列, 本程序可以不去处理，因为默认就是0

        //TODO 2.使用状态转移方程推算
        for(int i = 1;i< n+1;i++){
            for (int j = 1; j < m+1; j++) {
                if(w[i] > j){
                    //当前物品重量大于背包承重
                    v[i][j] = v[i-1][j];
                }else{
                    //当前物品重量小于背包承重
                    v[i][j] = Math.max(v[i-1][j],val[i]+v[i-1][j-w[i]]);
                }

            }
        }


        //输出一下v 看看目前的情况
        for(int i =0; i < v.length;i++) {
            for(int j = 0; j < v[i].length;j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

    }
}
