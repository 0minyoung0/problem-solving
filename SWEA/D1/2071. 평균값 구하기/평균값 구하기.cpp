#include <iostream>
#include <cmath>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int t;
	cin >> t;
	for (int i = 1;i <= t;i++) {
		double sum = 0;
		int cnt = 10;
		while (cnt--) {
			double temp;
			cin >> temp;
			sum += temp;
		}
		cout << '#' << i << ' ' << round(sum / 10) << '\n';
	}
}