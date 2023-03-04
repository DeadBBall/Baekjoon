#include <iostream>
using namespace std;

int map[499][499], n, ans;
int dy[] = {0, 1, 0, -1};
int dx[] = {-1, 0, 1, 0};
int lastSand;

//a 55%

void input()
{
	cin >> n;
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			cin >> map[y][x];
		}
	}
}

void checkMap(int y, int x, int sand)
{
	lastSand -= sand;
	if(y >= n || x >= n || y < 0 || x < 0)
	{
		ans += sand;
		return;
	}

	map[y][x] += sand;
}

void spread(int y, int x, int drct)
{
	int sand = map[y][x];
	lastSand = map[y][x];
	if(drct == 0)
	{
		checkMap(y, x - 2, sand * 0.05);
		checkMap(y - 1, x, sand * 0.07);
		checkMap(y + 1, x, sand * 0.07);
		checkMap(y + 2, x, sand * 0.02);
		checkMap(y - 2, x, sand * 0.02);
		checkMap(y + 1, x + 1, sand * 0.01);
		checkMap(y - 1, x + 1, sand * 0.01);
		checkMap(y + 1, x - 1, sand * 0.1);
		checkMap(y - 1, x - 1, sand * 0.1);
		checkMap(y, x - 1, lastSand);
	}
	else if(drct == 1)
	{
		checkMap(y + 2, x, sand * 0.05);
		checkMap(y, x - 1, sand * 0.07);
		checkMap(y, x + 1, sand * 0.07);
		checkMap(y, x + 2, sand * 0.02);
		checkMap(y, x - 2, sand * 0.02);
		checkMap(y - 1, x + 1, sand * 0.01);
		checkMap(y - 1, x - 1, sand * 0.01);
		checkMap(y + 1, x + 1, sand * 0.1);
		checkMap(y + 1, x - 1, sand * 0.1);
		checkMap(y + 1, x, lastSand);
	}
	else if(drct == 2)
	{
		checkMap(y, x + 2, sand * 0.05);
		checkMap(y - 1, x, sand * 0.07);
		checkMap(y + 1, x, sand * 0.07);
		checkMap(y + 2, x, sand * 0.02);
		checkMap(y - 2, x, sand * 0.02);
		checkMap(y + 1, x - 1, sand * 0.01);
		checkMap(y - 1, x - 1, sand * 0.01);
		checkMap(y + 1, x + 1, sand * 0.1);
		checkMap(y - 1, x + 1, sand * 0.1);
		checkMap(y, x + 1, lastSand);
	}
	else
	{
		checkMap(y - 2, x, sand * 0.05);
		checkMap(y, x - 1, sand * 0.07);
		checkMap(y, x + 1, sand * 0.07);
		checkMap(y, x + 2, sand * 0.02);
		checkMap(y, x - 2, sand * 0.02);
		checkMap(y + 1, x + 1, sand * 0.01);
		checkMap(y + 1, x - 1, sand * 0.01);
		checkMap(y - 1, x + 1, sand * 0.1);
		checkMap(y - 1, x - 1, sand * 0.1);
		checkMap(y - 1, x, lastSand);
	}
	map[y][x] = 0;
}

void move()
{
	int nowY = n / 2;
	int nowX = n / 2;
	int drct = 0;
	int speed = 1;
	int cnt = 0;
	while(true)
	{
		for(int i = 0; i < speed; i++)
		{
			nowY += dy[drct];
			nowX += dx[drct];
			if(map[nowY][nowX] > 0 )
			{
				spread(nowY, nowX, drct);
			}
		}
		cnt++;
		if(cnt == 2)
		{
			cnt = 0;
			if(speed != n - 1)
			{
				speed++;
			}
		}
		if(nowY == 0 && nowX == 0)
		{
			break;
		}
		drct++;
		if(drct == 4)
		{
			drct = 0;
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	move();
	cout << ans;
}
