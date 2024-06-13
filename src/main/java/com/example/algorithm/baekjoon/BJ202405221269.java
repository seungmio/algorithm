package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ202405221269 {
    static int A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        HashSet<Integer> hashSetA = new HashSet<>();
        HashSet<Integer> hashSetB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            int n = Integer.parseInt(st.nextToken());
            hashSetA.add(n);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            hashSetB.add(Integer.parseInt(st.nextToken()));
        }

        hashSetA.retainAll(hashSetB);

        System.out.println((A - hashSetA.size()) + (B - hashSetA.size()));

    }
}
