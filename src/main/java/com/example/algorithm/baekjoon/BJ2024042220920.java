package com.example.algorithm.baekjoon;

import java.io.*;
import java.util.*;
/*
우선순위를 차례로 적용
1.자주 나오는 단어일수록 앞에 배치한다.
2.해당 단어의 길이가 길수록 앞에 배치한다.
3.알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다.

길이가 M 이상인 단어만 외운다.
 */

public class BJ2024042220920 {
    static int N, M;
    static Map<String, Integer> cntMap; //단어 출현 횟수를 담는 맵
    static Map<String, Integer> lengthMap;  //단어 길이를 담는 맵
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cntMap = new HashMap<>();
        lengthMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (str.length() >= M) {    //길이가 M 이상인 단어만 외운다.
                cntMap.put(str, cntMap.getOrDefault(str, 0) + 1);
                lengthMap.put(str, lengthMap.getOrDefault(str, str.length()));
            }


        }

        // 알파벳 순서대로 정렬
//        List<String> keySet = new ArrayList<>(lengthMap.keySet());
//        keySet.sort((o1, o2) -> o1.compareTo(o2));
//
////        //단어 길이 순서(value) 기준으로 key 내림차순 정렬
//        keySet.sort(((o1, o2) -> lengthMap.get(o2).compareTo(lengthMap.get(o1))));
//
////        //단어 출현 횟수(value) 기준으로 key 내림차순 정렬
//        keySet.sort((o1, o2) -> cntMap.get(o2).compareTo(cntMap.get(o1)));

        List<String> keySet = new ArrayList<>(cntMap.keySet());
        keySet.sort((o1, o2) -> {
            //단어 출현 횟수로 내림차순 정렬
            int cntCompare = cntMap.get(o2).compareTo(cntMap.get(o1));
            if (cntCompare != 0) return cntCompare; //단어 출현 횟수가 같지 않다면 그대로 반환

            //출현 횟수가 같으면 단어 길이 순서로 내림차순 정렬
            int lengthCompare = lengthMap.get(o2).compareTo(lengthMap.get(o1));
            if (lengthCompare != 0) return lengthCompare;   //단어 길이가 같지 않다면 그대로 반환

            //길이도 같다면 알파벳 순서대로 정렬
            return o1.compareTo(o2);
        });


        for (String key: keySet) {
            bw.write(key + "\n");
        }

        bw.flush();
        bw.close();
    }
}
