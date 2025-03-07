import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] count = new int[5][5]; // count[i][j] = i번 플레이어가 j등을 한 횟수
        int[] basicScore = new int[5]; // score[i] = i번 플레이어가 얻은 기본 점수
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int[] a = new int[5];
            for (int i = 1; i <= 4; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                count[a[i]][i]++;
            }
            int[] s = new int[5];
            for (int i = 1; i <= 4; i++) {
                s[i] = Integer.parseInt(st.nextToken());
                basicScore[a[i]] += s[i];
            }
        }

        int[] d = new int[5];
        for (d[1] = 100; d[1] >= 0; d[1]--) {
            for (d[2] = d[1]; d[2] >= -33; d[2]--) {
                for (d[3] = d[2]; d[3] >= -100; d[3]--) {
                    d[4] = -d[1] - d[2] - d[3];
                    if (d[4] < -100 || d[3] < d[4]) {
                        continue;
                    }

                    int[] score = new int[5];
                    for (int i = 1; i <= 4; i++) {
                        score[i] = basicScore[i];
                        for (int j = 1; j <= 4; j++) {
                            score[i] += count[i][j] * d[j];
                        }
                    }

                    // 등수 구하기
                    int rank = 1;
                    for (int i = 1; i <= 4; i++) {
                        if (i == k) {
                            continue;
                        }
                        if (score[i] > score[k] || (score[i] == score[k] && i < k)) {
                            rank++;
                        }
                    }

                    if (rank == m) {
                        System.out.println(d[1] + " " + d[2] + " " + d[3] + " " + d[4]);
                        return;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}