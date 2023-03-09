#include <iostream>
#include <algorithm>
using namespace std;

int n, m, h, a, b, ans = 4;
bool map[31][11];
int ladders[11];

void input()
{
	cin >> n >> m >> h;
	for (int i = 0; i < m; i++)
	{
		cin >> a >> b;
		map[a][b] = true;
		ladders[b]++;
	}
}

bool checkLadder()
{
	for (int i = 1; i <= n; i++)
	{
		int start = i;
		int now = 1;
		while (now != h + 1)
		{
			if (map[now][start])
			{
				start++;
			}
			else if(!map[now][start] && start > 1 && map[now][start - 1])
			{
				start--;
			}
			now++;
		}
		if (start != i)
		{
			return false;
		}
	}
	return true;
}

void makeLadder(int idx, int cnt)
{
	if (checkLadder())
	{
		ans = min(cnt, ans);
		return;
	}

	if (cnt == 3)
	{
		return;
	}

	for (int i = 1; i < n; i++)
	{
		for (int j = idx; j <= h; j++)
		{
			if (map[j][i] || (i != 1 && map[j][i - 1]))
			{
				continue;
			}
			map[j][i] = true;
			makeLadder(j, cnt + 1);
			map[j][i] = false;
		}
	}
}

bool checkMap()
{
	int cnt = 0;
	for(int i = 1; i <= n; i++)
	{
		if(ladders[i] % 2 == 1)
		{
			cnt++;
		}
	}
	if(cnt > 3)
	{
		return false;
	}
	return true;
}


int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	if(checkMap())
	{
		makeLadder(1, 0);
	}
	cout << (ans > 3 ? -1 : ans);
}
