import java.util.*;

public class Solution {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
    	// 테스트 케이스의 수
    	int T = sc.nextInt();
    	
    	// 각 테스트 케이스 별로 실행
    	for (int t=1; t<=T; t++) {
    		
    		// 방의 한 변의 길이
    		int N = sc.nextInt();
    		
    		// 사람들의 좌표를 저장할 배열
    		int[][] person = new int[10][2];
    		int personN = 0;
    		
    		// 계단의 정보와 좌표를 저장할 배열 (0:계단길이, 1:x좌표, 2:y좌표)
    		int[][] stair = new int[2][3];
    		int stairN = 0;
    		
    		// 지도의 정보
    		int[][] map = new int[N][N];
    		for (int i=0; i<N; i++) {
    			for (int j=0; j<N; j++) {
    				map[i][j] = sc.nextInt();
    				
    				// 사람인 경우
    				if (map[i][j] == 1) {
    					person[personN][0] = i;
    					person[personN++][1] = j;
    				}
    				
    				// 계단인 경우
    				else if (map[i][j] > 1) {
    					stair[stairN][0] = map[i][j];
    					stair[stairN][1] = i;
    					stair[stairN++][2] = j;
    				}
    			}
    		}
    		
    		// 사람과 계단 사이의 거리
    		int[][] dis = new int[personN][2];
    		for (int i=0; i<personN; i++) {
    			for (int j=0; j<stairN; j++) {
    				dis[i][j] = Math.abs(person[i][0] - stair[j][1]) + Math.abs(person[i][1] - stair[j][2]);
    			}
    		}
    		
    		// 이동이 완료되는 최소의 시간을 저장할 변수
    		int ans = Integer.MAX_VALUE;
    		
    		// powerSet 경우의 수 계산하기 (비트마스킹)
    		for (int i=0; i<(1<<personN); i++) {
    			
    			// 시뮬레이션에 사용될 각 계단까지의 거리 + 1을 저장할 힙 선언
    			PriorityQueue<Integer> pq0 = new PriorityQueue<>();
    			PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    			
    			// 각 사람이 고른 계단에 따라 pq에 저장
    			for (int j=0; j<personN; j++) {

    				// 0번을 고른 경우
    				if ((i & (1<<j)) == 0) {
    					pq0.offer(dis[j][0] + 1);
    				}
    				// 1번을 고른 경우
    				else {
    					pq1.offer(dis[j][1] + 1);
    				}
    			}
    			
    			// 시뮬레이션에 사용될 각 계단의 상황을 나타낼 큐 (사람이 들어간 시각을 저장)
    			Queue<Integer> q0 = new ArrayDeque<>();
    			Queue<Integer> q1 = new ArrayDeque<>();
    			
    			// 이동 완료한 사람의 수를 셀 변수
    			int cnt = 0;
    			
    			// 현재 시각을 나타낼 변수
    			int time = 0;
    			
    			while (true) {
    				time++;
    				
    				// time이 이미 ans보다 커졌다면 시뮬레이션 종료
    				if (time > ans) {
    					break;
    				}
    				
    				// 이동 완료 체크
    				while (!q0.isEmpty() && time - q0.peek() == stair[0][0]) {
    					q0.poll();
    					cnt++;
    				}
    				while (!q1.isEmpty() && time - q1.peek() == stair[1][0]) {
    					q1.poll();
    					cnt++;
    				}
    				
    				// 모든 사람이 이동 완료했다면
    				if (cnt == personN) {
    					
    					// 현재 시각이 ans보다 작다면 갱신
    					if (ans > time) ans = time;
    					
    					// 시뮬레이션 종료
    					break;
    				}
    				
    				// 큐 사이즈가 3보다 작고 힙에서 현재 시각보다 작거나 같은 값을 가진 사람이 있다면
    				// 힙에서 제거하고 큐에 넣기
    				while (q0.size() < 3 && !pq0.isEmpty() && pq0.peek() <= time) {
    					pq0.poll();
    					q0.offer(time);
    				}
    				while (q1.size() < 3 && !pq1.isEmpty() && pq1.peek() <= time) {
    					pq1.poll();
    					q1.offer(time);
    				}
    			}
    		}
    		
    		// 답 출력
    		System.out.println("#" + t + " " + ans);
    	}
    }
}	
