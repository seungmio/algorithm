package com.example.algorithm.baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*
1초 10^8: 1억
n초: n억

A,B 는 1~10억까지
최악의 경우 A:1, B:10억 => int type 가능

2를 계속 곱해서 1을 10억으로 만든다고 한다면,
2 4 8 16 32 64 128 256 ... : 5억번 연산
 */
public class BJ2024041016953 {
    static int A, B;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        B 162 => 1 6 2
         */

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


        /*
        연산을 거꾸로 가보자
        B는 마지막 수는 1이거나 2의 배수일 수 밖에 없음

        만약 B가 2로 나눠진다면, 2로 나눈다
        만약 B가 2로 나눠지지 않는다면, 마지막 1을 제거한다.

        42 -> 4
        42 -> 21 -> 2
        A보다 B가 더 작아졌는데 둘이 같은 수가 안나오면 연산을 멈춘다.

        1 10000001
        10000001 -> 1000000 -> 500000 -> 250000 -> 125000 -> 62500 -> 31250 -> 15625
         */
        while (A != B) {
            if (B < A) {
                result = -1;
                break;
            }
            if ((B % 10 != 1) && (B % 2 != 0)) {
                result = -1;
                break;
            }
            if (B % 10 == 1) {
                B /= 10;
                result++;
            } else if (B % 2 == 0) {
                B /= 2;
                result++;
            }
        }

        if (result != -1) bw.write(String.valueOf(result + 1));
        else bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
