import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        HashSet<Integer>[] sets = new HashSet[2];
        for (int i = 0; i < 2; i++) {
            sets[i] = new HashSet<>();
        }

        char[] oper = new char[2];
        int[] num = new int[2];

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            sets[0].clear();
            sets[1].clear();
            sets[0].add(1);
            for (int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<2; j++) {
                    oper[j] = st.nextToken().charAt(0);
                    num[j] = Integer.parseInt(st.nextToken());
                }
            
                int idx = i % 2;
                int prev = 1 - idx;

                sets[idx].clear();

                for (int p : sets[prev]) {
                    for (int j=0; j<2; j++) {
                        if (oper[j] == '+') {
                            sets[idx].add((p + num[j]) % 7);
                        } else {
                            sets[idx].add((p * num[j]) % 7);
                        }
                    }
                }
            }

            if (sets[N % 2].contains(0)) sb.append("LUCKY\n");
            else sb.append("UNLUCKY\n");
        }

        System.out.print(sb);
    }
}
