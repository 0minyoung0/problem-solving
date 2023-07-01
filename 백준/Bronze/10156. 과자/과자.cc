#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int k, n, m;
	cin >> k;
	cin >> n;
	cin >> m;
	int x = k * n - m;
	if (x < 0) {
		x = 0;
	}
	cout << x;

	return 0;
}