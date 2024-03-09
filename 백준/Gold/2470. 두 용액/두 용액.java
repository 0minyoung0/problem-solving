import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 전체 용액의 수
        int N = Integer.parseInt(br.readLine());
        // 용액의 특성값 저장 후 정렬
        int[] solutions = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.parallelSort(solutions);

        // 기준 용액 합성 정보
        int s = 0;
        int e = solutions.length - 1;
        int standard = solutions[s] + solutions[e];
        int temp = standard;

        // 출력할 용액 정보
        int ans1 = s;
        int ans2 = e;

        // 투포인터로 용액 찾기
        while (standard != 0 && s + 1 < e) {

            // 다음 용액 세트 탐색
            if (temp < 0) s++;
            else e--;

            // 합성 특성값 계산
            temp = solutions[s] + solutions[e];
            if (Math.abs(temp) < Math.abs(standard)) {
                standard = temp;
                ans1 = s;
                ans2 = e;
            }
        }

        // 답 출력
        System.out.print(solutions[ans1] + " " + solutions[ans2]);
    }
}