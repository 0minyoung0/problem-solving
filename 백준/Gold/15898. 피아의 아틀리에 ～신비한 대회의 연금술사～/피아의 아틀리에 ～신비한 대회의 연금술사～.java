import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int ans;
    static int[][][][] candidate;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 재료의 개수
        n = Integer.parseInt(br.readLine());

        // 재료 정보
        candidate = new int[n][4][4][2];
        for (int[][][] c : candidate) {
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    c[i][j][0] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    switch (st.nextToken()) {
                        case "R":
                            c[i][j][1] = 7;
                            break;
                        case "B":
                            c[i][j][1] = 5;
                            break;
                        case "G":
                            c[i][j][1] = 3;
                            break;
                        case "Y":
                            c[i][j][1] = 2;
                            break;
                        case "W":
                            c[i][j][1] = 0;
                            break;
                    }
                }
            }
        }

        // 사용여부
        used = new boolean[n];

        // 첫번째 재료를 넣은 가마의 정보
        for (int i = 0; i < n; i++) {
            used[i] = true;

            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {

                    int[][][] pot = new int[5][5][2];
                    for (int l = 0; l < 4; l++) {
                        for (int m = 0; m < 4; m++) {
                            if (candidate[i][l][m][0] > 0) {
                                pot[j + l][k + m][0] = candidate[i][l][m][0];
                            }
                            pot[j + l][k + m][1] = candidate[i][l][m][1];
                        }
                    }

                    func(1, pot);
                }
            }

            used[i] = false;
        }

        // 답 출력
        System.out.print(ans);
    }

    private static void func(int level, int[][][] pot) {
        if (level == 3) {
            int temp = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    temp += pot[i][j][0] * pot[i][j][1];
                }
            }
            if (ans < temp) {
                ans = temp;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;

            // 몇번 돌릴지, 어디 넣을지 정해보자구
            for (int turn = 0; turn < 4; turn++) {

                // 재료 돌려가면서 넣어보자구~~
                int[][][] arr = new int[4][4][2];
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        arr[j][k][0] = candidate[i][j][k][0];
                        arr[j][k][1] = candidate[i][j][k][1];
                    }
                }
                for (int j = 0; j < turn; j++) {
                    arr = turnArr(arr);
                }

                for (int x = 0; x < 2; x++) {
                    for (int y = 0; y < 2; y++) {

                        // 새 가마에 재료 넣기
                        int[][][] newPot = new int[5][5][2];
                        for (int j = 0; j < 5; j++) {
                            for (int k = 0; k < 5; k++) {
                                newPot[j][k][0] = pot[j][k][0];
                                newPot[j][k][1] = pot[j][k][1];
                            }
                        }
                        for (int j = 0; j < 4; j++) {
                            for (int k = 0; k < 4; k++) {
                                newPot[j + x][k + y][0] += arr[j][k][0];
                                if (newPot[j + x][k + y][0] < 0) {
                                    newPot[j + x][k + y][0] = 0;
                                } else if (newPot[j + x][k + y][0] > 9) {
                                    newPot[j + x][k + y][0] = 9;
                                }

                                if (arr[j][k][1] != 0) {
                                    newPot[j + x][k + y][1] = arr[j][k][1];
                                }
                            }
                        }

                        // 재료 들어갔으니까 호출해보자구~~
                        func(level + 1, newPot);
                    }
                }
            }

            used[i] = false;
        }
    }

    private static int[][][] turnArr(int[][][] arr) {
        int[][][] newArr = new int[4][4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newArr[i][j] = arr[3 - j][i];
            }
        }
        return newArr;
    }
}