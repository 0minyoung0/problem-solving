#include <iostream>

using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int temp, min, sum;
	min = 100;
	sum = 0;
	for (int i = 0;i < 7;i++) {
		cin >> temp;
		if (temp % 2 == 1) {
			sum += temp;
			if (temp < min) min = temp;
		}
	}
	if (sum == 0) cout << -1;
	else cout << sum << '\n' << min;
}