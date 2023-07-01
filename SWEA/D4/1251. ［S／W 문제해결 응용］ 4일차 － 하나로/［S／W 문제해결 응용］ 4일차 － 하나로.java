import java.util.*;
 
public class Solution {
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        // 테스트 케이스의 수
        int T = sc.nextInt();
         
        // 각 테스트 케이스 별로 실행
        for (int t=1; t<=T; t++) {
 
            // 섬의 개수
            int N = sc.nextInt();
             
            // 각 섬들의 x좌표
            long[] x = new long[N];
            for (int i=0; i<N; i++) {
                x[i] = sc.nextLong();
            }
             
            // 각 섬들의 y좌표
            long[] y = new long[N];
            for (int i=0; i<N; i++) {
                y[i] = sc.nextLong();
            }
             
            // 환경 부담 세율
            double e = sc.nextDouble();
             
            // 모든 해저 터널 길이 계산해서 인접 리스트에 넣기
            List<long[]>[] adj = new List[N];
            for (int i=0; i<N; i++) {
            	adj[i] = new ArrayList<>();
            }
            for (int i=0; i<N; i++) {
                for (int j=i+1; j<N; j++) {
                	long dx = x[i]-x[j];
                	long dy = y[i]-y[j];
                	long cost = dx*dx+dy*dy;
                    adj[i].add(new long[] {cost, j});
                    adj[j].add(new long[] {cost, i});
                }
            }
            
            // 프림 알고리즘에 사용할 우선순위 큐
            PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            	public int compare(long[] o1, long[] o2) {
            		if (o1[0] < o2[0]) return -1;
            		if (o1[0] > o2[0]) return 1;
            		return (int)(o1[1] - o2[1]);
            	}
            });
            
            // 연결된 노드를 체크할 boolean 배열
            boolean[] check = new boolean[N];
             
            // 해저 터널 길이를 저장할 변수
            long ans = 0;
            
            // 프림 알고리즘
            int cnt = 0;
            check[0] = true;
            for (long[] ad : adj[0]) {
            	pq.offer(ad);
            }
            while (!pq.isEmpty() && cnt<N-1) {
            	long[] cur = pq.poll();
            	int node = (int)cur[1];
            	if (check[node]) continue;
            	
            	check[node] = true;
            	ans += cur[0];
            	
            	for (long[] ad : adj[node]) {
            		int n = (int)ad[1];
            		if (check[n]) continue;
            		
            		pq.offer(ad);
            	}
            }
             
            // 답 출력
            System.out.println("#" + t + " " + Math.round(ans * e));
        }
    }
}   