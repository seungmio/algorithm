package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ202405221620 {
    static int N, M;    //도감의 포켓몬 수, 맞춰야 하는 문제 개수
    static HashMap<String, String> hashMap1;    //도감
    static HashMap<String, String> hashMap2;    //도감
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        hashMap1 = new HashMap<>();
        hashMap2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            hashMap1.put(String.valueOf(i), str);
            hashMap2.put(str, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            if (hashMap1.containsKey(str)) System.out.println(hashMap1.get(str));
            else {
                System.out.println(Integer.parseInt(hashMap2.get(str)));
            }
        }
    }
}
