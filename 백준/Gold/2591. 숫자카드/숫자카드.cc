#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	string num;
	cin >> num;
	int count1 = 0;
	int count2 = 1;
	int temp1, temp2;
	for (int i = 0;i < num.size() - 1;i++) {
		temp1 = count1;
		temp2 = count2;
		if (num[i + 1] == '0') {
			count1 = temp2;
			count2 = 0;
		}
		else if ((10 * (num[i] - '0') + (num[i + 1] - '0')) > 34) {
			count1 = 0;
			count2 = temp1 + temp2;
		}
		else {
			count1 = temp2;
			count2 = temp1 + temp2;
		}
	}

	cout << count1 + count2;

	return 0;
}