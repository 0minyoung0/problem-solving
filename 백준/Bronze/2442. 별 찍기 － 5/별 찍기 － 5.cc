#include <bits/stdc++.h>

using namespace std;

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, count;
	cin >> n;
	for (int i = 1;i <= n;i++) {
		count = n - i;
		while (count) {
			cout << ' ';
			count--;
		}
		count = i;
		while (count) {
			cout << '*';
			count--;
		}
		count = i - 1;
		while (count) {
			cout << '*';
			count--;
		}
		cout << '\n';
	}

	return 0;
}