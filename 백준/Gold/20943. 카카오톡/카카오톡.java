import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0) {
                map.put(0L, map.getOrDefault(0, 0) + 1);
                continue;
            } else if (b == 0) {
                map.put(Long.MAX_VALUE, map.getOrDefault(Long.MAX_VALUE, 0) + 1);
                continue;
            }

            int gcd = GCD(Math.abs(a), Math.abs(b));
            a = a / gcd;
            b = b / gcd;

            if (a < 0) {
                a = -a;
                b = -b;
            }

            long key = (((long) a) << 10) + b;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long ans = 0;
        List<Long> list = new ArrayList<>(map.keySet());
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            ans += ((long) map.get(list.get(i))) * count;
            count += map.get(list.get(i));
        }
        System.out.println(ans);
    }

    public static int GCD(int x, int y) {
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        if (max % min == 0) {
            return min;
        }
        return GCD(min, max % min);
    }
}