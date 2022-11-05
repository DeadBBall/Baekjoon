#include <iostream>
#include <queue>
using namespace std;
typedef pair<int, int> pii;

int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, 1, -1};
int n, xStart, yStart, xObj, yObj, shark = 2, feed = 0, ans = 0, checkFish = 0, minDis;
int check[20][20], sea[20][20];

bool canMove(int y, int x)
{
	if(y < 0 || x < 0 || y >= n || x >= n
		|| shark < sea[y][x] || check[y][x] != -1)
		return false;
	return true;
}

bool canEat(int y, int x)
{
	if(0 < sea[y][x] && sea[y][x] < shark)
		return true;
	return false;
}

void checkReset(int y, int x)
{
	minDis = 401;
	yObj = 20;
	xObj = 20;
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			check[i][j] = -1;
	check[y][x] = 0;
}

void bfs(int y, int x)
{
	queue<pii> q;
	q.push({y, x});
	pii now;
	while(!q.empty())
	{
		now = q.front();
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int ny = now.first + dy[i];
			int nx = now.second + dx[i];
			if(!canMove(ny, nx))
				continue;
			check[ny][nx] = check[now.first][now.second] + 1;
			if(canEat(ny, nx))
			{
				if(minDis > check[ny][nx])
				{
					minDis = check[ny][nx];
					yObj = ny;
					xObj = nx;
				}
				else if(minDis == check[ny][nx])
				{
					if(yObj == ny)
					{
						if(xObj > nx)
						{
							yObj = ny;
							xObj = nx;
						}
					}
					else if(yObj > ny)
					{
						yObj = ny;
						xObj = nx;
					}
				}
			}
			q.push({ny, nx});
		}
	}
}

void setMap()
{
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
		{
			cin >> sea[y][x];
			checkFish += sea[y][x];
			if(sea[y][x] == 9)
			{
				yStart = y;
				xStart = x;
				sea[y][x] = 0;
			}
		}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	setMap();
	if(checkFish == 9)
	{
		cout << ans;
		return (0);
	}
	while(1)
	{
		checkReset(yStart, xStart);
		bfs(yStart, xStart);
		if(minDis != 401)
		{
			feed++;
			sea[yObj][xObj] = 0;
			if(feed == shark)
			{
				shark++;
				feed = 0;
			}
			ans += minDis;
			yStart = yObj;
			xStart = xObj;
		}
		else
			break;
	}
	cout << ans;
}