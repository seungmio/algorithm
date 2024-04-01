package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하인 양의 정수이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

1부터 깊이 우선 탐색: 방문여부 + 재귀
    1 2 3 4 5 6 7
1     1
2   1   1
3
4
5
6
7
 */
public class BJ202403292606 {
    static int cnt;
    static int line;
    static int[][] computer;
    static boolean[] isVisited;
    static int result;
    static void dfs(int start) {
        isVisited[start] = true;

        for (int i = 1; i <= cnt; i++) {
            if (!isVisited[i] && computer[start][i] == 1) {
                result++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        computer = new int[cnt+1][cnt+1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            computer[x][y] = 1;
            computer[y][x] = 1;
        }

        isVisited = new boolean[cnt+1];
        dfs(1);
        System.out.println(result);
    }
}
