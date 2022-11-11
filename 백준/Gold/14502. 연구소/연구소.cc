#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
typedef pair<int, int> pii;

int n, m, map[8][8], ans = 0, wall[2][3], virusNum = 0;
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};
bool visit[8][8], wallVisit[8][8];
queue<pii> tmpq;
queue<pii> q;

bool canPass(int y, int x)
{
	if(y < 0 || x < 0 || y >= n || x >= m || visit[y][x] == 1 || (y == wall[0][0] && x == wall[1][0])
		|| (y == wall[0][1] && x == wall[1][1]) || (y == wall[0][2] && x == wall[1][2]))
		return false;
	return true;
}

void bfs()
{
	q = tmpq;
	int tmp = virusNum;
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int ny = now.first + dy[i];
			int nx = now.second + dx[i];
			if(!canPass(ny, nx))
				continue;
			visit[ny][nx] = true;
			if(map[ny][nx] == 0)
			{
				q.push({ny, nx});
				tmp++;
			}
		}
	}
	if(ans == 0)
		ans = tmp;
	else
		ans = tmp < ans ? tmp : ans;
}

void makeWall(int cnt)
{
	if(cnt == 3)
	{
		memset(visit, 0, sizeof(visit));
		bfs();
		return;
	}
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
			if(map[y][x] == 0 && !wallVisit[y][x])
			{
				wall[0][cnt] = y;
				wall[1][cnt] = x;
				wallVisit[y][x] = true;
				makeWall(cnt + 1);
				wallVisit[y][x] = false;
			}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int wallNum = 0;
	cin >> n >> m;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
		{
			cin >> map[y][x];
			if(map[y][x] == 1)
				wallNum++;
			else if(map[y][x] == 2)
				virusNum++;
		}
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
			if(map[y][x] == 2)
				tmpq.push({y, x});
	makeWall(0);
	cout << n * m - ans - 3 - wallNum;
}