#include <iostream>
using namespace std;

int n;
long long dp[91] = {0};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	dp[1] = 1;
	for(int i = 0; i < n - 1; i++)
		dp[i + 2] = dp[i + 1] + dp[i];
	cout << dp[n];
}