package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2024052011723 {  //비트마스킹 문제라 뺌
    static int M;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();

            if (str.equals("all")) {
                list.sort((a, b) -> a.compareTo(b));
                continue;
            }
            else if (str.equals("empty")) {
                list.clear();
                continue;
            }

            int tmp = Integer.parseInt(st.nextToken());

            if (!list.contains(tmp)) {  //tmp를 포함하지 않을 떄
                if (str.equals("add")) list.add(tmp);
                else if (str.equals("check")) System.out.println(0);
                else if (str.equals("toggle")) list.add(tmp);
            }

            else {  //tmp를 포함할 때
                if (str.equals("remove")) list.remove(list.indexOf(tmp));
                else if (str.equals("check")) System.out.println(1);
                else if (str.equals("toggle")) list.remove(list.indexOf(tmp));
            }

        }
    }
}
