import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 격자의 크기
        int N = Integer.parseInt(br.readLine());

        // 학생들의 순서와 각 학생이 선호하는 학생의 번호
        int[] order = new int[N * N];
        Set[] data = new Set[N * N + 1];
        for (int i = 0; i < N * N; i++) {
            st = new StringTokenizer(br.readLine());
            order[i] = Integer.parseInt(st.nextToken());
            data[order[i]] = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                data[order[i]].add(Integer.parseInt(st.nextToken()));
            }
        }

        // 교실에 앉은 학생 번호
        int[][] studentNum = new int[N + 2][N + 2];

        // 델타배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 학생들 순서대로 자리에 앉히기
        for (int cur : order) {
            // x좌표, y좌표, 최대 점수(좋아하는 학생과 인접할때마다 +10, 주변의 빈자리마다 +1)
            int[] curResult = new int[]{-1, -1, -1};

            // 모든 자리에 대해서 체크
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    // 이미 누가 앉아있으면 스킵
                    if (studentNum[i][j] != 0) {
                        continue;
                    }

                    // 아무도 안앉아있으면 주변 탐색을 통해 현재 위치의 점수 계산
                    int temp = 0;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = i + dx[dir];
                        int ny = j + dy[dir];
                        if (nx < 1 || nx > N || ny < 1 || ny > N) {
                            continue;
                        }
                        if (studentNum[nx][ny] == 0) {
                            temp++;
                            continue;
                        }
                        if (data[cur].contains(studentNum[nx][ny])) {
                            temp += 10;
                        }
                    }
                    if (curResult[2] < temp) {
                        curResult = new int[]{i, j, temp};
                    }
                }
            }

            // 최대 점수에 해당하는 자리에 앉히기
            studentNum[curResult[0]][curResult[1]] = cur;
        }

        // 앉힌 학생들로부터 만족도 계산하기
        int ans = 0;
        int[] score = new int[]{0, 1, 10, 100, 1000};
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int cnt = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if (data[studentNum[i][j]].contains(studentNum[nx][ny])) {
                        cnt++;
                    }
                }
                if (cnt != 0) {
                    ans += score[cnt];
                }
            }
        }

        // 답 출력
        System.out.print(ans);
    }
}
