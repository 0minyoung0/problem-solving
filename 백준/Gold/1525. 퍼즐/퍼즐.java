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

        int input = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                input = input * 10 + Integer.parseInt(st.nextToken());
            }
        }

        if (input == 123456780) {
            System.out.println("0");
            return;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(input, 0);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(input);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int cur = q.poll();
            int temp1 = cur;
            int zeroPos = 0;
            for (int i=0; i<9; i++) {
                if (temp1 % 10 != 0) {
                    temp1 /= 10;
                }
                else {
                    zeroPos = i;
                    break;
                }
            }
            int zeroPosX = zeroPos / 3;
            int zeroPosY = zeroPos % 3;
            for (int dir = 0; dir < 4; dir++) {
                int nextPosX = zeroPosX + dx[dir];
                int nextPosY = zeroPosY + dy[dir];
                if (nextPosX < 0 || nextPosX >= 3 || nextPosY < 0 || nextPosY >= 3) continue;
                int nextPos = nextPosX * 3 + nextPosY;
                int nextNum = cur % (pow10(nextPosX * 3 + nextPosY) * 10) / pow10(nextPosX * 3 + nextPosY);

                int next = cur + (pow10(zeroPos) - pow10(nextPos)) * nextNum;
                if (map.containsKey(next)) continue;
                if (next == 123456780) {
                    System.out.println(map.get(cur) + 1);
                    return;
                }
                map.put(next, map.get(cur) + 1);
                q.offer(next);
            }
        }

        System.out.println("-1");
    }
    private static int pow10 (int n) {
        int result = 1;
        while (n-- > 0) {
            result *= 10;
        }
        return result;
    }
}
