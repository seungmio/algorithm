package com.example.algorithm.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//각 위치에서 2로 가는 모든 경우의 수를 따진다면 dfs로 풀겠지만,
//각 위치에서 2로 가는 최단 경로를 구해야 하기 때문에 bfs
public class BJ2024050914940 {
    static int n, m;
    static int[][] map;
    static boolean[][] isVisited;   //방문 여부
    static int[][] dist;    //방문 거리
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();    //좌표 2개 나오는 순간 2차원
        queue.offer(new int[] {x, y});
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();   //출발 지점

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 1 && !isVisited[nx][ny]) {
                        isVisited[nx][ny] = true;
                        dist[nx][ny] = dist[now[0]][now[1]] + 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        isVisited = new boolean[n][m];
        dist = new int[n][m];

        int x = 0;
        int y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {   //목표 지점
                    x = i;
                    y = j;
                } else if(map[i][j] == 0) isVisited[i][j] = true;   //갈 수 없는 땅
            }
        }

        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) dist[i][j] = -1;   //갈 수 있는 곳인데 방문하지 않음
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
