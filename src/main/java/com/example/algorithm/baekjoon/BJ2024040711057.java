package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
10^8~10^9

10^3 => 3중 for까지 가능
 */
public class BJ2024040711057 {
    static int N;
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][10];
        //N = 1인 경우 초기화
        for (int i = 0; i < 10; i++) {
            arr[0][i] = 1;
        }

        /*
        인접한 수가 같아도 오름차순
        첫 번째 수는 0~9: 10
        두 번째 수는 첫 번째 수가 0이면 0~9: 10
                              1이면 1~9: 9
                              2이면 2~9: 8
                              ...
        N 0 1 2 3 4 5 6 7 8 9
        1 1 1 1 1 1 1 1 1 1 1  => 10
        2 109 8 7 6 5 4 3 2 1  => 55
        3

        dp[3][0] = dp[2][0]+dp[2][1]+...dp[2][9]
        dp[3][1] = dp[2][1]+dp[2][2]+...dp[2][9]
         */
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    arr[i][j] += arr[i-1][k];
                    arr[i][j] %= 10007;
                    /*
                    arr[1][0] = arr[0][0] + arr[0][1]+...

                     */
                }
            }
        }
        System.out.println(arr[N][0]);
    }
}
