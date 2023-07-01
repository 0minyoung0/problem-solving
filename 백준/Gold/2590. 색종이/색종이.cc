#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int a[6];
	for (int i = 0;i < 6;i++) {
		cin >> a[i];
	}
	int answer = 0;

	answer += a[5];
	a[5] = 0;

	answer += a[4];
	if (a[0] < 11 * a[4]) {
		a[0] = 0;
	}
	else {
		a[0] -= 11 * a[4];
	}
	a[4] = 0;

	answer += a[3];
	if (a[0] + 4 * a[1] < 20 * a[3]) {
		a[0] = 0;
		a[1] = 0;
	}
	else if (a[1] >= 5 * a[3]) {
		a[1] -= 5 * a[3];
	}
	else {
		a[0] -= 20 * a[3] - 4 * a[1];
		a[1] = 0;
	}
	a[3] = 0;

	answer += a[2] / 4;
	a[2] %= 4;
	switch (a[2]) {
		case 0:
			break;
		case 1:
			if (a[1] <= 5) {
				if (a[0] <= 27 - 4 * a[1]) {
					a[0] = 0;
					a[1] = 0;
				}
				else {
					a[0] -= 27 - 4 * a[1];
					a[1] = 0;
				}
			}
			else {
				a[1] -= 5;
				if (a[0] <= 7) {
					a[0] = 0;
				}
				else {
					a[0] -= 7;
				}
			}
			answer++;
			break;
		case 2:
			if (a[1] <= 3) {
				if (a[0] <= 18 - 4 * a[1]) {
					a[0] = 0;
					a[1] = 0;
				}
				else {
					a[0] -= 18 - 4 * a[1];
					a[1] = 0;
				}
			}
			else {
				a[1] -= 3;
				if (a[0] <= 6) {
					a[0] = 0;
				}
				else {
					a[0] -= 6;
				}
			}
			answer++;
			break;
		case 3:
			if (a[1] <= 1) {
				if (a[0] <= 9 - 4 * a[1]) {
					a[0] = 0;
					a[1] = 0;
				}
				else {
					a[0] -= 9 - 4 * a[1];
					a[1] = 0;
				}
			}
			else {
				a[1] -= 1;
				if (a[0] <= 5) {
					a[0] = 0;
				}
				else {
					a[0] -= 5;
				}
			}
			answer++;
			break;
		a[2] = 0;
	}

	if ((a[0] != 0) || (a[1] != 0)) {
		answer += (a[0] + 4 * a[1] - 1) / 36 + 1;
	}

	cout << answer;

	return 0;
}