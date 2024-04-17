package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ202404172458 {
    /*
    1번 학생을 기준으로,
    1 -> 5 cnt[1]++, cnt[5]++
    5 -> 4/2 cnt[1]++, cnt[4]++ / cnt[1]++, cnt[2]++    //1번 학생이 기준으로 1번 학생은 본인보다 키 큰 학생을 1명 더 알 수 있고, 2/4번 학생은 1번 학생이 본인보다 작기 때문에 +1
    2 -> X
    4 -> 6 cnt[1]++, cnt[6]++

    결과적으로 1번 학생은 자신보다 키 큰 사람을 4명 알 수 있다.
    1~N번까지 반복하고 나면 각 학생은 자신보다 키 큰 사람+자신보다 키가 작은 사람 = N-1 을 알 수 있다.

    map[1,5] = 1, map[3,4] = 1, map[5,4] = 1, map[4,2] = 1, map[4,6] = 1, map[5,2] = 1

    (1, 5) 방문 -> cnt[1]++, cnt[5]++
    (5, 4) / (5, 2) 방문 ->  cnt[1]++, cnt[4]++ / cnt[1]++, cnt[2]++
    (4, 2) 방문 <- 문제!!!
    (4, 6) 방문 -> cnt[1]++, cnt[6]++

     */
    static int N, M, result;
    static int[] cnt;
    static int[][] info;
    static boolean[] isVisited;
    static void dfs(int start, int now) {
        /*
        start=1, now=1, isvisited[1] = true
        info[1][5] == 1 -> dfs(1, 5)

        start=1, now=5 isvisited[5] = true
        info[5][2] == 1 -> dfs(1, 2)
         */
        if (start != now) { //자기자신은 제외
            cnt[start]++;
            cnt[now]++;
        }

        isVisited[now] = true;

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i] && info[now][i] == 1) { //아직 방문하지 않고 나보다 키가 큰 경우
//                System.out.println(start + " " + now);
                dfs(start, i);
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cnt = new int[N+1];
        info = new int[N+1][N+1];
        isVisited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a->b : b가 a보다 키가 크다는 의미
            info[a][b] = 1;
        }

        for (int i = 1; i <= N; i++) {
            isVisited = new boolean[N+1];   //방문 전체 초기화
//            System.out.println(i);
            dfs(i, i);
        }

        for (int num: cnt) {
            if (num == N-1) result++;
        }

        System.out.println(result);
    }
}
