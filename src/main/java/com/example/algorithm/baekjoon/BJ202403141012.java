package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로
서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다. => 배추가 인접해있는지 판단하는 식 필요

입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
그 다음 줄부터 각각의 테스트 케이스에 대해 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다. 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
두 배추의 위치가 같은 경우는 없다.

2 테스트 케이스 개수
10 8 17 가로 세로 배추위치

1. [M][N] 2차원 배열(배추 위치) 0 초기화, x/y 초기화
2. M, N 2중 for문으로 각 배추 위치 1로 변경
3. M, N 2중 for문으로 만약 배추가 있는 위치이면 상하좌우 탐색해서 인접한 곳에 배추가 있는지 탐색


배추가 인접해있는지 판단하려면,
x = { -1, 1, 0, 0 }
y = { 0, 0, -1, 1 }
 */
public class BJ202403141012 {
    static int T, M, N, K;

    static int map[][];
    static boolean visit[][];

    static int bug = 0;

    static ArrayList<Integer> result = new ArrayList<Integer>();

    static void dfs(int a, int b) {
        visit[a][b] = true; //방문 표시

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        /*
        a=2 b=2
        visit[1][2] false -> visit[1][2] true

        map[1][2] == 1, bug = 1
        map[3][2] == 1, bug = 1
        ..

        a=3 b=1
         */
        for (int i = 0; i < 4; i++) {
            int nx = a + dx[i];
            int ny = b + dy[i];

            if ((nx >= 0) && (ny < N) && (nx < M) && (ny >= 0)) {

                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visit = new boolean[M][N];

            bug = 0;

            for (int j = 0; j < K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                map[a][b] = 1;
            }

//            만약 배추가 있는 위치이면 상하좌우 탐색해서 인접한 곳에 배추가 있는지 탐색
            /*
            m = 3 n = 3
            [2][2]
             */
            for (int m = 0; m < M; m++) {
                for (int n = 0; n < N; n++) {
                    if (map[m][n] == 1 && !visit[m][n]) {
                        dfs(m, n);
                        bug++;
                    }
                }
            }
            result.add(bug);
        }

        for (int i: result) {
            System.out.println(i);
        }
    }
}
