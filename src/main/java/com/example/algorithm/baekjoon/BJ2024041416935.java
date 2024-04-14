package com.example.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2024041416935 {
    static int N, M, R; //N*M 배열, R번 연산
    static int[][] map;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //수행해야하는 연산
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int tmp = Integer.parseInt(st.nextToken()); //수행해야하는 연산

            if (tmp == 1) {
                result = new int[N][M];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        result[N-1-j][k] = map[j][k];
                    }
                }
                map = result;
            }

            if (tmp == 2) {
                result = new int[N][M];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        result[j][M-1-k] = map[j][k];
                    }
                }
                map = result;
            }

            if (tmp == 3) { //오른쪽으로 90도
                result = new int[M][N]; //6x8을 8x6으로
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        result[k][N-1-j] = map[j][k];
                    }
                }
                map = result;
                int num = N;
                N = M;
                M = num;
            }

            if (tmp == 4) {
                result = new int[M][N];
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        result[M-1-k][j] = map[j][k];
                    }
                }
                map = result;
                int num = N;
                N = M;
                M = num;
            }

            if (tmp == 5) {
                result = new int[N][M];
                //1번을 2번으로
                for (int j = 0; j < N/2; j++) {
                    for (int k = 0; k < M/2; k++) {
                        result[j][M/2+k] = map[j][k];
                    }
                }
                
                //2번을 3번으로
                for (int j = 0; j < N/2; j++) {
                    for (int k = M/2; k < M; k++) {
                        result[N/2+j][k] = map[j][k];
                    }
                }

                //3번을 4번으로
                for (int j = N/2; j < N; j++) {
                    for (int k = M/2; k < M; k++) {
                        result[j][k-M/2] = map[j][k];
                    }
                }
                
                //4번을 1번으로
                for (int j = N/2; j < N; j++) {
                    for (int k = 0; k < M/2; k++) {
                        result[j-N/2][k] = map[j][k];
                    }
                }
                map = result;
            }

            if (tmp == 6) {
                result = new int[N][M];
                //1번을 4번으로
                for (int j = 0; j < N/2; j++) {
                    for (int k = 0; k < M/2; k++) {
                        result[j+N/2][k] = map[j][k];
                    }
                }

                //4번을 3번으로
                for (int j = N/2; j < N; j++) {
                    for (int k = 0; k < M/2; k++) {
                        result[j][k+M/2] = map[j][k];
                    }
                }

                //3번을 2번으로
                for (int j = N/2; j < N; j++) {
                    for (int k = M/2; k < M; k++) {
                        result[j-N/2][k] = map[j][k];
                    }
                }

                //2번을 1번으로
                for (int j = 0; j < N/2; j++) {
                    for (int k = M/2; k < M; k++) {
                        result[j][k-M/2] = map[j][k];
                    }
                }
                map = result;
            }
        }

        for (int[] tmp: result) {
            for (int num: tmp) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
