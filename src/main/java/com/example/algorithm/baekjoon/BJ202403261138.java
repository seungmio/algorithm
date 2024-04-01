package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2초니까 2x10^8~2x10^9 0.2x10^9~0.2x10^10

사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다. N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.
N은 10보다 작거나 같은 자연수: 3중 for 이상 가능할 듯?

둘째 줄에는 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어진다.
i번째 수는 0보다 크거나 같고, N-i보다 작거나 같다. i는 0부터 시작한다.

4
키:                           1 2 3 4 5 6 7
왼쪽에 자신보다 키가 큰 사람의 수: 6 1 1 1 2 0 0
결과:                         6 2 3 4 7 5 1

0 0 0 0 0 0 1
0 2 0 0 0 0 1
0 2 3 0 0 0 1
0 2 3 4 0 0 1
0 2 3 4

1) 키가 1인 사람은 왼쪽에 자신보다 키가 큰 사람이 2명이니 idx 2로 들어감: 0 0 1 0
2) 키가 2인 사람은 왼쪽에 자신보다 키가 큰 사람이 1명이니 idx 1로 들어감: 0 2 1 0
3) 키가 3인 사람은 왼쪽에 자신보다 키가 큰 사람이 1명이니 idx 1로 들어감
4) 그러나 idx 1엔 2가 있기 때문에 자신보다 키가 큰 사람이 2명이니 그 뒷자리로 밀려남, 그 뒷자리인 idx 2에도 1이 있기 때문에 그 뒷자리로 밀려남: 0 2 1 3
5) 키가 4인 사람은 왼쪽에 자신보다 키가 큰 사람이 0명이니 idx 0로 들어감: 4 2 1 3

 */
public class BJ202403261138 {
    static int N;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        result = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int left = arr[i];  //왼쪽에 자신보다 키가 큰 사람의 수
            for (int j = 1; j <= N; j++) {
                if (left == 0 && result[j] == 0) {  //왼쪽에 나보다 키 큰 사람이 없고 자리가 비어있다면
                    result[j] = i;  //자리배치
                    break;
                } else if (result[j] == 0){ //왼쪽에 나보다 키 큰 사람이 있어야 하는데 자리만 비어있다면
                    left--;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
