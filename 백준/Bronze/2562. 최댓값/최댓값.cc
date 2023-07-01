#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int max = 0;
	int count = 0;
	int temp;
	for (int i = 1;i < 10;i++) {
		cin >> temp;
		if (temp > max) {
			max = temp;
			count = i;
		}
	}
	cout << max << endl << count;

	return 0;
}