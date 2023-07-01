import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 가지의 품종 수
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] eggplants = new char[n+1];
        for(int i = 1; i <= n; i++) {
            eggplants[i] = st.nextToken().charAt(0);
        }

        st = new StringTokenizer(br.readLine());

        // 조수의 수
        int m = Integer.parseInt(st.nextToken());
        // 품종의 수
        int k = Integer.parseInt(st.nextToken());

        boolean makeW = false;
        // 조수마다
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            boolean isP = false;
            // 가지 선택하기 (하나라도 보라색이 섞이면 흰색을 못 만듦)
            for(int j = 0; j < k; j++) {
                if(eggplants[Integer.parseInt(st.nextToken())] == 'P') {
                    isP = true;
                    break;
                }

            }
            if(!isP) {
                makeW = true;
            }
        }

        // 조수가 하나라도 흰색을 만들 수 있으면 W
        if(makeW) {
            System.out.println("W");
        } else {
            System.out.println("P");
        }
    }
}