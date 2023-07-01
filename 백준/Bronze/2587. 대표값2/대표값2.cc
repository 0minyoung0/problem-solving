#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
	int n[5], sum = 0;
	for (int i = 0;i < 5;i++) {
		cin >> n[i];
		sum += n[i];
	}
	sort(n, n + 5);
	cout << sum / 5 << endl << n[2];

	return 0;
}