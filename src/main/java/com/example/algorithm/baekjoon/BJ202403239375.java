package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
시간제한 1초 따라서 10^8~10^9 연산까지 가능
3중 for 문 이상 가능할 것 같은데, for문으로 시간복잡도를 따지는 문제가 아닌 것 같다

2   //테스트 케이스, 최대 100
3   //의상 수 0~30
hat headgear    //의상의 이름과 종류, 같은 종류의 의상은 하나만 입을 수 있다, 같은 이름의 의상은 존재하지 않는다
sunglasses eyewear
turban headgear
3
mask face
sunglasses face
makeup face

첫 번째 테스트 케이스는 headgear에 해당하는 의상이 hat, turban이며 eyewear에 해당하는 의상이 sunglasses이므로
(hat), (turban), (sunglasses), (hat,sunglasses), (turban,sunglasses)로 총 5가지

headgear: 2
eyewear: 1

(2+아예 선택 안하는 경우 1)C1 * (1+아예 선택 안하는 경우 1)C1 - 알몸일 경우 1

face: 3

3 * 1


해시맵 돌면서 각 key의 value 곱해준 값 + key 개수 인데,
key==1이면 제외
 */
public class BJ202403239375 {
    static int t;   //테스트 케이스
    static int n;   //의상 수
    static ArrayList<Integer> result = new ArrayList();
    static HashMap<String, Integer> clothes;   //<의상종류, 의상개수>

    static int combination(int n, int r) {
        if (n==r || r==0) {
            return 1;
        }

        return combination(n-1, r) + combination(n-1, r-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            clothes = new HashMap<>();
            n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();

                clothes.put(type, clothes.getOrDefault(type, 0)+1);
            }

//            System.out.println(clothes);
            int tmp = 1;
            for (String key: clothes.keySet()) {
                tmp *= combination(clothes.get(key)+1, 1);
            }

            result.add(tmp-1);
        }

        for (int num: result) {
            System.out.println(num);
        }
    }
}
