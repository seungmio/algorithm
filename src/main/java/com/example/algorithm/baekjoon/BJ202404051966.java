package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
큐 + 중요도 -> 우선순위 큐
높은 수가 높은 우선순위를 가질 경우 -> Collections.reverseOrder()

1 0
5
라면 문서가 1개 있는데 idx 0에 있는 문서의 인쇄 순서가 궁금하다는 뜻

4 2
1 2 3 4
라면 문서가 4개 있는데 idx 2에 있는 문서의 인쇄 순서가 궁금하다는 뜻
 */
public class BJ202404051966 {
    static int T, N, M; //각각 테스트케이스 수, 문서 개수, 인쇄 순서가 궁금한 문서 위치
    static Queue<Integer> q;
    static Queue<Integer> idx;  //q idx 저장
    static int cnt;  //출력 순서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            q = new LinkedList<>();
            idx = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                idx.offer(j);
                q.offer(Integer.parseInt(st.nextToken()));
            }

            /*
            q               idx                         max = 9, M = 0
            1 1 9 1 1 1     0 1 2 3 4 5
            1 9 1 1 1 1     1 2 3 4 5 0
            9 1 1 1 1 1     2 3 4 5 0 1     max = 9, M != idx.peek()
            1 1 1 1 1       3 4 5 0 1
            1 1 1 1         4 5 0 1
            1 1 1           5 0 1
            1 1             0 1

            1 2 3 4         idx 2
            2 3 4 1         idx 1
            3 4 2 1         idx 0
            4 3 2 1         idx 1   cnt = 1
            3 2 1           idx 0   cnt = 2
             */
            cnt = 0;
            while (!q.isEmpty()) {
                int max = Collections.max(q);   //최대 우선순위 값
                if (max != q.peek()) {
                    q.offer(q.poll());
                    idx.offer(idx.poll());
                } else {
                    if (M == idx.peek()) {
                        q.poll();
                        idx.poll();
                        cnt++;
                        break;
                    } else {
                        q.poll();
                        idx.poll();
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
