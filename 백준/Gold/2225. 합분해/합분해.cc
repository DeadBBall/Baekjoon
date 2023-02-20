#include <iostream>
using namespace std;
#define MAX 1000000000;

int n, k;
int dp[201][201];

void input()
{
	cin >> n >> k;
}

void makeN()
{
	for(int i = 0; i <= n; i++)
	{
		dp[i][1] = 1;
	}

	for(int i = 1; i <= n; i++)
	{
		for(int j = 1; j <= k; j++)
		{
			dp[0][j] = 1;
			dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MAX;
		}
	}
}

void solve()
{
	input();
	makeN();
	cout << dp[n][k];
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();

}
