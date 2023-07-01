#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int n, k;
	cin >> n;
	cin >> k;
	int count = 0;
	for (int i = 1;i <= n;i++) {
		if (n % i == 0) {
			count++;
		}
		if (count == k) {
			cout << i;
			return 0;
		}
	}
	cout << 0;

	return 0;
}