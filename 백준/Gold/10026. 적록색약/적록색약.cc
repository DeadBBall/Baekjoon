#include <iostream>
#include <string>

using namespace std;

string rgb[100];
bool visit[100][100];
int n;
int dy[] = {0, 0, -1, 1};
int dx[] = {-1, 1, 0, 0};

void dfs(int y, int x, char color)
{
	visit[y][x] = true;
	for(int i = 0; i < 4; i++)
	{
		int ny = y + dy[i];
		int nx = x + dx[i];
		if(ny < 0 || nx < 0 || ny >= n || nx >= n)
			continue;
		if(!visit[ny][nx] && rgb[ny][nx] == color)
			dfs(ny, nx, color);
	}
}

int main()
{
	int ans = 0;
	cin >> n;
	for(int i = 0; i < n; i++)
		cin >> rgb[i];
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
		{
			if(!visit[y][x] && rgb[y][x] == 'R')
			{
				dfs(y, x, 'R');
				ans++;
			}
			else if(!visit[y][x] && rgb[y][x] == 'G')
			{
				dfs(y, x, 'G');
				ans++;
			}
			else if(!visit[y][x] && rgb[y][x] == 'B')
			{
				dfs(y, x, 'B');
				ans++;
			}
		}
	cout << ans << " ";
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
		{
			visit[y][x] = false;
			if(rgb[y][x] == 'G')
				rgb[y][x] = 'R';
		}
	ans = 0;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
		{
			if(!visit[y][x] && rgb[y][x] == 'R')
			{
				dfs(y, x, 'R');
				ans++;
			}
			else if(!visit[y][x] && rgb[y][x] == 'B')
			{
				dfs(y, x, 'B');
				ans++;
			}
		}
	cout << ans;
}