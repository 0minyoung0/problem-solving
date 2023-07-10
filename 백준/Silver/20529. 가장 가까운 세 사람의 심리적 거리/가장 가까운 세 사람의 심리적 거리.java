import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스 별로 실행
        while (T-- > 0) {

            // 학생의 수 N
            int N = Integer.parseInt(br.readLine());

            // n이 33이상이면 답은 0
            if (N >= 33) {
                br.readLine();
                System.out.println(0);
                continue;
            }

            // 각 학생의 MBTI 성격 유형
            String[] mbti = new String[N];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++) {
                mbti[i] = st.nextToken();
            }

            // 답을 저장할 변수
            int ans = 8;
            
            // 완전탐색으로 답 계산
            find: for (int i=0; i<N-2; i++) {
                for (int j=i+1; j<N-1; j++) {
                    int temp1 = mindDist(mbti[i], mbti[j]);
                    for (int k=j+1; k<N; k++) {
                        int temp2 = temp1 + mindDist(mbti[i], mbti[k]) + mindDist(mbti[j], mbti[k]);
                        if (ans > temp2) {
                            ans = temp2;
                            if (ans == 0) break find;
                        }
                    }
                }
            }

            // 답 출력
            System.out.println(ans);
        }
    }
    private static int mindDist(String s1, String s2) {
        int result = 0;
        for (int i=0; i<4; i++) {
            if (s1.charAt(i) != s2.charAt(i)) result++;
        }
        return result;
    }
}
