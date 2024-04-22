package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
1. 6명의 주자가 아닌 팀은 탈락
2. 상위 4명의 점수를 합하여 가장 낮은 점수를 받은 팀이 우승
3. 만약 점수가 같을 경우 5번째로 통과한 사람의 점수를 비교하여 우승팀을 고름
 */
public class BJ202404209017 {
    static int T, N;
    static int[] score; //팀 번호를 나타내는 N개의 정수를 담는 배열
    static Map<Integer, Integer> cntMap;    //인원 체크를 하는 맵
    static Map<Integer, Integer> scoreMap;    //남은 팀의 상위 4명의 점수를 담는 맵
    static Map<Integer, Integer> fiveMap;   //5등의 점수만 따로 담는 맵
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        answer = new int[T];

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            score = new int[N]; //N등까지 존재 idx 0~14
            cntMap = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                score[j] = tmp;
                cntMap.put(tmp, cntMap.getOrDefault(tmp, 0) + 1);
            }

            scoreMap = new HashMap<>();
            fiveMap = new HashMap<>();

            Map<Integer, Integer> tmpMap = new HashMap<>(); //4명까지인지 확인하는 임시 맵

            int cnt = 1;    //등수 체크
            for(int num: score) {
                if (cntMap.get(num) == 6) { //6명의 주자가 참가한 팀이라면,
                    tmpMap.put(num, tmpMap.getOrDefault(num, 0) + 1);

                    if (tmpMap.get(num) <= 4) { //4명까지 기록
                        scoreMap.put(num, scoreMap.getOrDefault(num, 0) + cnt);
                    }

                    if (tmpMap.get(num) == 5) { //5등은 따로 기록
                        fiveMap.put(num, fiveMap.getOrDefault(num, 0) + cnt);
                    }

                    cnt++;
                }
            }

            int min = Integer.MAX_VALUE;
            int fifthScore = Integer.MAX_VALUE;
            for (Integer key: scoreMap.keySet()) {
                int tmp = scoreMap.get(key);

                if (tmp < min) {
                    min = tmp;
                    fifthScore = fiveMap.get(key);
                    answer[i] = key;
                } else if (tmp == min) {    //동점자가 발생했을 경우
                    if (fifthScore > fiveMap.get(key)) {
                        min = tmp;
                        fifthScore = fiveMap.get(key);
                        answer[i] = key;
                    }
                }
            }
        }

        for (int num: answer) {
            System.out.println(num);
        }
    }
}
