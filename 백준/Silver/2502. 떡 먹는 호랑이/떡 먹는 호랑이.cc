#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int d, k;
	cin >> d;
	cin >> k;
	int data[2][30] = { 0 };
	data[0][0] = 1;
	data[1][1] = 1;
	for (int i = 2;i < d;i++) {
		data[0][i] = data[0][i - 2] + data[0][i - 1];
		data[1][i] = data[1][i - 2] + data[1][i - 1];
	}
	for (int i = 1;i <= k / data[0][d - 1];i++) {
		for (int j = i;j <= k / data[1][d - 1];j++) {
			if (i * data[0][d - 1] + j * data[1][d - 1] == k) {
				cout << i << endl << j;
				return 0;
			}
		}
	}



	return 0;
}