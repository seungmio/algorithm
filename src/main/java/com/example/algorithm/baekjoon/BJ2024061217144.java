package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2024061217144 {
    static int R, C, T;
    static int[][] map;
    static int idx;    //공기청정기 위치

    //미세먼지 확산 방향
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
//    static int[] up = {1, -1, 0, 0}, side = {0, 0, 1, -1};

    static int[][] dust() { //퍼져나가는 미세먼지
        int[][] tmp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    tmp[i][j] = -1;
                    continue;
                }

                tmp[i][j] += map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                        if (map[nx][ny] != -1) {

                            tmp[nx][ny] += (map[i][j] / 5);
                            tmp[i][j] -= (map[i][j] / 5);
                        }
                    }
                }
            }
        }

        return tmp;

    }

    static void air() { //공기청정기
        int top = idx;  //윗 공기청정기
        int down = idx+1;   //아래 공기청정기


        //윗 공기청정기(반시계)
        for (int i = top - 1; i > 0; i--) { //아래
            map[i][0] = map[i-1][0];
        }

        for (int i = 0; i < C - 1; i++) {    //왼
            map[0][i] = map[0][i+1];
        }

        for (int i = 0; i < top; i++) {    //위
            map[i][C-1] = map[i+1][C-1];
        }

        for (int i = C - 1; i > 1; i--) {    //오
            map[top][i] = map[top][i-1];
        }
        map[top][1] = 0;    //공기청정기에서 부는 바람

        //아래 공기청정기(시계)
        for (int i = down + 1; i < R - 1; i++) {    //위
            map[i][0] = map[i+1][0];
        }

        for (int i = 0; i < C - 1; i++) {    //왼
            map[R-1][i] = map[R-1][i+1];
        }

        for (int i = R - 1; i > down; i--) {    //아래
            map[i][C-1] = map[i-1][C-1];
        }

        for (int i = C - 1; i > 1; i--) {    //오
            map[down][i] = map[down][i-1];
        }

        map[down][1] = 0;   //공기청정기에서 부는 바람
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());


        map = new int[R][C];

        //1. 초기화
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //1-1. 공기청정기 위치
        for (int i = 0; i < R; i++) {
           if (map[i][0] == -1) {
               idx = i;
               break;
           }
        }

        for (int i = 0; i < T; i++) {
            //2. 퍼져나가는 미세먼지 구하기
            map = dust();

            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    System.out.print(map[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();

            //3. 공기청정기 회전
            air();
        }
//
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result + 2);
    }
}
