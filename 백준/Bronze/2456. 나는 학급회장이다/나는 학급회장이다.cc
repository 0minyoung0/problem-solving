#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int n;
	cin >> n;
	int a[3][4] = { 0 };
	int temp;
	for (int i = 0;i < n;i++) {
		for (int j = 0;j < 3;j++) {
			cin >> temp;
			a[j][0] += temp;
			a[j][temp]++;
		}
	}
	if (a[0][0] > a[1][0] && a[0][0] > a[2][0]) {
		cout << "1 " << a[0][0];
	}
	else if (a[1][0] > a[0][0] && a[1][0] > a[2][0]) {
		cout << "2 " << a[1][0];
	}
	else if (a[2][0] > a[0][0] && a[2][0] > a[1][0]) {
		cout << "3 " << a[2][0];
	}
	else if (a[0][0] == a[1][0] && a[0][0] > a[2][0]) {
		if (a[0][1] > a[1][1]) {
			cout << "1 " << a[0][0];
		}
		else if (a[0][1] < a[1][1]) {
			cout << "2 " << a[1][0];
		}
		else {
			if (a[0][2] > a[1][2]) {
				cout << "1 " << a[0][0];
			}
			else if (a[0][2] < a[1][2]) {
				cout << "2 " << a[1][0];
			}
			else {
				cout << "0 " << a[0][0];
			}
		}
	}
	else if (a[1][0] == a[2][0] && a[1][0] > a[0][0]) {
		if (a[1][1] > a[2][1]) {
			cout << "2 " << a[1][0];
		}
		else if (a[1][1] < a[2][1]) {
			cout << "3 " << a[2][0];
		}
		else {
			if (a[1][2] > a[2][2]) {
				cout << "2 " << a[1][0];
			}
			else if (a[1][2] < a[2][2]) {
				cout << "3 " << a[2][0];
			}
			else {
				cout << "0 " << a[1][0];
			}
		}
	}
	else if (a[2][0] == a[0][0] && a[2][0] > a[1][0]) {
		if (a[2][1] > a[0][1]) {
			cout << "3 " << a[2][0];
		}
		else if (a[2][1] < a[0][1]) {
			cout << "1 " << a[0][0];
		}
		else {
			if (a[2][2] > a[0][2]) {
				cout << "3 " << a[2][0];
			}
			else if (a[2][2] < a[0][2]) {
				cout << "1 " << a[0][0];
			}
			else {
				cout << "0 " << a[2][0];
			}
		}
	}
	else {
		if (a[0][1] > a[1][1] && a[0][1] > a[2][1]) {
			cout << "1 " << a[0][0];
		}
		else if (a[1][1] > a[0][1] && a[1][1] > a[2][1]) {
			cout << "2 " << a[1][0];
		}
		else if (a[2][1] > a[0][1] && a[2][1] > a[1][1]) {
			cout << "3 " << a[2][0];
		}
		else if (a[0][1] == a[1][1] && a[0][1] > a[2][1]) {
			if (a[0][2] > a[1][2]) {
				cout << "1 " << a[0][0];
			}
			else if (a[0][2] < a[1][2]) {
				cout << "2 " << a[1][0];
			}
			else {
				cout << "0 " << a[0][0];
			}
		}
		else if (a[1][1] == a[2][1] && a[1][1] > a[0][1]) {
			if (a[1][2] > a[2][2]) {
				cout << "2 " << a[1][0];
			}
			else if (a[1][2] < a[2][2]) {
				cout << "3 " << a[2][0];
			}
			else {
				cout << "0 " << a[1][0];
			}
		}
		else if (a[2][1] == a[0][1] && a[2][1] > a[1][1]) {
			if (a[2][2] > a[0][2]) {
				cout << "3 " << a[2][0];
			}
			else if (a[2][2] < a[0][2]) {
				cout << "1 " << a[0][0];
			}
			else {
				cout << "0 " << a[2][0];
			}
		}
		else {
			cout << "0 " << a[0][0];
		}
	}

	return 0;
}