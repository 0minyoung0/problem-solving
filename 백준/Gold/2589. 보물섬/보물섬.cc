#include <iostream>
#include <string>
#include <algorithm>
#include <queue>
using namespace std;

int search(char c[50][50], int i, int j, int a, int b) {
	int length = 0;
	int d, e;
	queue<int> q1;
	queue<int> q2;
	int visit[50][50] = { 0 };
	visit[i][j] = 1;
	q1.push(i);
	q2.push(j);
	while (!q1.empty()) {
		d = q1.front();
		e = q2.front();
		q1.pop();
		q2.pop();
		if (d > 0) {
			if (c[d - 1][e] == 'L') {
				if (visit[d - 1][e] == 0) {
					visit[d - 1][e] = visit[d][e] + 1;
					if (length < visit[d][e] + 1) {
						length = visit[d][e] + 1;
					}
					q1.push(d - 1);
					q2.push(e);
				}
			}
		}
		if (e > 0) {
			if (c[d][e - 1] == 'L') {
				if (visit[d][e - 1] == 0) {
					visit[d][e - 1] = visit[d][e] + 1;
					if (length < visit[d][e] + 1) {
						length = visit[d][e] + 1;
					}
					q1.push(d);
					q2.push(e - 1);
				}
			}
		}
		if (d < a - 1) {
			if (c[d + 1][e] == 'L') {
				if (visit[d + 1][e] == 0) {
					visit[d + 1][e] = visit[d][e] + 1;
					if (length < visit[d][e] + 1) {
						length = visit[d][e] + 1;
					}
					q1.push(d + 1);
					q2.push(e);
				}
			}
		}
		if (e < b - 1) {
			if (c[d][e + 1] == 'L') {
				if (visit[d][e + 1] == 0) {
					visit[d][e + 1] = visit[d][e] + 1;
					if (length < visit[d][e] + 1) {
						length = visit[d][e] + 1;
					}
					q1.push(d);
					q2.push(e + 1);
				}
			}
		}
	}

	return length - 1;
}

int main(){
	int a, b;
	cin >> a;
	cin >> b;
	char c[50][50] = { 'X' };
	for (int i = 0;i < a;i++) {
		cin >> c[i];
	}
	int length = 0;
	for (int i = 0;i < a;i++) {
		for (int j = 0;j < b;j++) {
			if (c[i][j] == 'L') {
				if (length < search(c, i, j, a, b)) {
					length = search(c, i, j, a, b);
				}
			}
		}
	}
	cout << length;

	return 0;
}