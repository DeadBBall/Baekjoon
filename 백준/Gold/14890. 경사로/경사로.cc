#include <iostream>
using namespace std;

int n, l, map[100][100], ans;

void input()
{
	cin >> n >> l;
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			cin >> map[y][x];
		}
	}
}

void checkRoad(int start, int num)
{
	bool flag = true;
	int cnt = 1;
	int nowHeight = map[start][0];

	if(num == 0)
	{
		for(int x = 1; x < n; x++)
		{
			if(nowHeight == map[start][x])
			{
				cnt++;
			}

			else
			{
				if(nowHeight + 1 == map[start][x] && cnt >= l)
				{
					nowHeight++;
					cnt = 1;
				}

				else if(nowHeight - 1 == map[start][x])
				{
					cnt = 0;
					flag = false;
					nowHeight--;
					while(nowHeight == map[start][x] && cnt < l)
					{
						cnt++;
						x++;
					}
					x--;
					if(cnt == l)
					{
						flag = true;
					}
					else
					{
						break;
					}
					cnt = 0;
				}

				else
				{
					flag = false;
					break;
				}
			}
		}

		if(flag)
		{
			ans++;
			return;
		}
	}

	else
	{
		nowHeight = map[0][start];
		for(int y = 1; y < n; y++)
		{
			if(nowHeight == map[y][start])
			{
				cnt++;
			}

			else
			{
				if(nowHeight + 1 == map[y][start] && cnt >= l)
				{
					nowHeight++;
					cnt = 1;
				}

				else if(nowHeight - 1 == map[y][start])
				{
					cnt = 0;
					flag = false;
					nowHeight--;

					while(nowHeight == map[y][start] && cnt < l)
					{
						cnt++;
						y++;
					}
					y--;

					if(cnt == l)
					{
						flag = true;
					}
					else
					{
						break;
					}
					cnt = 0;
				}

				else
				{
					flag = false;
					break;
				}
			}
		}

		if(flag)
		{
			ans++;
			return;
		}
	}
}

void checkMap()
{
	for(int y = 0; y < n; y++)
	{
		checkRoad(y, 0);
	}
	for(int x = 0; x < n; x++)
	{
		checkRoad(x, 1);
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	checkMap();
	cout << ans;
}