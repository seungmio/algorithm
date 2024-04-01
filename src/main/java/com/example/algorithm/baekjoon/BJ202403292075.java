package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
Java 11: 384 MB

우선순위 큐로 자동정렬 해놓은 배열에서 [N-1]번째 요소 출력
 */
public class BJ202403292075 {
    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < pq.size(); i++) {
            if (i == N-1) System.out.println(pq.poll());
            pq.poll();
        }
    }
}
