#include <iostream>
using namespace std;

int n;
int dp[46] = {0};

int fib()
{
	for(int i = 0; i <= n; i++)
		dp[i + 2] = dp[i + 1] + dp[i];
	return dp[n];
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	dp[0] = 0;
	dp[1] = 1;
	cout << fib();
}