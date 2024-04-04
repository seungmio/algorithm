package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
최대 수익을 구해야 하는데,
시간 복잡도가 널널하므로 완전탐색 중 dfs로 풀 예정

N+1일째 되는 날 퇴사
상담을 완료하는데 걸리는 기간 Ti와 상담을 했을 때 받을 수 있는 금액 Pi

idx 0~N-1까지 탐색하는데, idx가 N보다 커지면 탐색 종료
(idx+arr[idx][0]//날짜) <= (N-1) 이면 profit+=arr[idx][1], dfs(idx+arr[idx][0])
else 면
 */
public class BJ2024040114501 {
    static int N; //각각 퇴사남은 날, 걸리는 기간, 받는 금액
    static int[][] arr;
    static int result = 0;
    static void dfs(int idx, int profit) {
        if (idx >= N) {
            result = Math.max(result, profit);  //이 부분 참고함..
            return;
        }

        //  0+arr[0][0]5                    5                   50
        //  5+arr[5][0]1                    6                   60
        //  6+arr[6][0]2                    8                   80
        //  8+arr[8][0]4
        if (idx+arr[idx][0] <= N) dfs(idx+arr[idx][0], profit+arr[idx][1]); //상담을 진행하는 경우

        dfs(idx+1, profit); //상담을 진행하지 않는 경우
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(result);
    }
}
