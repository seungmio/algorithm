package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ2024032811279 {
    static int N;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(Collections.reverseOrder());   //높은 수가 우선순위를 가지는 우선순위 큐

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0) {
                if (pq.peek() == null) System.out.println(0);
                else System.out.println(pq.poll());
            } else pq.offer(tmp);
        }
    }
}
