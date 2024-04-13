package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
테트로미노 모양 중 (ㅗ)모양을 제외하면 {-1, 1, 0, 0} / {0, 0, -1, 1} 로 모든 모양이 나오게 됨.
 */
public class BJ2024041314500 {
    static int[][] map;
    static boolean[][] isVisited;
    static int N, M;
    static int result;
    static void dfs(int a, int b, int max, int cnt) {
        if (cnt == 4) {
            result = Math.max(max, result);
            return;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + a;
            int ny = dy[i] + b;

            if ((nx >= 0) && (nx < N) && (ny >= 0) && (ny < M) && !isVisited[nx][ny]) { //ㅗ 모양 제외하고 탐색 다함..
                if (cnt == 2) { //ㅗ 모양을 위해서 2번째 칸일 때 탐색 한번 더
                    isVisited[nx][ny] = true;
                    dfs(a, b, max + map[nx][ny], cnt + 1);
                    isVisited[nx][ny] = false;
                }

                isVisited[nx][ny] = true;
                dfs(nx, ny, max + map[nx][ny], cnt + 1);
                isVisited[nx][ny] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                isVisited[i][j] = false;
            }
        }

        System.out.println(result);
    }
}
