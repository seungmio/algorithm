package com.example.algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ2024042521921 {
    /*
    1초 시간제한인데 시간복잡도가 N*X가 되면 초과함 => 슬라이딩 윈도우 기법 사용
    슬라이딩 윈도우 기법을 사용하면, 이전의 첫 번째 요소를 빼고 새로운 요소를 더함으로써 시간 복잡도는 N
     */
    static int N, X;    //블로그를 시작하고 지난 일 수, 가장 많이 들어온 방문자 수를 알고싶은 일 수
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //최초 X일 방문자 수
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }

        int maxSum = sum;   //최대 방문자 수
        int cnt = 1;    //최대 방문자가 나타난 횟수
        for (int i = X; i < N; i++) {
            sum += arr[i] - arr[i-X];   //신규 요소 추가, 오래된 요소 제거

            if (sum > maxSum) {
                maxSum = sum;
                cnt = 1;    //새로운 최댓값 발견
            } else if (sum == maxSum) {
                cnt++;
            }
        }

        if (maxSum == 0) {
            bw.write("SAD");
        } else {
            bw.write(maxSum + "\n" + cnt);
        }

        bw.flush();
        bw.close();
    }
}
