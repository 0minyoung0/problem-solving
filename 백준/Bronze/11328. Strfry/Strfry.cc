#include <bits/stdc++.h>
using namespace std;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, count;
	cin >> n;
	string s1;
	string s2;
	int a1[26] = {};
	int a2[26] = {};
	for (int i = 0;i < n;i++) {
		fill(a1, a1 + 26, 0);
		fill(a2, a2 + 26, 0);
		cin >> s1 >> s2;
		if (s1.size() == s2.size()) {
			for (int j = 0;j < s1.size();j++) {
				for (char a = 'a';a <= 'z';a++) {
					if (s1.at(j) == a) {
						a1[a - 'a']++;
					}
				}
			}
			for (int j = 0;j < s2.size();j++) {
				for (char a = 'a';a <= 'z';a++) {
					if (s2.at(j) == a) {
						a2[a - 'a']++;
					}
				}
			}
			count = 0;
			for (int j = 0;j < 26;j++) {
				if (a1[j] != a2[j]) {
					cout << "Impossible\n";
					break;
				}
				else {
					count++;
				}
			}
			if (count == 26) {
				cout << "Possible\n";
			}
		}
		else { cout << "Impossible\n"; }
	}

	return 0;
}