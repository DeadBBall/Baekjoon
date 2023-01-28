#include <iostream>
using namespace std;

int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};
int map[500][500], m, n;
int dp[500][500];

int dfs(int y, int x)
{
	if(y == m - 1 && x == n - 1)
		return 1;
	else if(dp[y][x] != -1)
		return dp[y][x];
	dp[y][x] = 0;
	for(int i = 0; i < 4; i++)
	{
		int ny = y + dy[i];
		int nx = x + dx[i];
		if(ny < 0 || nx < 0 || ny >= m || nx >= n || map[ny][nx] >= map[y][x])
			continue;
		dp[y][x] += dfs(ny, nx);
	}
	return dp[y][x];
}

void init()
{
	cin >> m >> n;
	for(int y = 0; y < m; y++)
		for(int x = 0; x < n; x++)
		{
			cin >> map[y][x];
			dp[y][x] = -1;
		}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	init();
	cout << dfs(0, 0);
}