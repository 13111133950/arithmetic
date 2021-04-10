package com.lyf.recursion;

import sun.security.util.AuthResources_it;

import java.util.Random;

/**
 * @ClassName MiGong
 * @Author Kurisu
 * @Description
 * @Date 2021-3-25 13:12
 * @Version 1.0
 **/
public class MiGong {
    private static int[][] map;
    static int row;
    static int col;

    public static void main(String[] args) {
        //生成迷宫
        getNewMap(7, 8);
        //使用递归回溯 走迷宫
        go(1, 1);
        //输出路线图
        outPutMap();
    }

    private static boolean go(int x, int y) {

        if (map[row - 2][col - 2] == 2) {
            System.out.println("已找到通路");
            return true;
        } else {
            if (map[x][y] == 0) {
                //先假设 map[x][y] = 2
                map[x][y] = 2;
                //下
                if (go(x + 1, y)) {
                    return true;
                    //右
                } else if ( go(x, y + 1)) {
                    return true;
                    //上
                } else if (go(x - 1, y)) {
                    return true;
                    //左
                } else if (go(x, y - 1)) {
                    return true;
                } else {
                    //未进入其他分支代表是死路
                    map[x][y] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    private static void outPutMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void getNewMap(int row, int col) {
        map = new int[row][col];
        MiGong.row = row;
        MiGong.col = col;
        for (int i = 0; i < row; i++) {
            map[i][0] = 1;
            map[i][col - 1] = 1;
        }

        for (int j = 0; j < col; j++) {
            map[0][j] = 1;
            map[row - 1][j] = 1;
        }

        //手动生成障碍
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            map[r.nextInt(row - 2) + 1][r.nextInt(col - 2) + 1] = 1;
        }
        map[1][1] = 0;
        map[row - 2][col - 2] = 0;
        //模拟死路
//        map[3][1] = 1;
//        map[2][2] = 1;
//        map[2][3] = 1;
//        map[1][4] = 1;
    }
}
