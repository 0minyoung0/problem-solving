import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = "";
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input += st.nextToken();
            }
        }

        if (input.equals("123456780")) {
            System.out.println("0");
            return;
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put(input, 0);

        Queue<String> q = new ArrayDeque<>();
        q.offer(input);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            String cur = q.poll();
            int zeroPosX = cur.indexOf("0") / 3;
            int zeroPosY = cur.indexOf("0") % 3;
            for (int dir = 0; dir < 4; dir++) {
                int nx = zeroPosX + dx[dir];
                int ny = zeroPosY + dy[dir];
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
                char nextNum = cur.charAt(nx * 3 + ny);
                String nextStr = cur.replace(nextNum, 'x')
                                    .replace(cur.charAt(zeroPosX * 3 + zeroPosY), nextNum)
                                    .replace('x', '0');
                if (map.containsKey(nextStr)) continue;
                if (nextStr.equals("123456780")) {
                    System.out.println(map.get(cur) + 1);
                    return;
                }
                map.put(nextStr, map.get(cur) + 1);
                q.offer(nextStr);
            }
        }

        System.out.println("-1");
    }
}
