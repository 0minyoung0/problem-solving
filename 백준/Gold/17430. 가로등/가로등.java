import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> r = new HashMap<>();
        HashMap<Integer, Integer> c = new HashMap<>();
        TC: while (T-- > 0) {
            r.clear();
            c.clear();
            int N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                r.put(x, r.getOrDefault(x, 0) + 1);
                c.put(y, c.getOrDefault(y, 0) + 1);
            }

            int temp = -1;
            for (int x : r.keySet()) {
                if (temp == -1) {
                    temp = r.get(x);
                } else {
                    if (temp != r.get(x)) {
                        System.out.println("NOT BALANCED");
                        continue TC;
                    }
                }
            }
            temp = -1;
            for (int y : c.keySet()) {
                if (temp == -1) {
                    temp = c.get(y);
                } else {
                    if (temp != c.get(y)) {
                        System.out.println("NOT BALANCED");
                        continue TC;
                    }
                }
            }

            System.out.println("BALANCED");
        }
    }
}
