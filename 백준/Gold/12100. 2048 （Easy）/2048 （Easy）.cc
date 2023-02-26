#include <iostream>
#include <algorithm>
using namespace std;

int n;
int map[20][20];
int ans;

void input()
{
	cin >> n;
	for (int y = 0; y < n; y++)
	{
		for (int x = 0; x < n; x++)
		{
			cin >> map[y][x];
			ans = max(ans, map[y][x]);
		}
	}
}

void moveU()
{
	for (int x = 0; x < n; x++)
	{
		for (int y = 1; y < n; y++)
		{
			if (map[y][x] != 0)
			{
				for (int ny = y - 1; ny >= 0; ny--)
				{
					if (map[ny][x] == 0)
					{
						map[ny][x] = map[ny + 1][x];
						map[ny + 1][x] = 0;
					}
				}
			}
		}
	}

	for (int x = 0; x < n; x++)
	{
		for (int y = 0; y < n - 1; y++)
		{
			if(map[y][x] != 0 && map[y][x] == map[y + 1][x])
			{
				map[y][x] *= 2;
				map[y + 1][x] = 0;
				y++;
			}
		}
	}

	for (int x = 0; x < n; x++)
	{
		for (int y = 1; y < n; y++)
		{
			if (map[y][x] != 0)
			{
				for (int ny = y - 1; ny >= 0; ny--)
				{
					if (map[ny][x] == 0)
					{
						map[ny][x] = map[ny + 1][x];
						map[ny + 1][x] = 0;
					}
				}
			}
		}
	}
}

void moveD()
{
	for (int x = 0; x < n; x++)
	{
		for (int y = n - 2; y >= 0; y--)
		{
			if (map[y][x] != 0)
			{
				for (int ny = y + 1; ny < n; ny++)
				{
					if (map[ny][x] == 0)
					{
						map[ny][x] = map[ny - 1][x];
						map[ny - 1][x] = 0;
					}
				}
			}
		}
	}

	for (int x = 0; x < n; x++)
	{
		for (int y = n - 1; y >= 1; y--)
		{
			if(map[y][x] != 0 && map[y][x] == map[y - 1][x])
			{
				map[y][x] *= 2;
				map[y - 1][x] = 0;
				y--;
			}
		}
	}

	for (int x = 0; x < n; x++)
	{
		for (int y = n - 2; y >= 0; y--)
		{
			if (map[y][x] != 0)
			{
				for (int ny = y + 1; ny < n; ny++)
				{
					if (map[ny][x] == 0)
					{
						map[ny][x] = map[ny - 1][x];
						map[ny - 1][x] = 0;
					}
				}
			}
		}
	}
}

void moveL()
{
	for (int y = 0; y < n; y++)
	{
		for (int x = 1; x < n; x++)
		{
			if (map[y][x] != 0)
			{
				for (int nx = x - 1; nx >= 0; nx--)
				{
					if (map[y][nx] == 0)
					{
						map[y][nx] = map[y][nx + 1];
						map[y][nx + 1] = 0;
					}
				}
			}
		}
	}

	for (int y = 0; y < n; y++)
	{
		for (int x = 0; x < n - 1; x++)
		{
			if(map[y][x] != 0 && map[y][x] == map[y][x + 1])
			{
				map[y][x] *= 2;
				map[y][x + 1] = 0;
				x++;
			}
		}
	}

	for (int y = 0; y < n; y++)
	{
		for (int x = 1; x < n; x++)
		{
			if (map[y][x] != 0)
			{
				for (int nx = x - 1; nx >= 0; nx--)
				{
					if (map[y][nx] == 0)
					{
						map[y][nx] = map[y][nx + 1];
						map[y][nx + 1] = 0;
					}
				}
			}
		}
	}
}

void moveR()
{
	for (int y = 0; y < n; y++)
	{
		for (int x = n - 2; x >= 0; x--)
		{
			if (map[y][x] != 0)
			{
				for (int nx = x + 1; nx < n; nx++)
				{
					if (map[y][nx] == 0)
					{
						map[y][nx] = map[y][nx - 1];
						map[y][nx - 1] = 0;
					}
				}
			}
		}
	}

	for (int y = 0; y < n; y++)
	{
		for (int x = n - 1; x >= 1; x--)
		{
			if(map[y][x] != 0 && map[y][x] == map[y][x - 1])
			{
				map[y][x] *= 2;
				map[y][x - 1] = 0;
				x--;
			}
		}
	}

	for (int y = 0; y < n; y++)
	{
		for (int x = n - 2; x >= 0; x--)
		{
			if (map[y][x] != 0)
			{
				for (int nx = x + 1; nx < n; nx++)
				{
					if (map[y][nx] == 0)
					{
						map[y][nx] = map[y][nx - 1];
						map[y][nx - 1] = 0;
					}
				}
			}
		}
	}
}

void backtracking(int cnt)
{
	int copyMap[20][20];
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			copyMap[y][x] = map[y][x];
		}
	}

	if(cnt == 5)
	{
		for(int y = 0; y < n; y++)
		{
			for(int x = 0; x < n; x++)
			{
				ans = max(ans, map[y][x]);
			}
		}
		return;
	}

	for(int i = 0; i < 4; i++)
	{
		if(i == 0)
		{
			moveU();
		}
		else if(i == 1)
		{
			moveD();
		}
		else if(i == 2)
		{
			moveR();
		}
		else
		{
			moveL();
		}
		backtracking(cnt + 1);
		for(int y = 0; y < n; y++)
		{
			for(int x = 0; x < n; x++)
			{
				map[y][x] = copyMap[y][x];
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	backtracking(0);
	cout << ans;
}
