import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        while (N-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        while (M-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }

        System.out.print(sb);
    }
}