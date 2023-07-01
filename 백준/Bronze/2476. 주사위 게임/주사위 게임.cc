#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int n;
	cin >> n;
	int m = 0;
	int dice[3];
	int reward;
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < 3;j++) {
			cin >> dice[j];
		}
		if (dice[0] == dice[1] && dice[1] == dice[2]) {
			reward = 10000 + 1000 * dice[0];
		}
		else if (dice[0] == dice[1]) {
			reward = 1000 + 100 * dice[0];
		}
		else if (dice[1] == dice[2]) {
			reward = 1000 + 100 * dice[1];
		}
		else if (dice[2] == dice[0]) {
			reward = 1000 + 100 * dice[2];
		}
		else {
			reward = 100 * max(dice[0], max(dice[1], dice[2]));
		}
		if (reward > m) {
			m = reward;
		}
	}
	cout << m;

	return 0;
}