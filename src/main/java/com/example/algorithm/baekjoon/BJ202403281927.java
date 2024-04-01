package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
2초

1. 배열에 자연수 x를 넣는다.
2. 배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.

프로그램은 처음에 비어있는 배열에서 시작하게 된다.

첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000): N*N 2중 for문까지 가능
다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.

만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.

우선순위 큐
들어간 순서와는 상관없이 높은 우선순위를 가진 원소가 먼저나온다는 특징
: 최소 힙 = 숫자가 작을수록 먼저 나오는 큐

0           arr:                0
12345678    arr:12345678
1           arr:1, 12345678
2           arr:1, 2, 12345678
0           arr:2, 12345678     1
0           arr:12345678        2
0           arr:                12345678
0                               0
32          arr:32

0
1
2
12345678
0
 */
public class BJ202403281927 {
    static int N;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(); //낮은 수가 더 높은 우선순위를 가지도록 초기화
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0) {
                if (pq.peek() == null) System.out.println(0);
                else System.out.println(pq.poll());
            }
            else pq.offer(tmp);
        }
    }
}
