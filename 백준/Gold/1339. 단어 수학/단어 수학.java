import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 단어의 개수
        int N = Integer.parseInt(br.readLine());

        // 알파벳을 인덱스로 변환하기 위한 해시맵
        HashMap<Character, Integer> ctoi = new HashMap<>();

        // 문자별 배수 계산
        int[] mul = new int[10];

        // 단어 입력 받기
        String[] words = new String[N];
        for (int i=0; i<N; i++) {
            words[i] = br.readLine();
            int temp = 1;
            for (int j=0; j<words[i].length()-1; j++) {
                temp *= 10;
            }
            for (int j=0; j<words[i].length(); j++) {
                if (!ctoi.containsKey(words[i].charAt(j))) {
                    ctoi.put(words[i].charAt(j), ctoi.size());
                }
                mul[ctoi.get(words[i].charAt(j))] += temp;
                temp /= 10;
            }
        }

        // 배수 순차적으로 정렬
        Arrays.sort(mul);

        // 답 계산
        int ans = 0;
        for (int i=1; i<=9; i++) {
            ans += mul[i] * i;
        }
        System.out.println(ans);
    }
}