import java.io.*;
import java.util.*;

public class Main {
    static int C;
    static List<Integer> possibleSwitches = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            char[] S = br.readLine().toCharArray();
            int startState = 0;
            for (char c : S) {
                startState *= 2;
                if (c == '+') {
                    startState++;
                }
            }

            int[][] dp = new int[R + 1][(int) Math.pow(2, C)];
            dp[0][startState] = 1;
            Set<Integer> states = new HashSet<>();
            Set<Integer> newStates = new HashSet<>();
            states.add(startState);

            int[] switches = new int[R + 1];

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                switches[Integer.parseInt(st.nextToken())] += Math.pow(2, C - Integer.parseInt(st.nextToken()));
            }

            for (int i = 1; i <= R; i++) {
                possibleSwitches.clear();
                setSwitch(switches[i], 0);
                for (int pSwitches : possibleSwitches) {
                    for (int j : states) {
                        if (dp[i - 1][j] == 0) {
                            continue;
                        }
                        int nextState = j ^ pSwitches;
                        dp[i][nextState] = (dp[i][nextState] + dp[i - 1][j]) % 1_000_000_007;
                        newStates.add(nextState);
                    }
                }
                states = new HashSet<>(newStates);
                newStates.clear();
            }

            sb.append(dp[R][(int) Math.pow(2, C) - 1]).append('\n');
        }
        System.out.print(sb);
    }

    private static void setSwitch(int state, int depth) {
        if (depth >= C - 1) {
            possibleSwitches.add(state);
            return;
        }
        setSwitch(state, depth + 1);
        if ((state & (3 << (C - depth - 2))) == 0) {
            setSwitch(state | (3 << (C - depth - 2)), depth + 2);
        }
    }
}