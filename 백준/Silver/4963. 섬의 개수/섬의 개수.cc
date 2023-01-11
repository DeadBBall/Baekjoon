#include <iostream>
#include <queue>
using namespace std;
typedef pair<int, int> pii;

int w, h;
int dy[] = {1, -1, 0, 0, 1, 1, -1, -1};
int dx[] = {0, 0, 1, -1, -1, 1, -1, 1};
bool map[50][50];

bool checkMap(int y, int x)
{
	if(y < 0 || x < 0 || y >= h || x >= w || map[y][x] == 0)
		return 0;
	return 1;
}

void bfs(int y, int x)
{
	queue<pii> q;
	q.push({y, x});
	map[y][x] = 0;
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		for(int i = 0; i < 8; i++)
		{
			int ny = now.first + dy[i];
			int nx = now.second + dx[i];
			if(!checkMap(ny, nx))
				continue;
			map[ny][nx] = 0;
			q.push({ny, nx});
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	while(true)
	{
		cin >> w >> h;
		if(w + h == 0)
			break;
		for(int y = 0; y < h; y++)
			for(int x = 0; x < w; x++)
				cin >> map[y][x];
		int island = 0;
		for(int y = 0; y < h; y++)
			for(int x = 0; x < w; x++)
			{
				if(map[y][x] == 1)
				{
					bfs(y, x);
					island++;
				}
			}
		cout << island << "\n";
	}
	return (0);
}