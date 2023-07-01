#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
	int n;
	cin >> n;
	string first, word;
	string temp1, temp2;
	cin >> first;
	sort(first.begin(), first.end());
	int count = 0;
	int flag = 0;
	for (int i = 1;i < n;i++) {
		temp1 = first;
		cin >> word;
		sort(word.begin(), word.end());
		temp2 = word;
		if (temp1.size() == temp2.size()) {
			if (temp1 == temp2) {
				count++;
			}
			else{
				for (int j = 0;j < temp1.size();j++) {
					temp1.erase(temp1.begin() + j);
					for (int k = 0;k < temp2.size();k++) {
						temp2.erase(temp2.begin() + k);
						if (temp1 == temp2) {
							count++;
							flag = 1;
							break;
						}
						temp2 = word;
					}
					if (flag == 1) {
						flag = 0;
						break;
					}
					temp1 = first;
				}
			}
		}
		else if (temp1.size() == temp2.size() + 1) {
			for (int j = 0;j < temp1.size();j++) {
				temp1.erase(temp1.begin() + j);
				if (temp1 == temp2) {
					count++;
					temp1 = first;
					break;
				}
				temp1 = first;
			}
		}
		else if (temp1.size() + 1 == temp2.size()) {
			for (int j = 0;j < temp2.size();j++) {
				temp2.erase(temp2.begin() + j);
				if (temp1 == temp2) {
					count++;
					temp2 = word;
					break;
				}
				temp2 = word;
			}
		}
		//cout << first << " " << word << endl;
	}
	cout << count;

	return 0;
}