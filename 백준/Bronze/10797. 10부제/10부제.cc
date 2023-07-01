#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int day;
	int car;
	int count = 0;
	cin >> day;
	for (int i = 0;i < 5;i++) {
		cin >> car;
		if (day == car) {
			count++;
		}
	}
	cout << count;

	return 0;
}