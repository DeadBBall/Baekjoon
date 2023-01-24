#include <iostream>
#include <vector>
using namespace std;

struct shark
{
	int y;
	int x;
	int speed;
	int drct;
	int size;
};

int r, c, m, map[101][101], fishingSize = 0, fisherMan = 1;
int dy[] = {0, -1, 1, 0, 0};
int dx[] = {0, 0, 0, 1, -1};
vector<shark> sharks;

void moveShark(int idx)
{
	int y = sharks[idx].y;
	int x = sharks[idx].x;
	int speed = sharks[idx].speed;
	int size = sharks[idx].size;
	int drct = sharks[idx].drct;
	int restSpeed;
	if(drct >= 3)
		restSpeed = speed % ((c - 1) * 2);
	else
		restSpeed = speed % ((r - 1) * 2);
	while(restSpeed != 0)
	{
		int ny = y + restSpeed * dy[drct];
		int nx = x + restSpeed * dx[drct];
		if(ny < 1 || nx < 1 || ny > r || nx > c)
		{
			if(drct == 1)
			{
				restSpeed -= y - 1;
				y = 1;
			}
			else if(drct == 2)
			{
				restSpeed -= r - y;
				y = r;
			}
			else if(drct == 3)
			{
				restSpeed -= c - x;
				x = c;
			}
			else
			{
				restSpeed -= x - 1;
				x = 1;
			}
			if(drct % 2 == 1)
				drct++;
			else
				drct--;
		}
		else
		{
			restSpeed = 0;
			y = ny;
			x = nx;
		}
	}
	sharks[idx].x = x;
	sharks[idx].y = y;
	sharks[idx].drct = drct;
	if(map[y][x] != -1)
	{
		if(sharks[map[y][x]].size > sharks[idx].size)
			sharks[idx].size = 0;
		else
		{
			sharks[map[y][x]].size = 0;
			map[y][x] = idx;
		}
	}
	else
		map[y][x] = idx;
}

void fishing()
{
	for(int y = 1; y <= r; y++)
	{
		if(map[y][fisherMan] != -1)
		{
			fishingSize += sharks[map[y][fisherMan]].size;
			sharks[map[y][fisherMan]].size = 0;
			map[y][fisherMan] = -1;
			break;
		}
	}
	for(int y = 1; y <= r; y++)
		for(int x = 1; x <= c; x++)
			map[y][x] = -1;
	for(int i = 0; i < sharks.size(); i++)
	{
		if(sharks[i].size != 0)
			moveShark(i);
	}
	fisherMan++;
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> r >> c >> m;
	for(int y = 1; y <= r; y++)
		for(int x = 1; x <= c; x++)
			map[y][x] = -1;
	for(int i = 0; i < m; i++)
	{
		shark input;
		cin >> input.y >> input.x >> input.speed >> input.drct >> input.size;
		sharks.push_back(input);
		map[input.y][input.x] = i;
	}
	if(m != 0)
	{
		for(int x = 1; x <= c; x++)
			fishing();
	}
	cout << fishingSize;
}