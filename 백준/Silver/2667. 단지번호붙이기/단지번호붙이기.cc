#include <bits/stdc++.h>
using namespace std;

char house[26][26];
int vis[26][26];
int n_house[400];
int dx[4] = { 1,0,-1,0 };
int dy[4] = { 0,1,0,-1 };
#define X first
#define Y second

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n;
	cin >> n;
	for (int i = 0;i < n;i++) {
		cin >> house[i];
	}
	int num = 0;
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < n;j++) {
			if (house[i][j] == '1' && vis[i][j] == 0) {
				queue<pair<int, int>> q;
				q.push({ i,j });
				vis[i][j] = 1;
				int temp = 1;
				while (!q.empty()) {
					pair<int, int> cur = q.front();
					q.pop();
					for (int dir = 0;dir < 4;dir++) {
						int nx = cur.X + dx[dir];
						int ny = cur.Y + dy[dir];
						if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
							continue;
						}
						else if (house[nx][ny] == '0' || vis[nx][ny] == 1) {
							continue;
						}
						q.push({ nx,ny });
						vis[nx][ny] = 1;
						temp++;
					}
				}
				n_house[num] = temp;
				num++;
			}
		}
	}
	sort(n_house, n_house + num);
	cout << num << '\n';
	for (int i = 0;i < num;i++) {
		cout << n_house[i] << '\n';
	}
}