package com.example.algorithm.baekjoon;
/*
1초 10^8~10^9 연산 가능
N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

2중 for 문까진 가능
1은 이동할 수 있는 칸, 0은 이동할 수 없는 칸
(1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램

한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동(칸을 셀 때에는 시작 위치와 도착 위치도 포함)

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1

static Queue<int[]> queue = new LinkedList<>();
queue.offer(new int[]{a, b});
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ202403262178 {
    static int N;   //행
    static int M;   //열
    static int[][] arr;
    static int[][] distance;    //각 칸까지 이동거리를 담을 배열
    static boolean[][] isVisited;
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});   //시작점
        isVisited[0][0] = true; //방문
        distance[0][0] = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] start = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = start[0] + dx[i];
                int ny = start[1] + dy[i];

                if ((nx >= 0) && (nx < N) && (ny >= 0) && (ny < M) && arr[nx][ny] == 1 && !isVisited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    isVisited[nx][ny] = true;

                    distance[nx][ny] = distance[start[0]][start[1]] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        distance = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        bfs();
        System.out.println(distance[N-1][M-1]);
    }
}
