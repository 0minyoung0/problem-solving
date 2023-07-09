import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스별로 실행
        for (int tc=1; tc<=T; tc++) {

            // 정수 k
            int k = Integer.parseInt(br.readLine());

            // 문자열
            String s = br.readLine();

            // 문자를 저장할 배열
            String[] arr = new String[s.length()];

            // 문자 저장
            for (int i=0; i<s.length(); i++) {
                arr[i] = s.substring(i);
            }

            // 문자 배열 정렬
            Arrays.parallelSort(arr);

            // 답 출력
            System.out.println("#" + tc + " " + arr[k-1]);
        }
    }
}
