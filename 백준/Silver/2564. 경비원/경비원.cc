#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int w, h;
	cin >> w;
	cin >> h;
	int store;
	cin >> store;
	int a[2][100] = { 0 };
	for (int i = 0;i < store;i++) {
		cin >> a[0][i];
		cin >> a[1][i];
	}
	int b[2];
	cin >> b[0];
	cin >> b[1];

	int dis = 0;

	switch (b[0]) {
	case 1:
		for (int i = 0;i < store;i++) {
			if (a[0][i] == 1) {
				dis += abs(a[1][i] - b[1]);
			}
			else if (a[0][i] == 2) {
				dis += min(a[1][i] + b[1], 2 * w - a[1][i] - b[1]) + h;
			}
			else if (a[0][i] == 3) {
				dis += a[1][i] + b[1];
			}
			else {
				dis += a[1][i] + w - b[1];
			}
		}
		break;
	case 2:
		for (int i = 0;i < store;i++) {
			if (a[0][i] == 1) {
				dis += min(a[1][i] + b[1], 2 * w - a[1][i] - b[1]) + h;
			}
			else if (a[0][i] == 2) {
				dis += abs(a[1][i] - b[1]);
			}
			else if (a[0][i] == 3) {
				dis += h - a[1][i] + b[1];
			}
			else {
				dis += h - a[1][i] + w - b[1];
			}
		}
		break;
	case 3:
		for (int i = 0;i < store;i++) {
			if (a[0][i] == 1) {
				dis += a[1][i] + b[1];
			}
			else if (a[0][i] == 2) {
				dis += a[0][i] + h - b[1];
			}
			else if (a[0][i] == 3) {
				dis += abs(a[1][i] - b[1]);
			}
			else {
				dis += min(a[1][i] + b[1], 2 * h - a[1][i] - b[1]) + w;
			}
		}
		break;
	case 4:
		for (int i = 0;i < store;i++) {
			if (a[0][i] == 1) {
				dis += w - a[1][i] + b[1];
			}
			else if (a[0][i] == 2) {
				dis += w - a[1][i] + h - b[1];
			}
			else if (a[0][i] == 3) {
				dis += min(a[1][i] + b[1], 2 * h - a[1][i] - b[1]) + w;
			}
			else {
				dis += abs(a[1][i] - b[1]);
			}
		}
		break;
	}
	cout << dis;

	return 0;
}