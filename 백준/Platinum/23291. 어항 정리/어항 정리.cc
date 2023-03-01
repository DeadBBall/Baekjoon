#include <iostream>
#include <algorithm>
#include <cstdlib>
using namespace std;

int n, k, arr[100], map[100][100], shareMap[100][100];
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};
int ans;
int abc;
bool flag;

void input()
{
	cin >> n >> k;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
}

void addFish()
{
	int fishMin = 10001;
	fill(&map[0][0], &map[99][100], 0);

	for (int i = 0; i < n; i++)
	{
		fishMin = min(fishMin, arr[i]);
	}

	for (int i = 0; i < n; i++)
	{
		if (fishMin == arr[i])
		{
			arr[i]++;
		}
		map[0][i] = arr[i];
	}
}

int checkY(int idx)
{
	for(int i = 1; i < 100; i++)
	{
		if(map[i][idx] == 0)
		{
			return i;
		}
	}
	return -1;
}

void	levitateFishbowl()
{
	while(true)
	{
		int idx = 0;
		for (idx = 0; idx < n; idx++)
		{
			if (map[0][idx] != 0)
			{
				break;
			}
		}
		for(int i = idx; i < n; i++)
		{
			if(map[1][i] == 0 || i == n - 1)
			{
				int height = checkY(idx);

				if(height > n - i)
				{
					return;
				}
				if(height == 1)
				{
					i = 1;
				}
				int tmpMap[i - idx][height] = {0};

				for(int y = 0; y < height; y++)
				{
					for(int x = idx; x < i; x++)
					{
						tmpMap[i - x - 1][y] = map[y][x];
						map[y][x] = 0;
					}
				}
				for(int x = 0; x < height; x++)
				{
					for(int y = 0; y < i - idx; y++)
					{
						map[y + 1][x + i] = tmpMap[y][x];
					}
				}
				break;
			}
		}
	}
}

void shareFish()
{
	fill(&shareMap[0][0], &shareMap[99][100], 0);
	int idx = 0;
	for(; idx < n; idx++)
	{
		if(map[0][idx] != 0)
		break;
	}
	bool visit[100][100] = {0};
	int height = checkY(idx);
	for(int y = 0; y < height; y++)
	{
		for(int x = idx; x < n; x++)
		{
			if(map[y][x] == 0)
			{
				continue;
			}
			visit[y][x] = true;
			for(int i = 0; i < 4; i++)
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= n || visit[ny][nx] || map[ny][nx] == 0)
				{
					continue;
				}
				int diff = abs(map[y][x] - map[ny][nx]) / 5;
				if(map[y][x] > map[ny][nx])
				{
					shareMap[y][x] -= diff;
					shareMap[ny][nx] += diff;
				}
				else
				{
					shareMap[y][x] += diff;
					shareMap[ny][nx] -= diff;
				}
			}
		}
	}

	for(int y = 0; y < height; y++)
	{
		for(int x = idx; x < n; x++)
		{
			map[y][x] += shareMap[y][x];
		}
	}
	int i = 0;
	for(int x = idx; x < n; x++)
	{
		for(int y = 0; y < height; y++)
		{
			if(map[y][x] == 0)
			{
				continue;
			}
			arr[i++] = map[y][x];
		}
	}
}

void checkDiff()
{
	int minFish = 10000;
	int maxFish = 1;
	for(int i = 0; i < n; i++)
	{
		minFish = min(minFish, arr[i]);
		maxFish = max(maxFish, arr[i]);
	}
	if(k >= maxFish - minFish)
	{
		flag = true;
	}
}

void levitateFishbowl2()
{
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			map[y][x] = 0;
			map[0][x] = arr[x];
		}
	}

	for(int x = 0; x < n / 2; x++)
	{
		map[1][n - 1 - x] = map[0][x];
		map[0][x] = 0;
	}

	for(int x = n / 2; x < n / 4 * 3; x++)
	{
		for(int y = 0; y < 2; y++)
		{
			map[3 - y][3 * n / 2 - 1 - x] = map[y][x];
			map[y][x] = 0;
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	checkDiff();
	if(flag)
	{
		cout << ans;
		return 0;
	}
	while(true)
	{
		addFish();
		levitateFishbowl();
		shareFish();
		levitateFishbowl2();
		shareFish();
		checkDiff();
		ans++;
		if(flag)
		{
			cout << ans;
			return 0;
		}
	}
}
