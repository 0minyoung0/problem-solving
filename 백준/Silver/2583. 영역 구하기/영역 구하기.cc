#include <bits/stdc++.h>
using namespace std;

int dat[101][101];
bool vis[101][101];
int a[50];
#define X first
#define Y second

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int m, n, k;
	cin >> m >> n >> k;
	while (k--) {
		int x1, y1, x2, y2;
		cin >> x1 >> y1 >> x2 >> y2;
		for (int i = y1;i < y2;i++) {
			for (int j = x1;j < x2;j++) {
				dat[i][j] = 1;
			}
		}
	}
	int ans = 0;
	int dx[4] = { 1,0,-1,0 };
	int dy[4] = { 0,1,0,-1 };
	int temp = 0;
	for (int i = 0;i < m;i++) {
		for (int j = 0;j < n;j++) {
			int area = 0;
			if (dat[i][j] == 0 && vis[i][j] == 0) {
				ans++;
				queue<pair<int, int>> q;
				q.push({ i,j });
				vis[i][j] = 1;
				area = 1;
				while (!q.empty()) {
					pair<int, int> cur = q.front();
					q.pop();
					for (int dir = 0;dir < 4;dir++) {
						int nx = cur.X + dx[dir];
						int ny = cur.Y + dy[dir];
						if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
							continue;
						}
						else if (dat[nx][ny] == 1 || vis[nx][ny] == 1) {
							continue;
						}
						q.push({ nx,ny });
						vis[nx][ny] = 1;
						area++;
					}
				}
			}
			if (area > 0) {
				a[temp] = area;
				temp++;
			}
		}
	}
	cout << ans << '\n';
	sort(a, a + temp);
	for (int i = 0;i < temp;i++) {
		cout << a[i] << ' ';
	}
}