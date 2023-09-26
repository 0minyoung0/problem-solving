import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        for (int i=1; i<=G; i++) {
            set.add(i);
        }

        int P = Integer.parseInt(br.readLine());
        int[] g = new int[P];
        for (int i=0; i<P; i++) {
            g[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        for (int gate : g) {
            Integer find = set.floor(gate);
            if (find == null) break;
            set.remove(find);
            ans++;
        }

        System.out.print(ans);
    }
}