#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int data[2][25];
	int temp;
	for (int i = 0;i < 5;i++) {
		for (int j = 0;j < 5;j++) {
			cin >> temp;
			data[0][temp-1] = i;
			data[1][temp-1] = j;
		}
	}
	int count = 0;
	int bingo = 0;
	int row[5] = { 0 };
	int col[5] = { 0 };
	int dig[2] = { 0 };
	while (bingo < 3) {
		cin >> temp;
		count++;
		if (++row[data[0][temp-1]] == 5) {
			bingo++;
		}
		if (++col[data[1][temp-1]] == 5) {
			bingo++;
		}
		if (data[0][temp-1] == data[1][temp-1]) {
			if (++dig[0] == 5) {
				bingo++;
			}
		}
		if (data[0][temp-1] + data[1][temp-1] == 4) {
			if (++dig[1] == 5) {
				bingo++;
			}
		}
	}
	cout << count;

	return 0;
}