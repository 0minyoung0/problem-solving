import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            boolean[][][] filled = new boolean[100][100][4];

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int O = Integer.parseInt(st.nextToken());
                int D = Integer.parseInt(st.nextToken());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                if (O == 1) {
                    find: for (int x = X - 1; x >= X - D; x--) {
                        for (int y = Y; y < Y + D; y++) {
                            int diff = (X - x) + (y - Y);
                            if (diff == D) {
                                filled[x][y][1] = true;
                                filled[x][y][2] = true;
                                continue find;
                            }
                            Arrays.fill(filled[x][y], true);
                        }
                    }
                } else if (O == 2) {
                    find: for (int x = X; x < X + D; x++) {
                        for (int y = Y; y < Y + D; y++) {
                            int diff = (x - X) + (y - Y);
                            if (diff == D - 1) {
                                filled[x][y][2] = true;
                                filled[x][y][3] = true;
                                continue find;
                            }
                            Arrays.fill(filled[x][y], true);
                        }
                    }
                } else if (O == 3) {
                    find: for (int x = X - 1; x >= X - D; x--) {
                        for (int y = Y - 1; y >= Y - D; y--) {
                            int diff = (X - x) + (Y - y);
                            if (diff == D + 1) {
                                filled[x][y][0] = true;
                                filled[x][y][1] = true;
                                continue find;
                            }
                            Arrays.fill(filled[x][y], true);
                        }
                    }
                } else { // O == 4
                    find: for (int x = X; x < X + D; x++) {
                        for (int y = Y - 1; y >= Y - D; y--) {
                            int diff = (x - X) + (Y - y);
                            if (diff == D) {
                                filled[x][y][0] = true;
                                filled[x][y][3] = true;
                                continue find;
                            }
                            Arrays.fill(filled[x][y], true);
                        }
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (filled[i][j][k]) {
                            count++;
                        }
                    }
                }
            }
            System.out.printf("%.2f\n", (double) count / 4);
        }
    }
}
