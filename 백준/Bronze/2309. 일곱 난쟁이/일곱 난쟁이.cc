#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int height[10];
	int sum = 0;
	for (int i = 0;i < 9;i++) {
		cin >> height[i];
		sum += height[i];
	}
	sort(height, height + 9);
	int target = sum - 100;
	int t1, t2;
	bool find = 0;
	for (int i = 0;i < 8;i++) {
		for (int j = i + 1;j < 9;j++) {
			if (height[i] + height[j] == target) {
				t1 = i;
				t2 = j;
				find = 1;
				break;
			}
		}
		if (find == 1) break;
	}
	for (int i = 0;i < 9;i++) {
		if (i != t1 && i != t2) cout << height[i] << '\n';
	}
}