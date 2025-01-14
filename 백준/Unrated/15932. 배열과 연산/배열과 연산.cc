#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q, m;
    cin >> n >> q >> m;
    cin.ignore(); // Consume the newline after reading integers

    vector<string> operators(q);
    vector<int> Y(m);

    for (int i = 0; i < q; ++i) {
        getline(cin, operators[i]);
    }

    for (int i = 0; i < m; ++i) {
        cin >> Y[i];
    }

    // 역순으로 계산
    vector<int> idx = Y;
    vector<int> ans(m, 0);

    for (int line = q - 1; line >= 0; --line) {
        string operatorLine = operators[line];
        stringstream ss(operatorLine);
        string command;
        ss >> command;

        if (command[0] == 'r') { // reverse
            int i, j;
            ss >> i >> j;
            for (int cur = 0; cur < m; ++cur) {
                if (idx[cur] >= i && idx[cur] <= j) {
                    idx[cur] = i + j - idx[cur];
                }
            }
        } else { // sum
            for (int cur = 0; cur < m; ++cur) {
                ans[cur] += idx[cur];
            }
        }
    }

    for (int i = 0; i < m; ++i) {
        cout << ans[i] << "\n";
    }

    return 0;
}