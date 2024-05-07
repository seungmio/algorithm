package com.example.algorithm.baekjoon;

import java.io.*;

/*
순수 재귀로 풀 경우, 1/2/3 을 빼고 남은 수를 재귀적으로 호출해야 하기 때문에 최악의 시간복잡도는 3^10000 -> 시간초과
따라서 dp 문제에 해당
 */
public class BJ2024050715989 {
    static int T;   //테스트케이스 개수
    static int n;   //각 정수
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        dp = new int[10001][4];

        /*
        수식은 오름차순이 아니면 중복되는 경우가 생김

        4를 만들 때, 1로 끝나는 식은 3을 1로 만든 식에서 +1을 해주는 것이다.
        즉, dp[4][1] = dp[3][1] / dp[n][1] = dp[n-1][1]

        4를 만들 때, 2로 끝나는 식은 2를 1로 만든 식과 2를 2로 만든 식에서 +2를 해주는 것이다.
        즉, dp[4][2] = dp[2][1] + dp[2][2] / dp[n][2] = dp[n-2][1] + dp[n-2][2]

        4를 만들 때, 3으로 끝나는 식은 1을 1로 만든 식에서 +3을 해주는 것이다.
        (5/6 을 만들 때도 생각해 보면 아래 식이 나온다.)
        즉, dp[4][3] = dp[1][1] + dp[1][2] + dp[1][3] / dp[n][3] = dp[n-3][1] + dp[n-3][2] + dp[n-3][3]
         */

        dp[1][1] = 1;   //1
        dp[2][1] = 1;   //1+1
        dp[2][2] = 1;   //2
        dp[3][1] = 1;   //1+1+1
        dp[3][2] = 1;   //1+2
        dp[3][3] = 1;   //3

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[n][1]+dp[n][2]+dp[n][3] + "\n"));
        }

        bw.flush();
        bw.close();
    }
}
