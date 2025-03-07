import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String x = st.nextToken();
            int m = x.length();
            int[] cards = new int[m];
            for (int i = 0; i < m; i++) {
                cards[i] = x.charAt(i) - '0';
            }

            List<long[]> list = new ArrayList<>();
            for (int blankBits = (1 << (m - 1)) - 1; blankBits >= 0; blankBits--) {
                long sum = 0;
                long temp = cards[0];
                int bit = (1 << (m - 2));
                for (int i = 1; i < m; i++) {
                    if ((bit & blankBits) > 0) {
                        temp *= 10;
                        temp += cards[i];
                    } else {
                        sum += temp;
                        temp = cards[i];
                    }
                    bit >>= 1;
                }
                sum += temp;
                list.add(new long[] { sum, blankBits });
            }
            Collections.sort(list, new Comparator<long[]>() {
                public int compare(long[] o1, long[] o2) {
                    if (o1[0] < o2[0]) {
                        return -1;
                    } else if (o1[0] > o2[0]) {
                        return 1;
                    } else {
                        if (o1[1] < o2[1]) {
                            return -1;
                        } else if (o1[1] > o2[1]) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                }
            });

            long ans1 = 0;
            int ans2 = 0;
            st = new StringTokenizer(br.readLine());
            while (n-- > 0) {
                int v = Integer.parseInt(st.nextToken());
                long[] result = list.get(v - 1);
                ans1 += result[0];
                ans2 += m - 1 - Integer.bitCount((int) (result[1]));
            }
            sb.append(ans1).append(' ').append(ans2).append('\n');
        }

        System.out.print(sb);
    }
}