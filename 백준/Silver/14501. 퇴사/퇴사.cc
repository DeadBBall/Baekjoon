#include <iostream>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, cost[16], money[16], dp[16] = {0};
	cin >> n;
	for(int i = 1; i <= n; i++)
		cin >> cost[i] >> money[i];
	for(int i = 1; i <= n; i++)
		for(int j = 1; j <= i; j++)
		{
			if(cost[j] + j - 1 <= i)
				dp[i] = max(dp[i], dp[j - 1] + money[j]);
		}
	cout << dp[n];
}