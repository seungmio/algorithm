package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ202404242512 {
    static int N, M;   //지방의 수, 총 예산
    static int[] arr;
    static long result;
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int i = 0; i < N; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
         }
         M = Integer.parseInt(br.readLine());   //총 예산

         Arrays.sort(arr);

         long left = 0;
         long right = arr[N-1];

         while (left <= right) {
             long mid = (left + right) / 2;
             long tax = 0;  //총 상한액

             for (int num: arr) {
                 if (num >= mid) tax += mid;
                 else tax += num;
             }

             if (tax > M) {
                 right = mid-1;
             } else {
                 left = mid+1;
                 result = mid;
             }
         }

         System.out.println(result);
    }
}
