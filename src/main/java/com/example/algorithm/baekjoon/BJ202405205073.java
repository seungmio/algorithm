package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ202405205073 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[3];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            if (arr[0] + arr[1] + arr[2] == 0) break;

            Arrays.sort(arr);

            if (arr[0] + arr[1] <= arr[2]) System.out.println("Invalid");
            else if (arr[0] == arr[1] && arr[1] == arr[2]) System.out.println("Equilateral");
            else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }
}
