#include <iostream>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t;
	cin >> t;
	for(int i = 0; i < t; i++)
	{
		int n, sticker[2][100000], dp[2][100000];
		cin >> n;
		for(int k = 0; k < 2; k++)
			for(int j = 0; j < n; j++)
				cin >> sticker[k][j];
		dp[1][0] = sticker[1][0];
		dp[0][0] = sticker[0][0];
		if(n > 1)
		{
			dp[0][1] = dp[1][0] + sticker[0][1];
			dp[1][1] = dp[0][0] + sticker[1][1];
		}
		for(int j = 2; j < n; j++)
		{
			dp[0][j] = sticker[0][j] + dp[1][j - 2] > sticker[0][j] + dp[1][j - 1] ? sticker[0][j] + dp[1][j - 2] : sticker[0][j] + dp[1][j - 1];
			dp[1][j] = sticker[1][j] + dp[0][j - 2] > sticker[1][j] + dp[0][j - 1] ? sticker[1][j] + dp[0][j - 2] : sticker[1][j] + dp[0][j - 1];
		}
		cout << (dp[0][n - 1] > dp[1][n - 1] ? dp[0][n - 1] : dp[1][n - 1]) << "\n";
	}
}