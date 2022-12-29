#include <iostream>
using namespace std;

int card[1001], dp[1001] = {0};

int solve(int n)
{
	int ans = card[n];
	for(int i = 1; i < n - i + 1; i++)
		if(ans < dp[i] + dp[n - i])
			ans = dp[i] + dp[n - i];
	return ans;
}

int main()
{
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);
	int n;
	cin >> n;
	for(int i = 1; i <= n; i++)
		cin >> card[i];
	dp[1] = card[1];
	for(int i = 2; i <= n; i++)
		dp[i] = solve(i);
	cout << dp[n];
}