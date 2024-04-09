package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
최대공약수 합을 구하기

변수가 int type인지 long type인지 각각 적용해보기
 */
public class BJ202404099613 {
    static int T;   //테스트 케이스
    static int N;
    static long result;
    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
//            System.out.println(N);
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            result = 0;
            for (int j = 0; j < N-1; j++) {
                for (int k = j+1; k < N; k++) {
                    result += gcd(arr[j], arr[k]);
                }
            }

            /*
            0 1 2 3 4
            0 - 1 2 3 4
            1 - 2 3 4
            2 - 3 4
            3 - 4
            4 //반복할 필요 없음!!
             */

            System.out.println(result);
        }
    }
}
