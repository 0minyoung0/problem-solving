#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int n;
	cin >> n;
	int temp1, temp2;
	int count_inc, count_dec, count_max;
	int m = 1;
	cin >> temp1;
	count_inc = 1;
	count_dec = 1;
	count_max = 1;
	for (int i = 1;i < n;i++) {
		cin >> temp2;
		if (temp1 < temp2) {
			count_inc++;
			count_dec = 1;
		}
		else if (temp1 > temp2) {
			count_inc = 1;
			count_dec++;
		}
		else {
			count_inc++;
			count_dec++;
		}
		count_max = max(count_inc, count_dec);
		if (m < count_max) {
			m = count_max;
		}
		temp1 = temp2;
	}
	cout << m;

	return 0;
}