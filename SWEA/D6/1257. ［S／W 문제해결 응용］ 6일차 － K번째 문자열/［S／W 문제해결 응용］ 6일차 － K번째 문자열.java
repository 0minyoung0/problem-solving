import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

            // 문자를 저장할 해시셋
            HashSet<String> set = new HashSet<>();
            
            // 부분 문자열 저장하기
            for (int i = 0; i < s.length(); i++) {
                for (int j = i+1; j <= s.length(); j++) {
                    set.add(s.substring(i, j));
                }
            }

            // 부분 문자열 List에 옮겨서 정렬
            List<String> list = new ArrayList<>(set);
            Collections.sort(list);

            // 답 출력
            System.out.println("#" + tc + " " + list.get(k-1));
        }
    }
}
