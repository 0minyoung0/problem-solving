import java.util.*;
import java.io.*;

public class Main
{
    static int K, ans;
    static List<int[]>[] listArr;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 각 점을 저장할 리스트 배열
        listArr = new List[K+1];
        for (int i=1; i<=K; i++) {
            listArr[i] = new ArrayList<>();
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            listArr[k].add(new int[] {x, y});
        }

        ans = 4_000_000;

        function(0, 1000, -1000, 1000, -1000);

        System.out.print(ans);
    }
    private static void function(int k, int minX, int maxX, int minY, int maxY) {
        if (k == K) {
            ans = Math.min(ans, (maxX - minX) * (maxY - minY));
            return;
        }
        for (int[] point : listArr[k+1]) {
            int newMinX = Math.min(point[0], minX);
            int newMaxX = Math.max(point[0], maxX);
            int newMinY = Math.min(point[1], minY);
            int newMaxY = Math.max(point[1], maxY);
            if (ans > (newMaxX - newMinX) * (newMaxY - newMinY)) {
                function(k+1, newMinX, newMaxX, newMinY, newMaxY);
            }
        }
    }
}