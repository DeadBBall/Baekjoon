#include <iostream>
#include <algorithm>
using namespace std;

int n, m, map[1025][1025] = {0}, dp[1025][1025] = {0};

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for(int x = 1; x <= n; x++)
		for(int y = 1; y <= n; y++)
		{
			cin >> map[x][y];
			if(x == 1 && y == 1)
				dp[x][y] = map[x][y];
			else
			{
				if(y == 1)
					dp[x][y] = dp[x - 1][n] + map[x][y];
				else
					dp[x][y] = dp[x][y - 1] + map[x][y];
			}
		}
	for(int i = 0; i < m; i++)
	{
		int x1, x2, y1, y2, ans = 0;
		cin >> x1 >> y1 >> x2 >> y2;
		for(int x = x1; x <= x2; x++)
		{
			if(y1 != 1)
				ans += dp[x][y2] - dp[x][y1 - 1];
			else
				ans += dp[x][y2] - dp[x - 1][n];
		}
		cout << ans << "\n";
	}
}