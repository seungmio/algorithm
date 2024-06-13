package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2024052023971 {
    static int H, W, N, M;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());   //행
        W = Integer.parseInt(st.nextToken());   //열
        N = Integer.parseInt(st.nextToken())+1;   //세로로 비워야 하는 칸의 수
        M = Integer.parseInt(st.nextToken())+1;   //가로로 비워야 하는 칸의 수

        for (int i = 0; i < H; i+=N) {
            for (int j = 0; j < W; j+=M) {
                result++;
            }
        }

        System.out.println(result);
    }
}
