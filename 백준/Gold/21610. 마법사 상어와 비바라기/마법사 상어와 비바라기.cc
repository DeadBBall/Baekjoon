#include <iostream>
#include <vector>
using namespace std;
typedef pair<int, int> pii;

int dy[] = {0, 0, -1, -1, -1, 0, 1, 1, 1 };
int dx[] = {0, -1, -1, 0, 1, 1, 1, 0, -1 };
int n, m, map[51][51], ans;
int orders[100][2];
bool visit[51][51];
vector <pii> v;
vector<pii> tmp;

void input()
{
	cin >> n >> m;

	for (int y = 1; y <= n; y++)
	{
		for (int x = 1; x <= n; x++)
		{
			cin >> map[y][x];
		}
	}

	for (int i = 0; i < m; i++)
	{
		cin >> orders[i][0] >> orders[i][1];
	}

	v.push_back({ n, 1 });
	v.push_back({ n, 2 });
	v.push_back({ n - 1, 1 });
	v.push_back({ n - 1, 2 });
}

void resetVisit()
{
	for (int y = 1; y <= n; y++)
	{
		for (int x = 1; x <= n; x++)
		{
			visit[y][x] = false;
		}
	}
}

void makeCloud()
{
	v.clear();
	for (int y = 1; y <= n; y++)
	{
		for (int x = 1; x <= n; x++)
		{
			if (map[y][x] >= 2 && !visit[y][x])
			{
				map[y][x] -= 2;
				v.push_back({ y, x });
			}
		}
	}
}

void doMagic()
{
	for (int orderSize = 0; orderSize < m; orderSize++)
	{
		tmp.clear();
		int drct = orders[orderSize][0];
		int speed = orders[orderSize][1];

		for (int j = 0; j < v.size(); j++)
		{
			int move = speed % n;
			int ny = v[j].first + dy[drct] * move;
			int nx = v[j].second + dx[drct] * move;

			if (ny > n)
			{
				ny -= n;
			}
			else if (ny < 1)
			{
				ny += n;
			}
			if (nx > n)
			{
				nx -= n;
			}
			else if (nx < 1)
			{
				nx += n;
			}

			map[ny][nx]++;
			tmp.push_back({ ny, nx });
		}

		for (int j = 0; j < tmp.size(); j++)
		{
			int cnt = 0;
			int y = tmp[j].first;
			int x = tmp[j].second;
			visit[y][x] = true;
			for (int i = 2; i < 9; i += 2)
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				if (ny < 1 || nx < 1 || ny > n || nx > n)
				{
					continue;
				}
				if (map[ny][nx] != 0)
				{
					cnt++;
				}
			}
			map[y][x] += cnt;
		}
		makeCloud();
		resetVisit();
	}

	for (int y = 1; y <= n; y++)
	{
		for (int x = 1; x <= n; x++)
		{
			ans += map[y][x];
		}
	}
}

int main()
{
	input();
	doMagic();
	cout << ans;
}