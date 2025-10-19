import java.io.*;
import java.util.*;

public class Main {
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            int[] cardA = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cardA[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> listA = new ArrayList<>();
            bt(-1, 0, 0, cardA, listA);
            Collections.sort(listA);

            int[] cardB = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                cardB[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer> listB = new ArrayList<>();
            bt(-1, 0, 0, cardB, listB);
            Collections.sort(listB);

            int min = Integer.MAX_VALUE;
            int idxA = 0;
            int idxB = 0;
            while (true) {
                if (idxA == listA.size() || idxB == listB.size()) {
                    break;
                }

                int itemA = listA.get(idxA);
                int itemB = listB.get(idxB);
                int diff = Math.abs(itemA - itemB);
                if (min > diff) {
                    min = diff;
                }

                if (itemA < itemB) {
                    idxA++;
                } else if (itemA > itemB) {
                    idxB++;
                } else {
                    break;
                }
            }

            int max = Math.max(
                    Math.abs(listA.get(0) - listB.get(listB.size() - 1)),
                    Math.abs(listB.get(0) - listA.get(listA.size() - 1)));

            System.out.println(min + " " + max);
        }
    }

    private static void bt(int prevIdx, int curLevel, int curSum, int[] card, List<Integer> list) {
        if (curLevel == k) {
            list.add(curSum);
            return;
        }

        for (int i = prevIdx + 1; i < card.length; i++) {
            bt(i, curLevel + 1, curSum + card[i], card, list);
        }
    }
}
