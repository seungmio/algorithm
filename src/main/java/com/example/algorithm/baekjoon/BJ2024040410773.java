package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ2024040410773 {
    static int K;
    static Stack<Integer> stack;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0) { //정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있으므로 isEmpty 조건은 넣지 않음
                stack.pop();
            }
            else stack.push(tmp);
        }

        for (int i = 0; i < stack.size(); i++) {
            result += stack.get(i);
        }

        System.out.println(result);
    }
}
