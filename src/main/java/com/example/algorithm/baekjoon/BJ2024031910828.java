package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
0.5초 256MB
push X: 정수 X를 스택에 넣는 연산이다. --> push
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다. --> pop
size: 스택에 들어있는 정수의 개수를 출력한다. --> size
empty: 스택이 비어있으면 1, 아니면 0을 출력한다. -->  isempty
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다. --> peek

N이 1~10000 이므로 2중 for문이라면 10000*10000 으로 10^8
컴퓨터가 초당 약 10^8에서 10^9 연산 수행이 가능할 때, 0.5초라면 0.5x10^8에서 0.5x10^9가 되므로 5x10^7에서 5x10^8 연산 수행이 가능함
따라서 2중 for문까지 허용

N은 명령의 수

N, Stack 전역 변수로 초기화
for(<N) 하면서 push 라면 tokenizer로 구분하기
 */
public class BJ2024031910828 {
    static int N;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String m = st.nextToken();

            if (m.equals("push")) {
                int c = Integer.parseInt(st.nextToken());
                stack.push(c);

            } else if (m.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else
                    System.out.println(stack.pop());

            } else if (m.equals("size")) {
                System.out.println(stack.size());
            } else if (m.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println("1");

                } else {
                    System.out.println("0");
                }
            } else if (m.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else
                    System.out.println(stack.peek());
            }

        }
    }
}
