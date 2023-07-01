#include <iostream>
#include <string>
#include <algorithm>
#include <queue>

using namespace std;

int main(){
	int m, people;
	int temp;
	cin >> temp;
	cin >> temp;
	people = temp;
	m = people;
	
	cin >> temp;
	people -= temp;
	cin >> temp;
	people += temp;
	if (m < people) {
		m = people;
	}

	cin >> temp;
	people -= temp;
	cin >> temp;
	people += temp;
	if (m < people) {
		m = people;
	}

	cin >> temp;
	cin >> temp;

	cout << m;

	return 0;
}