#include <iostream>

using namespace std;

int cabb[50][50] = {0}, visit[50][50] = {0}, ans, m, n;
int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, -1, 1};

void dfs(int y, int x)
{
	visit[y][x] = 1;
	for (int i = 0; i < 4; i++)
	{
  	int nx = x + dx[i];
    int ny = y + dy[i];
    if (nx < 0 || nx >= m || ny < 0 || ny >= n)
      continue;
  	if (cabb[ny][nx] == 1 && visit[ny][nx] == 0)
      dfs(ny, nx);
  }
}

int main()
{
	int t, k;
	cin >> t;
	for(int i = 0; i < t; i++)
	{
		cin >> m >> n >> k;
		for(int j = 0; j < k; j++)
		{
			int x, y;
			cin >> x >> y;
			cabb[y][x] = 1;
		}
		ans = 0;
		for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (cabb[i][j] == 1 && visit[i][j] == 0)
				{
          dfs(i, j);
          ans++;
        }
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
			{
				cabb[i][j] = 0;
				visit[i][j] = 0;
			}
		cout << ans << "\n";
	}
}