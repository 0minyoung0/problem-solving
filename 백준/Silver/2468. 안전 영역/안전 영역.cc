#include <bits/stdc++.h>
using namespace std;

#define X first
#define Y second
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
int a[101][101];
int vis[101][101];

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < n;j++) {
			cin >> a[i][j];
		}
	}
	int mx = 1;
	for (int i = 1;i < 100;i++) {
		for (int j = 0;j < n;j++) {
			for (int k = 0;k < n;k++) {
				vis[j][k] = 0;
			}
		}
		int temp = 0;
		for (int j = 0;j < n;j++) {
			for (int k = 0;k < n;k++) {
				if (vis[j][k] == 0 && a[j][k] > i) {
					queue<pair<int, int>> q;
					q.push({ j,k });
					vis[j][k] = 1;
					temp++;
					while (!q.empty()) {
						pair<int, int> cur = q.front();
						q.pop();
						for (int dir = 0;dir < 4;dir++) {
							int nx = cur.X + dx[dir];
							int ny = cur.Y + dy[dir];
							if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
								continue;
							}
							else if (vis[nx][ny] == 1 || a[nx][ny] <= i) {
								continue;
							}
							q.push({ nx,ny });
							vis[nx][ny] = 1;
						}
					}
				}
			}
		}
		if (temp > mx) {
			mx = temp;
		}
	}
	cout << mx;
}