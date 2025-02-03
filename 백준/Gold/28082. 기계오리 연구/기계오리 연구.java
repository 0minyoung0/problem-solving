import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashSet<Integer> power = new HashSet<>();
        power.add(0);

        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(0, 0);

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) {
            int I = Integer.parseInt(st.nextToken());
            List<Integer> powerList = new ArrayList<>(power);
            HashMap<Integer, Integer> nextCount = new HashMap<>(count);
            for (int p : powerList) {
                int c = count.get(p);
                if (c == K) continue;
                int newPower = p + I;
                int newCount = c + 1;
                if (!count.containsKey(newPower) || newCount < count.get(newPower)) {
                    power.add(newPower);
                    nextCount.put(newPower, newCount);
                }
            }
            count = nextCount;
        }

        power.remove(0);
        List<Integer> ans = new ArrayList<>(power);
        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append('\n');
        for (int a : ans) {
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }
}
