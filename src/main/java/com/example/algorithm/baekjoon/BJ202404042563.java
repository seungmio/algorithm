package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
전체에서 빼는 건 발상이 안남
방문 여부를 따져서 풀 수 있을듯

 */
public class BJ202404042563 {
    static boolean[][] arr;
    static int n;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new boolean[101][101];    //좌표가 (1,1)부터 시작하므로
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //(3, 7) -> (13, 17)
            for (int j = x; j < (x+10); j++) {
                for (int k = y; k < (y+10); k++) {
                    if (!arr[j][k]) result++;
                    arr[j][k] = true;
                }
            }
        }

        System.out.println(result);
    }
}
