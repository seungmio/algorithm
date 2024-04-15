package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

/*
8
6 15 21
7 20 25
1 3 8
3 2 14
8 6 27
2 7 13
4 12 18
5 6 20

시작 시간이 가장 빠른대로 정렬
시작 시간이 같을 경우 더 빨리 끝나는 강의 순서대로 정렬
3 2 14
1 3 8
5 6 20
8 6 27
2 7 13
4 12 18
6 15 21
7 20 25

끝나는 시간 <= 시작하는 시간 대로 나열해서 강의실 하나로 배정
3 -> 6
1 -> 4 -> 7
5
8
2

 */
public class BJ202404151374 {
    static int N;   //강의 개수
    static int[][] lecture;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        lecture = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            lecture[i][0] = Integer.parseInt(st.nextToken()); //강의실 번호
            lecture[i][1] = Integer.parseInt(st.nextToken());   //강의 시작 시간
            lecture[i][2] = Integer.parseInt(st.nextToken());   //강의 종료 시간
        }

        Arrays.sort(lecture, Comparator.comparing(o1 -> o1[1])); //강의 시작시간을 기준으로 정렬

        /*
        1) 3 2 14 -> pq:14 cnt:1
        2) 1 3 8 -> pq:8, 14 cnt:2
        3) 5 6 20 -> pq: 8, 14, 20 cnt:3
        4) 8 6 27 -> pq: 8, 14, 20, 27 cnt:4
        5) 2 7 13 -> pq: 8, 13, 20, 27 cnt: 5
        6) 4 12 18 -> pq: 13, 20, 27 cnt:5
        7) 6 15 21 -> pq: 20, 27 cnt:5
        8) 7 20 25 -> pq: 27 cnt:5

        4
        1 1 3
        2 3 6
        3 5 9
        4 8 10

        1) 1 1 3 -> pq:3 cnt:1
        2) 2 3 6 -> pq:  cnt:1
        3) 3 5 9 -> pq:9 cnt:2
        4) 4 8 10 -> pq:9, 19 cnt:3

        1) 1 1 3 -> pq:3 cnt:1
        2) 2 3 6 -> pq:6 cnt:1
        3) 3 5 9 -> pq:6, 9 cnt:2
        4) 4 8 10 -> pq: 9, 10 cnt:2
         */

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;    //강의실 개수
        for (int i = 0; i < N; i++) {
            if (!pq.isEmpty() && pq.peek() <= lecture[i][1]) {
                pq.poll();
            } else {
                cnt++;
            }
            pq.offer(lecture[i][2]);
        }

        System.out.println(cnt);
    }
}
