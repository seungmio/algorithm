package com.example.algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/*
투포인터 알고리즘

이 문제는 0.5초이기 때문에 구현으로 풀 수 있음
하지만 시간이 더 짧으면 투포인터로 구현해서 시간을 줄여야 함
 */
public class BJ202404092003 {
    static int N, M;
    static int[] A;
    static int[] sum;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        System.out.println(N);
//        System.out.println(M);

        A = new int[N];
        sum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = A[0];
        //dp 초기화 잘하자 ... sum[1] 괜히 초기화 했다가 오류남
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + A[i];
        }

        //0 - 1 2 3
        //1 - 2 3
        //2 - 3

        result = 0;
        for (int i = 0; i < N; i++) {
            if (sum[i] == M) result++;
            for (int j = i+1; j < N; j++) {
                if (sum[j] - sum[i] == M) result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
