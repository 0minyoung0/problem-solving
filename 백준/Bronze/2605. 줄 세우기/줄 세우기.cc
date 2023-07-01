#include <iostream>
using namespace std;

int main(){
	int n;
	int array[100] = { 0 };
	cin >> n;
	int number;
	for (int i = 0;i < n;i++) {
		cin >> number;
		for (int j = i;j > i - number;j--) {
			array[j] = array[j - 1];
		}
		array[i - number] = i + 1;
	}
	for (int i = 0;i < n;i++) {
		cout << array[i] << " ";
	}
}