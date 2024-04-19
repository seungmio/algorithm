package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
3 90 10
100 90 80
10명 들어갈 수 있으며 현재 3명 있음 => 태수가 들어갈 수 있음
3명과의 점수를 비교해가며 점수가 낮으면 cnt+1, 같으면 cnt+0

10 1 10
10 9 8 7 6 5 4 3 2 1
10명 들어갈 수 있으며 현재 10명 있음 => 꽉 참 => 태수 점수와 가장 낮은 사람의 점수를 비교해 같거나 태수가 더 낮으면 들어갈 수 없음 => -1

10 1 10
10 9 8 7 6 5 4 3 3 0
10명 들어갈 수 있으며 현재 10명 있음 => 꽉 참 => 태수 점수와 가장 낮은 사람의 점수를 비교해 태수가 더 높으므로 그 가장 낮은 사람 제거
남은 사람과 점수를 비교해가며 점수가 낮으면 cnt+1, 같으면 cnt+0
 */
public class BJ202404191205 {
    //N은 P보다 작거나 같음
    static int N, S, P; //점수 개수, 태수 점수, 랭킹 리스트에 올라갈 수 있는 점수 개수
    static ArrayList<Integer> score;
    static int cnt = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());


        if (N > 0) {    //랭킹리스트가 비어있지 않으면
            st = new StringTokenizer(br.readLine());    //랭킹리스트가 비어있으면 여기서 NullPointer 발생

            score = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                score.add(Integer.parseInt(st.nextToken()));
            }

            if (N < P) {    //태수가 들어갈 수 있음
                for (int num: score) {
                    if (S < num) cnt++;
                }
            } else {    //태수가 들어갈 수 없음
                int bottom = score.get(N-1);

                if (S > bottom) {   //꼴찌보다 태수 점수가 높으면 들어갈 수 있음
                    score.remove(N-1);

                    for (int num: score) {
                        if (S < num) cnt++;
                    }
                } else {    //꼴찌보다 태수 점수가 같거나 낮으면 들어갈 수 없음
                    cnt = -1;
                }
            }
        }


        System.out.println(cnt);    //랭킹리스트가 비어있으면 태수는 자동 1등
    }
}
