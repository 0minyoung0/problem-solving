#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <algorithm>

typedef long long ll;
const int INF = 1e9 + 7;
const int LEN = 201;

int K, N, T, A[LEN], D[LEN];
ll dp[LEN][2], ret[LEN];

ll solve() {
	std::cin >> N >> T;
	for (int i = 1; i <= N; ++i) std::cin >> D[i] >> A[i];
	dp[0][1] = T;
	for (int i = 1; i <= N; ++i) {
		dp[i][0] = dp[i][1] = ret[i - 1] + T;
		ll cost = 0, S = 0;
		for (int j = i; j > 0; --j) {
			cost += (S += A[j]) * (D[j] - D[j - 1]);
			dp[i][0] = std::min(dp[i][0], dp[j - 1][1] + cost);
		}
		cost = 0, S = 0;
		for (int j = i - 1; j > 0; --j) {
			cost += (ll)A[j] * (D[i] - D[j]);
			dp[i][1] = std::min(dp[i][1], ret[j - 1] + cost + T);
		}
		ret[i] = std::min(dp[i][0], dp[i][1]);
	}
	// for (int i = 1; i <= N; ++i) std::cout << ret[i] << ' ';
	return ret[N];
}

int main() {
	// freopen("input.txt", "r", stdin);
    std::cin.tie(0)->sync_with_stdio(0);
	std::cin >> K;
	for (int k = 1; k <= K; ++k) {
		std::cout << "Data Set " << k << ":\n";
		std::cout << solve() << "\n\n";
	}
}