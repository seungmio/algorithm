package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ202404181166 {
    static int N, L, W, H;  //(A*A*A)*N개 L*W*H

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        double low = 0;
        double high = Math.min(L, Math.min(W, H));  //종료 범위는 L,W,H 중 가장 작은 값(모든 박스가 이 한 변 안에 들어가야 하므로)

        for (int i = 0; i < 10000; i++) {
            double mid = (low + high) / 2;

            Long totalFit = (long)(L/mid) * (long)(W/mid) * (long)(H/mid);

            if (totalFit >= N) {    //N개 이상 들어갈 수 있음
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println(low);
    }
}
