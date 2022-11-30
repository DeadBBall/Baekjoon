#include <iostream>
using namespace std;

int dp[1500000] = {0};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long n;
	cin >> n;
	n %= 1500000;
	dp[1] = 1;
	for(int i = 2; i <= n; i++)
		dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
	cout << dp[n];
}