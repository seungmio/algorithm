package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ202405202292 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int range = 0;
        int cnt = 1;

        if (N == 1) System.out.println(1);

        else {
            while (N <= range) {
                range = 6 * cnt + range;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
