import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            long cent = 0;
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine(), ".");
                cent += Integer.parseInt(st.nextToken()) * 100;
                cent += Integer.parseInt(st.nextToken());
            }

            // 가능한 F 다 해보기
            int min = 10000;
            int max = 0;

            for (int F = 0; F <= 10000; F++) {
                boolean isAnswer = false;
                long total_m100 = cent * (100 + F);
                if (total_m100 % 100 == 0) {
                    if (total_m100 / 10000 == X) {
                        isAnswer = true;
                    }
                } else {
                    if (total_m100 / 10000 == X || (total_m100 + 100) / 10000 == X) {
                        isAnswer = true;
                    }
                }

                if (isAnswer) {
                    if (F < min) {
                        min = F;
                    }
                    if (max < F) {
                        max = F;
                    }
                }
            }

            sb.append(min).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }
}