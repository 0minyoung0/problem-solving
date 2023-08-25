import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 한국에 있는 도시의 수
        int N = Integer.parseInt(st.nextToken());
        // 1인당 내일로 티켓의 가격
        int R = Integer.parseInt(st.nextToken()) * 2;

        // 도시의 이름을 key, 도시의 번호를 value로 하는 맵
        Map<String, Integer> cityMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            String city = st.nextToken();
            if (!cityMap.containsKey(city)) {
                cityMap.put(city, cityMap.size() + 1);
            }
        }
        // 도시의 수를 중복 제거한 값으로 저장
        N = cityMap.size();

        // 여행할 도시의 수
        int M = Integer.parseInt(br.readLine());

        // 여행할 도시 정보
        int[] travelCityNum = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            travelCityNum[i] = cityMap.get(st.nextToken());
        }

        // 교통 수단의 수
        int K = Integer.parseInt(br.readLine());
        
        // 티켓 없는 경우, 있는 경우의 비용을 저장할 이중 배열
        int[][] cost1 = new int[N+1][N+1];
        int[][] cost2 = new int[N+1][N+1];
        for (int i=1; i<=N; i++) {
            Arrays.fill(cost1[i], 100000000);
            Arrays.fill(cost2[i], 100000000);
            cost1[i][i] = 0;
            cost2[i][i] = 0;
        }

        // 교통수단 저장
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int sCity = cityMap.get(st.nextToken());
            int eCity = cityMap.get(st.nextToken());
            int cost = Integer.parseInt(st.nextToken()) * 2;

            if (cost1[sCity][eCity] > cost) {
                cost1[sCity][eCity] = cost;
                cost1[eCity][sCity] = cost;
            }

            if (type.equals("Mugunghwa") || type.equals("ITX-Saemaeul") || type.equals("ITX-Cheongchun")) {
                cost = 0;
            }
            else if (type.equals("S-Train") || type.equals("V-Train")) {
                cost /= 2;
            }

            if (cost2[sCity][eCity] > cost) {
                cost2[sCity][eCity] = cost;
                cost2[eCity][sCity] = cost;
            }
        }

        // 플로이드-워셜
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    if (cost1[i][j] > cost1[i][k] + cost1[k][j]) {
                        cost1[i][j] = cost1[i][k] + cost1[k][j];
                    }
                    if (cost2[i][j] > cost2[i][k] + cost2[k][j]) {
                        cost2[i][j] = cost2[i][k] + cost2[k][j];
                    }
                }
            }
        }

        // 내일로 티켓을 살때의 비용에서 내일로 티켓을 안살때의 비용을 빼기
        int ans1 = 0;
        int ans2 = R;
        for (int i=0; i<M-1; i++) {
            ans1 += cost1[travelCityNum[i]][travelCityNum[i+1]];
            ans2 += cost2[travelCityNum[i]][travelCityNum[i+1]];
        }
        if ((ans2 - ans1) < 0) System.out.print("Yes");
        else System.out.print("No");
    }
}
