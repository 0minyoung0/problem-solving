#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	string w1;
	string w2;
	cin >> w1 >> w2;
	int a1[26] = { 0 };
	int a2[26] = { 0 };
	for (int i = 0;i < w1.size();i++) {
		a1[w1[i]-'a']++;
	}
	for (int i = 0;i < w2.size();i++) {
		a2[w2[i]-'a']++;
	}
	int count = 0;
	for (int i = 0;i < 26;i++) {
		count += abs(a1[i] - a2[i]);
	}
	cout << count;

	return 0;
}