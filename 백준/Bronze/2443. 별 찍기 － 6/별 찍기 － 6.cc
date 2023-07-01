#include <bits/stdc++.h>

using namespace std;

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, count;
	cin >> n;
	for (int i = 0;i <= n - 1;i++) {
		count = i;
		while (count) {
			cout << ' ';
			count--;
		}
		count = n - i;
		while (count) {
			cout << '*';
			count--;
		}
		count = n - i - 1;
		while (count) {
			cout << '*';
			count--;
		}
		cout << '\n';
	}

	return 0;
}