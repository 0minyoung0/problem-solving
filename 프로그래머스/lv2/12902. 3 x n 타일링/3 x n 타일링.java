class Solution {
    public int solution(int n) {
        // n이 홀수인 경우 0 리턴
        if (n % 2 == 1) return 0;
        
        // n이 2인 경우
        if (n == 2) return 3;
        // n이 4인 경우
        if (n == 4) return 11;
        
        // dp로 경우의 수 계산
        long[] dp = new long[n / 2 + 1];
        dp[1] = 3;
        dp[2] = dp[1] * dp[1] + 2;
        for (int i=3; i<=n/2; i++) {
            dp[i] = (dp[i-1] * dp[1] + 2) % 1_000_000_007;
            for (int j=i-2; j>=1; j--) {
                dp[i] = (dp[i] + dp[j] * 2) % 1_000_000_007;
            }
        }
        
        return (int)dp[n/2];
    }
}