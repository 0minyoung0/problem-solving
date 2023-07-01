#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int trans1(string str) {
	int result = 0;
	while (str.size()) {
		switch (str.front()) {
			case 'M':
				result += 1000;
				str.erase(0,1);
				break;
			case 'D':
				result += 500;
				str.erase(0,1);
				break;
			case 'C':
				if (str.size() > 1) {
					if (str.at(1) == 'M') {
						result += 900;
						str.erase(0, 2);
						break;
					}
					else if (str.at(1) == 'D') {
						result += 400;
						str.erase(0, 2);
						break;
					}
					else {
						result += 100;
						str.erase(0, 1);
						break;
					}
				}
				else {
					result += 100;
					str.erase(0, 1);
					break;
				}
			case 'L':
				result += 50;
				str.erase(0, 1);
				break;
			case 'X':
				if (str.size() > 1) {
					if (str.at(1) == 'C') {
						result += 90;
						str.erase(0, 2);
						break;
					}
					else if (str.at(1) == 'L') {
						result += 40;
						str.erase(0, 2);
						break;
					}
					else {
						result += 10;
						str.erase(0, 1);
						break;
					}
				}
				else {
					result += 10;
					str.erase(0, 1);
					break;
				}
			case 'V':
				result += 5;
				str.erase(0, 1);
				break;
			case 'I':
				if (str.size() > 1) {
					if (str.at(1) == 'X') {
						result += 9;
						str.erase(0, 2);
						break;
					}
					else if (str.at(1) == 'V') {
						result += 4;
						str.erase(0, 2);
						break;
					}
					else {
						result += 1;
						str.erase(0, 1);
						break;
					}
				}
				else {
					result += 1;
					str.erase(0, 1);
					break;
				}
		}
	}
	return result;
}

string trans2(int num) {
	string result;
	result.clear();
	while (num) {
		if (num >= 100) {
			if (num >= 1000) {
				result += "M";
				num -= 1000;
			}
			else if (num >= 900) {
				result += "CM";
				num -= 900;
			}
			else if (num >= 500) {
				result += "D";
				num -= 500;
			}
			else if (num >= 400) {
				result += "CD";
				num -= 400;
			}
			else {
				result += "C";
				num -= 100;
			}
		}
		else if (num >= 10) {
			if (num >= 90) {
				result += "XC";
				num -= 90;
			}
			else if (num >= 50) {
				result += "L";
				num -= 50;
			}
			else if (num >= 40) {
				result += "XL";
				num -= 40;
			}
			else {
				result += "X";
				num -= 10;
			}
		}
		else {
			if (num >= 9) {
				result += "IX";
				num -= 9;
			}
			else if (num >= 5) {
				result += "V";
				num -= 5;
			}
			else if (num >= 4) {
				result += "IV";
				num -= 4;
			}
			else {
				result += "I";
				num -= 1;
			}
		}
	}
	return result;
}

int main(){
	string r1, r2;
	cin >> r1; // 로마자1
	cin >> r2; // 로마자2
	int n1 = trans1(r1);
	int n2 = trans1(r2);
	string rsum = trans2(n1 + n2);
	cout << n1 + n2 << endl << rsum;

	return 0;
}