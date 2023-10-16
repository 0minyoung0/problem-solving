import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] players = new int[N];
        HashMap<Integer, Integer> score = new HashMap<>();
        for (int i=0; i<N; i++) {
            players[i] = Integer.parseInt(st.nextToken());
            score.put(players[i], 0);
        }

        for (int p : players) {
            for (int j=2*p; j<=1000000; j+=p) {
                if (!score.containsKey(j)) continue;
                score.put(p, score.get(p) + 1);
                score.put(j, score.get(j) - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : players) {
            sb.append(score.get(p)).append(" ");
        }
        System.out.println(sb);
    }
}
