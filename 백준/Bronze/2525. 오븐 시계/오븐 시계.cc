#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int a, b, c;
	cin >> a;
	cin >> b;
	cin >> c;
	a += (b + c) / 60;
	a %= 24;
	b = (b + c) % 60;
	cout << a << " " << b;

	return 0;
}