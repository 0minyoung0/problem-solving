import java.io.*;
import java.util.*;

public class Main {

    static List<int[]> points;

    static final int MAX = 987_654_321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
        }

        Collections.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        System.out.println(shortestDistance(0, n));
    }

    private static int shortestDistance(int sIdx, int eIdx) {
        if (eIdx - sIdx == 1) {
            return MAX;
        }
        int mIdx = (sIdx + eIdx) / 2;
        int d = Math.min(shortestDistance(sIdx, mIdx), shortestDistance(mIdx, eIdx));

        List<int[]> boundaryList = new ArrayList<>();
        for (int i = sIdx; i < eIdx; i++) {
            if (square(points.get(i)[0] - points.get(mIdx)[0]) <= d) {
                boundaryList.add(points.get(i));
            }
        }
        Collections.sort(boundaryList, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        for (int i = 0; i < boundaryList.size(); i++) {
            for (int j = i + 1; j < boundaryList.size(); j++) {
                if (square(boundaryList.get(j)[1] - boundaryList.get(i)[1]) >= d) {
                    break;
                }
                int temp = calculateDistance(boundaryList.get(i), boundaryList.get(j));
                if (d > temp) {
                    d = temp;
                }
            }
        }

        return d;
    }

    private static int calculateDistance(int[] p1, int[] p2) {
        return square(p1[0] - p2[0]) + square(p1[1] - p2[1]);
    }

    private static int square(int x) {
        return x * x;
    }
}
