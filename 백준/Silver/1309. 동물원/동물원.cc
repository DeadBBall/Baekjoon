#include <iostream>
using namespace std;

int dp[100000];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	dp[0] = 3;
	dp[1] = 7;
	int n;
	cin >> n;
	for(int i = 2; i < n; i++)
		dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901;
	cout << dp[n - 1];
}