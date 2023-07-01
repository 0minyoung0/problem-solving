#include <bits/stdc++.h>

using namespace std;

int main(){
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, temp;
	cin >> n;
	int cY = 0;
	int cM = 0;
	for (int i = 0;i < n;i++) {
		cin >> temp;
		cY += 10 + (temp / 30) * 10;
		cM += 15 + (temp / 60) * 15;
	}
	if (cY < cM) {
		cout << "Y " << cY;
	}
	else if (cY > cM) {
		cout << "M " << cM;
	}
	else {
		cout << "Y M " << cY;
	}

	return 0;
}