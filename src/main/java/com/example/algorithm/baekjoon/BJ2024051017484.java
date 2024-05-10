package com.example.algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2024051017484 {
    static int N, M;
    static int[][] map;
    static int[] dx = {1, 1, 1};   //왼쪽 아래 대각선, 아래, 오른쪽 아래 대각선
    static int[] dy = {-1, 0, 1};
    static int min = Integer.MAX_VALUE;
    static void dfs(int x, int y, int dir, int sum) {   //행, 열, 방향, 합계
        if (x == N) {   //달에 착륙
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (dir == i) continue; //전과 같은 방향이면 건너뜀

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (ny >= 0 && ny < M) {
                dfs(nx, ny, i, sum + map[x][y]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            dfs(0, i, -1, 0);
        }

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}
