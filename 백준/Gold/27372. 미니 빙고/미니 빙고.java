import java.io.*;
import java.util.*;

public class Main {
    static HashMap<Character, Integer> ctoi;
    static String S;
    static char[][] grid;
    static int[] score;
    static int[] count;
    static char[] sortedS;
    static boolean findAns;
    static boolean[] isUsed;
    static char[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ctoi = new HashMap<>();
        while (T-- > 0) {
            ctoi.clear();
            S = br.readLine();
            grid = new char[3][];
            for (int i = 0; i < 3; i++) {
                grid[i] = br.readLine().toCharArray();
                for (int j = 0; j < 3; j++) {
                    ctoi.put(grid[i][j], 3 * i + j);
                }
            }

            score = new int[9];
            count = new int[8];
            for (int i = 0; i < 9; i++) {
                int idx = ctoi.get(S.charAt(i));
                if (idx / 3 == 0 && ++count[0] == 3) score[i]++;
                if (idx / 3 == 1 && ++count[1] == 3) score[i]++;
                if (idx / 3 == 2 && ++count[2] == 3) score[i]++;
                if (idx % 3 == 0 && ++count[3] == 3) score[i]++;
                if (idx % 3 == 1 && ++count[4] == 3) score[i]++;
                if (idx % 3 == 2 && ++count[5] == 3) score[i]++;
                if (idx / 3 == idx % 3 && ++count[6] == 3) score[i]++;
                if (idx / 3 + idx % 3 == 2 && ++count[7] == 3) score[i]++;
                sb.append(score[i]);
            }
            
            sortedS = S.toCharArray();
            Arrays.sort(sortedS);
            
            count = new int[8];
            isUsed = new boolean[9];
            findAns = false;
            ans = new char[9];
            bt(0);
            
            sb.append(' ');
            for (int i = 0; i < 9; i++) sb.append(ans[i]);
            sb.append('\n');
        }

        System.out.print(sb);
    }
    private static void bt(int depth) {
        if (depth == 9) {
            findAns = true;
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (findAns) return;
            if (isUsed[i]) continue;
            int idx = ctoi.get(sortedS[i]);
            int curScore = 0;
            if (idx / 3 == 0 && ++count[0] == 3) curScore++;
            if (idx / 3 == 1 && ++count[1] == 3) curScore++;
            if (idx / 3 == 2 && ++count[2] == 3) curScore++;
            if (idx % 3 == 0 && ++count[3] == 3) curScore++;
            if (idx % 3 == 1 && ++count[4] == 3) curScore++;
            if (idx % 3 == 2 && ++count[5] == 3) curScore++;
            if (idx / 3 == idx % 3 && ++count[6] == 3) curScore++;
            if (idx / 3 + idx % 3 == 2 && ++count[7] == 3) curScore++;

            if (score[depth] == curScore) {
                ans[depth] = sortedS[i];
                isUsed[i] = true;
                bt(depth + 1);
                isUsed[i] = false;
            }

            if (idx / 3 == 0) count[0]--;
            if (idx / 3 == 1) count[1]--;
            if (idx / 3 == 2) count[2]--;
            if (idx % 3 == 0) count[3]--;
            if (idx % 3 == 1) count[4]--;
            if (idx % 3 == 2) count[5]--;
            if (idx / 3 == idx % 3) count[6]--;
            if (idx / 3 + idx % 3 == 2) count[7]--;
        }
    }
}