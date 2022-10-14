#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;
typedef pair<int,int> pii;

int tomato[1000][1000] = {0}, n, m;
int dy[] = {0, 0, -1, 1};
int dx[] = {-1, 1, 0, 0};

int main()
{
	cin >> m >> n;
	queue<pii> q;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
		{
			cin >> tomato[y][x];
			if(tomato[y][x] == 1)
				q.push(make_pair(y, x));
		}
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int ny = now.first + dy[i];
			int nx = now.second + dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= m)
				continue;
			if(tomato[ny][nx] == 0)
			{
				tomato[ny][nx] = tomato[now.first][now.second] + 1;
				q.push(make_pair(ny, nx));
			}
		}
	}
	int ans = 0;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
		{
			ans = max(ans, tomato[y][x]);
			if(tomato[y][x] == 0)
			{
				cout << "-1";
				return (0);
			}
		}
	cout << ans - 1;
}