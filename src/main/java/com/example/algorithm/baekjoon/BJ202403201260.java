package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
시간제한 2초, 초당 10^8~10^9 연산이 가능할 때 2초이기 때문에 2x10^8~2x10^9
N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000) 이면 2중 for문까진 가능

4 5 1
1 2
1 3
1 4
2 4
3 4

dfs: 방문 여부를 체크할 배열 + 스택 or 재귀
bfs: 방문 여부를 체크할 배열 + 큐

방문 여부를 체크할 배열 int[N] 1 2 3 4

1 2 / 1 1 0 0 ==> 1 2
2 4 / 1 1 0 1 ==> 1 2 4
1 3 / 1 1 1 1 ==> 1 2 4 3
3 4
1 4

1 2 / 1 1 0 0 ==> 1 2
1 3 / 1 1 1 0 ==> 1 2 3
1 4 / 1 1 1 1 ==> 1 2 3 4
2 4
3 4

아래처럼 2중배열로 초기화(간선이 있는지 확인 여부를 위해, 간선이 있으면 1 없으면 0)
 1 2 3 4
1
2
3
4
 */
public class BJ202403201260 {
    static int N;   //정점의 개수
    static int M;   //간선의 개수
    static int V;   //탐색을 시작할 번호
    static boolean[] isVisited; //방문 여부를 담을 배열
    static int[][] NN;

    static ArrayList<Integer> listForDfs = new ArrayList<>();
    static ArrayList<Integer> listForBfs = new ArrayList<>();

    static void dfs(int start) {
        isVisited[start] = true;
        listForDfs.add(start);

        for (int i = 1; i <= N; i++) {
            if (!isVisited[i] && NN[start][i] == 1) {
                dfs(i);
            }
        }
    }

    //queue 1
    //queue.poll() 2 ==> queue 2
    //queue.poll() 3 ==> queue 2 3
    //queue.poll() 4 ==> queue 2 3 4

    //queue.poll() 이미 모두 방문 ==> queue 3 4
    //...3/4까지 반복

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        isVisited[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            listForBfs.add(start);

            for (int i = 1; i <= N; i++) {
                if (!isVisited[i] && NN[start][i] == 1){
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        NN = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //입력이 주어지는 것은 양방향
            NN[a][b] = 1;
            NN[b][a] = 1;
        }
        
        isVisited = new boolean[N+1];
        dfs(V);

        isVisited = new boolean[N+1];
        bfs(V);

        for (int num: listForDfs) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num: listForBfs) {
            System.out.print(num + " ");
        }
    }
}
