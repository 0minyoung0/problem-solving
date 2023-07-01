#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	
	int card[21];
	for (int i = 1;i < 21;i++) {
		card[i] = i;
	}
	for (int i = 0;i < 10;i++) {
		int a, b;
		cin >> a >> b;
		reverse(card + a, card + b + 1);
	}
	for (int i = 1;i < 21;i++) {
		cout << card[i] << ' ';
	}
}