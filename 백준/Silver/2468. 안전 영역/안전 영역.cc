#include <iostream>
#include <queue>
using namespace std;
typedef pair<int, int> pii;

int map[100][100];
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};
int n, highMax = 0;
bool visit[100][100] = {0};

void bfs(int y, int x, int high)
{
	queue<pii> q;
	q.push({y, x});
	visit[y][x] = true;
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int ny = now.first + dy[i];
			int nx = now.second + dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= n || map[ny][nx] <= high || visit[ny][nx])
				continue;
			visit[ny][nx] = true;
			q.push({ny, nx});
		}
	}
}

void clearMap()
{
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
			visit[y][x] = 0;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	int ans = 0;

	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			cin >> map[y][x];
			highMax = max(map[y][x], highMax);
		}
	}

	for(int i = 0; i <= highMax; i++)
	{
		clearMap();
		int tmp = 0;
		for(int y = 0; y < n; y++)
		{
			for(int x = 0; x < n; x++)
			{
				if(map[y][x] > i && !visit[y][x])
				{
					bfs(y, x, i);
					tmp++;
				}
			}
		}
		ans = max(ans, tmp);
	}
	cout << ans;
}