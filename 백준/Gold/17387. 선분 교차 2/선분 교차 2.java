import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        System.out.print(crossCheck(x1, y1, x2, y2, x3, y3, x4, y4) ? 1 : 0);
    }

    private static boolean crossCheck(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int ccw1 = CCW(x1, y1, x2, y2, x3, y3);
        int ccw2 = CCW(x1, y1, x2, y2, x4, y4);
        int ccw3 = CCW(x3, y3, x4, y4, x1, y1);
        int ccw4 = CCW(x3, y3, x4, y4, x2, y2);
        // 선분이 겹치지 않고 교차하는 경우
        if ((ccw1 != 0 || ccw2 != 0) && ccw1 * ccw2 <= 0 && ccw3 * ccw4 <= 0) {
            return true;
        }
        // 선분이 겹치는 경우
        if (ccw1 == 0 && ccw2 == 0) {
            // x축에 평행한 경우
            if (y1 == y2) {
                if ((x1 <= x3 || x1 <= x4 || x2 <= x3 || x2 <= x4)
                && (x1 >= x3 || x1 >= x4 || x2 >= x3 || x2 >= x4)) {
                    return true;
                }
            }
            // x축에 평행하지 않은 경우
            else {
                if ((y1 <= y3 || y1 <= y4 || y2 <= y3 || y2 <= y4)
                && (y1 >= y3 || y1 >= y4 || y2 >= y3 || y2 >= y4)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 점 A (x1, y1), 점 B (x2, y2), 점 C (x3, y3)에 대하여 벡터 AB, 벡터 AC의 CCW 계산
     */
    private static int CCW (int x1, int y1, int x2, int y2, int x3, int y3) {
        long result = (long) (x2 - x1) * (y3 - y1) - (long) (x3 - x1) * (y2 - y1);
        return result < 0 ? -1 : result > 0 ? 1 : 0;
    }
}