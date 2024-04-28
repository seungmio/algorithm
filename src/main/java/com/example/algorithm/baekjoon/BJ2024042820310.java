package com.example.algorithm.baekjoon;

import java.io.*;

public class BJ2024042820310 {
    static String S;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        arr = new char[S.length()];

        int cnt0 = 0;
        int cnt1 = 0;

        for (int i = 0; i < S.length(); i++) {
            arr[i] = S.charAt(i);

            if (S.charAt(i) == '0') {
                cnt0++;
            } else {
                cnt1++;
            }
        }

        //타노스는 재배열을 하지 않기 때문에 '가장 빠른 것' 들 중 '사전순'으로 '가능한' 문자열을 출력해야 함
        //001111000000 이 000011 나오면 문자열 재배치가 됨 001100 이어야 정답
        //1은 앞에서부터 지우고, 0은 뒤에서부터 지우면 됨
        cnt0 /= 2;
        cnt1 /= 2;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '1') {
                cnt1--;
                arr[i] = '2';
            }
            if (cnt1 == 0) break;
        }

        for (int i = S.length()-1; i >= 0; i--) {
            if (S.charAt(i) == '0') {
                cnt0--;
                arr[i] = '2';
            }
            if (cnt0 == 0) break;
        }

        for (int i = 0; i < S.length(); i++) {
            if (arr[i] == '1' || arr[i] == '0') {
                bw.write(arr[i]);
            }
        }

        bw.flush();
        bw.close();
    }
}
