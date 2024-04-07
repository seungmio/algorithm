package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
f(1)=1, f(0)=0

f(3) = f(2) + f(1) -> 1 cnt++
f(2) = f(1) + f(0) -> 1 cnt++, 0 cnt++
 */
public class BJ202404071003 {
    static int T;   //테스트 케이스 개수
    static int N;
    static int[][] arr; //0과 1개수를 담을 배열
    static int fibonacci(int n) {
        if (n == 0) {
            arr[0][0]++;
            return 0;
        } else if (n == 1) {
            arr[0][1]++;
            return 1;
        }

        return fibonacci(n-2) + fibonacci(n-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[1][2];
            fibonacci(N);

            System.out.println(arr[0][0] + " " + arr[0][1]);
            System.out.println();
        }
    }
}
