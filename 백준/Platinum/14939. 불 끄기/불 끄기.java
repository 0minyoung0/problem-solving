import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] on = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            String row = br.readLine();
            for (int j = 0; j < 10; j++) {
                if (row.charAt(j) == 'O') {
                    on[i][j] = true;
                }
            }
        }

        // 답을 저장할 변수
        int ans = 101;

        // 비트마스킹으로 첫번째 줄을 켜고 끄는 모든 경우의 수 확인
        find: for (int i=0; i<(1<<10); i++) {

            // 스위치 누른 횟수 확인을 위한 변수
            int cnt = 0;

            // 시뮬레이션을 위한 복사본 만들기
            boolean[][] copy = new boolean[10][];
            for (int j=0; j<10; j++) {
                copy[j] = Arrays.copyOf(on[j], 10);
            }

            // i에 따라 첫번째 줄의 스위치 누르기
            for (int j=0; j<10; j++) {
                if ((i & (1<<j)) != 0) {
                    // 현재 위치 누르기
                    copy[0][j] = !copy[0][j];
                    // 아래 위치 누르기
                    copy[1][j] = !copy[1][j];
                    // j가 0이 아닌 경우 왼쪽도 누르기
                    if (j != 0) copy[0][j-1] = !copy[0][j-1];
                    // j가 9가 아닌 경우 오른쪽도 누르기
                    if (j != 9) copy[0][j+1] = !copy[0][j+1];
                    // 스위치 누른 횟수 증가
                    cnt++;
                }
            }

            // 2 ~ 10번째 줄은 자기 위의 전구가 켜진 경우만 스위치 누르기
            for (int r=1; r<10; r++) {
                for (int j=0; j<10; j++) {
                    // 위가 켜지지 않은 경우 continue
                    if (!copy[r-1][j]) continue;
                    // 위가 켜진 경우 현재 위치 누르기
                    copy[r][j] = !copy[r][j];
                    // j가 0이 아닌 경우 왼쪽도 누르기
                    if (j != 0) copy[r][j-1] = !copy[r][j-1];
                    // j가 9가 아닌 경우 오른쪽도 누르기
                    if (j != 9) copy[r][j+1] = !copy[r][j+1];
                    // r이 9가 아닌 경우 아래도 누르기
                    if (r != 9) copy[r+1][j] = !copy[r+1][j];
                    // 스위치 누른 횟수 증가
                    cnt++;
                }
            }

            // 마지막 행이 하나라도 켜져있다면 continue
            for (int j=0; j<10; j++) {
                if (copy[9][j]) continue find;
            }

            // 마지막 행이 전부 꺼져있다면 스위치 누른 횟수 갱신
            if (ans > cnt) {
                ans = cnt;
            }
        }

        // 불가능한 경우
        if (ans == 101) {
            ans = -1;
        }
        System.out.print(ans);
    }
}
