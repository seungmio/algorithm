package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
A, B, C...Z 26개 알파벳을 의미하는 boolean 형의 1차원 배열을 가지고
만약 해당 알파벳이 true이면 탐색 X
 */
public class BJ202404111987 {
    static int R, C;
    static char[][] arr;
    static boolean[] alphabet;
    static int result;
    static void dfs(int a, int b, int cnt) {
        result = Math.max(result, cnt);

        alphabet[arr[a][b] - 'A'] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = a + dx[i];
            int ny = b + dy[i];

            // && !alphabet[arr[nx][ny] - 'A']
            if ((nx >= 0) && (ny >= 0) && (nx < R) && (ny < C) && !alphabet[arr[nx][ny] - 'A']) {
                dfs(nx, ny, cnt + 1);
            }
        }

        alphabet[arr[a][b] - 'A'] = false;  //재탐색을 위함
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        alphabet = new boolean[26];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        /*
        CAAB
        ADCB
         */
        dfs(0, 0, 1);
        System.out.println(result);
    }
}
