package com.example.algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2024042817266 {
    static int N, M;
    static int[] arr;   //가로등 위치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            //만약 mid 높이로 굴다리를 모두 비출 수 있다면 1~mid-1까지 재탐색
            //비출 수 없다면 mid+1~N까지 재탐색

            int tmp = 0;    //이전 가로등이 비추는 마지막 위치
            boolean isPossible = false;
            for (int i = 0; i < M; i++) {
                if (arr[i] - mid <= tmp) {  //가로등 위치에서 비추는 높이를 뺀 값이 마지막 위치보다 작거나 같으면 마지막 위치 갱신
                    tmp = arr[i] + mid;
                }

                if (N-tmp <= 0) {   //마지막 가로등이 비추는 위치가 굴다리 길이보다 작거나 같아야 전체를 다 비추게 됨
                    isPossible = true;
                }
            }

            if (isPossible) {
                result = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
