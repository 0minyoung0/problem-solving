#include <bits/stdc++.h>
using namespace std;

int dis[1000001];

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int f, s, g, u, d;
	cin >> f >> s >> g >> u >> d;
	if (s == g) {
		cout << 0;
		return 0;
	}
	for (int i = 1;i <= f;i++) {
		if (i != s) {
			dis[i] = -1;
		}
	}
	queue<int> q;
	q.push(s);
	int ans = 0;
	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		for (int dir = 0;dir < 2;dir++) {
			int nx;
			if (dir == 0) {
				nx = cur + u;
			}
			else { // dir == 1
				nx = cur - d;
			}
			if (nx<1 || nx>f) {
				continue;
			}
			else if (dis[nx] >= 0) {
				continue;
			}
			dis[nx] = dis[cur] + 1;
			if (nx == g) {
				cout << dis[nx];
				return 0;
			}
			q.push(nx);
			if (dis[nx] > ans) {
				ans = dis[nx];
			}
		}
	}
	cout << "use the stairs";
}