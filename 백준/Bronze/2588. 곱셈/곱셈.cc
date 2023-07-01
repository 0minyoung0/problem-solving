#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
	int n1, n2;
	cin >> n1;
	cin >> n2;
	int n_2[3];
	n_2[0] = n2 / 100;
	n2 -= n_2[0]*100;
	n_2[1] = n2 / 10;
	n2 -= n_2[1]*10;
	n_2[2] = n2;
	cout << n1 * n_2[2] << endl << n1 * n_2[1] << endl << n1 * n_2[0] << endl << 100 * n1 * n_2[0] + 10 * n1 * n_2[1] + n1 * n_2[2];

	return 0;
}