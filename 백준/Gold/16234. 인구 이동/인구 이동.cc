#include <iostream>
#include <cstdlib>
#include <queue>
using namespace std;
typedef pair<int, int> pii;

int n, arr[50][50], l, r, day = 0;
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};
int border[50][50];

void move(int y, int x, int areaNum)
{
	int size = 1;
	int sum = arr[y][x];
	border[y][x] = -1;
	queue<pii> q;
	q.push({y, x});
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int ny = now.first + dy[i];
			int nx = now.second + dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= n || border[ny][nx] != areaNum)
				continue;
			size++;
			sum += arr[ny][nx];
			border[ny][nx] = -1;
			q.push({ny, nx});
		}
	}
	q.push({y, x});
	arr[y][x] = sum / size;
	border[y][x] = 0;
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int ny = now.first + dy[i];
			int nx = now.second + dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= n || border[ny][nx] != -1)
				continue;
			arr[ny][nx] = sum / size;
			border[ny][nx] = 0;
			q.push({ny, nx});
		}
	}
}

void readyToMove()
{
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			if(border[y][x] != 0)
			{
				move(y, x, border[y][x]);
			}
		}
	}
}

bool openBorder(int y, int x, int cnt)
{
	bool flag = false;
	queue<pii> q;
	q.push({y, x});
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int ny = now.first + dy[i];
			int nx = now.second + dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= n || border[ny][nx] != 0)
				continue;
			if(l <= abs(arr[ny][nx] - arr[now.first][now.second]) && abs(arr[ny][nx] - arr[now.first][now.second]) <= r)
			{
				border[now.first][now.second] = cnt;
				border[ny][nx] = cnt;
				flag = true;
				q.push({ny, nx});
			}
		}
	}
	return flag;
}

bool checkBorder()
{
	int check = 0;
	int cnt = 1;
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			if(border[y][x] == 0)
			{
				if(openBorder(y, x, cnt))
				{
					check++;
					cnt++;
				}
			}
		}
	}
	if(check > 0)
		return true;
	return false;
}

void makeMap()
{
	cin >> n >> l >> r;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
			cin >> arr[y][x];
}

void solve()
{
	makeMap();
	while(checkBorder())
	{
		readyToMove();
		day++;
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
	cout << day;
}