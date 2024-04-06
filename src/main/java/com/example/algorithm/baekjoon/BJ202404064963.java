package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
가로, 세로, 대각선으로 갈 수 있음
//왼, 오, 아래, 위, 오른쪽위, 오른쪽아래, 왼쪽위, 왼쪽아래
int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1}
int[] dy = {0, 0, -1, 1, 1, -1, 1, -1}
 */
public class BJ202404064963 {
    static int w, h;    //열, 행
    static int[][] map;
    static boolean[][] isVisited;
    static int cnt; //섬의 개수
    static void dfs(int x, int y) {
        isVisited[x][y] = true;

        int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
        int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //w:3 h:2
            if ((nx >= 0) && (nx < h) && (ny >= 0) && (ny < w) && !isVisited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if ((w == 0) && (h == 0)) break;    //입력이 끝나는 조건 판단
            else {
                map = new int[h][w];    //[2][3]    2행 3열
                isVisited = new boolean[h][w];
                for (int i = 0; i < h; i++) {
                    st = new StringTokenizer(br.readLine());
                    for (int j = 0; j < w; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }

                /*
                w:3 h:2
                1 1 1
                1 1 1
                 */
                cnt = 0;
                for (int i = 0; i < h; i++) {   //0, 1
                    for (int j = 0; j < w; j++) {   //0, 1, 2
                        if (!isVisited[i][j] && map[i][j] == 1) {
                            dfs(i, j);
                            cnt++;
                        }
                    }
                }

                System.out.println(cnt);
            }
        }
    }
}
