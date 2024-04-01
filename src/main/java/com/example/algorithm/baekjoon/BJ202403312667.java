package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ202403312667 {
    static int N;   //지도 크기
    static int[][] map; //지도
    static boolean[][] isVisited;   //방문여부
    static int complex; //단지 수
    static int house;   //단지 내 집 수
    static void dfs(int a, int b) {
        isVisited[a][b] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = a+dx[i];
            int ny = b+dy[i];

            if ((nx >= 0) && (nx < N) && (ny >= 0) && (ny < N) && !isVisited[nx][ny] && map[nx][ny] == 1) {
                house++;
                dfs(nx, ny);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        isVisited = new boolean[N][N];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                house = 1;  //단지 내 집의 수를 세기 시작한 시점부터 이미 1개
                if (!isVisited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    complex++;
                    result.add(house);
                }
            }
        }

        System.out.println(complex);
        Collections.sort(result);   //오름차순 정렬
        for (int tmp: result) {
            System.out.println(tmp);
        }
    }
}
