package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
N이 90자리까지 가능하므로 long type에 담아야 함.
완전탐색으로 풀 경우 2^90이므로 불가능 => dp
 */
public class BJ202404062193 {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N+1];

        /*
        이친수는 0으로 시작하지 않기 때문에 1만 가능 dp[0] = 0로 고정
        이친수는 1이 두 번 연속으로 나타나지 않기 때문에 0만 가능 dp[1] = 1으로 고정
         */
        dp[0] = 0;
        dp[1] = 1;

        /*
        0이 나오면 뒤에 0, 1이 올 수 있음
        1이 나오면 뒤에 0만 올 수 있음

        dp[3] = {1 0 0}
        dp[2] = dp[0] + dp[1] = 1
        dp[3] = dp[1] + dp[2] = 2
         */
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[N]);
    }
}
