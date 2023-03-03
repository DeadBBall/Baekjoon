#include <iostream>
#include <vector>
using namespace std;

struct fireball
{
	int y;
	int x;
	int mass;
	int speed;
	int drct;
};

int n, m, k;
int dy[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
int dx[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
vector<fireball> map[51][51];
vector<fireball> fb;
int ans;

void input()
{
	cin >> n >> m >> k;
	for (int i = 0; i < m; i++)
	{
		int y, x, mass, speed, drct;
		cin >> y >> x >> mass >> speed >> drct;
		fb.push_back({ y, x, mass, speed, drct });
	}
}

void calculateFireball()
{
	vector<fireball> tmp;
	for (int y = 1; y <= n; y++)
	{
		for (int x = 1; x <= n; x++)
		{
			if (map[y][x].size() == 0)
			{
				continue;
			}

			else if (map[y][x].size() == 1)
			{
				tmp.push_back(map[y][x][0]);
				continue;
			}

			int mass = 0;
			int speed = 0;
			int size = map[y][x].size();

			bool even = true;
			bool odd = true;
			for (int k = 0; k < map[y][x].size(); k++)
			{
				mass += map[y][x][k].mass;
				speed += map[y][x][k].speed;
				if (map[y][x][k].drct % 2 == 0) odd = false;
				else even = false;
			}

			mass /= 5;
			speed /= size;
			if (mass == 0)
			{
				continue;
			}

			if (even || odd)
			{
				for (int k = 0; k < 8; k += 2)
				{
					tmp.push_back({ y, x, mass, speed, k });
				}
			}

			else
			{
				for (int k = 1; k < 8; k += 2)
				{
					tmp.push_back({ y, x, mass, speed, k });
				}
			}
		}
	}
	fb = tmp;
}

void moveFireball()
{
	for (int y = 1; y <= n; y++)
	{
		for (int x = 1; x <= n; x++)
		{
			map[y][x].clear();
		}
	}

	for (int i = 0; i < fb.size(); i++)
	{
		int y = fb[i].y;
		int x = fb[i].x;
		int mass = fb[i].mass;
		int speed = fb[i].speed;
		int drct = fb[i].drct;

		int moveNum = speed % n;
		int ny = y + dy[drct] * moveNum;
		int nx = x + dx[drct] * moveNum;

		if (nx > n)
		{
			nx -= n;
		}
		else if (nx < 1)
		{
			nx += n;
		}
		if (ny > n)
		{
			ny -= n;
		}
		else if (ny < 1)
		{
			ny += n;
		}
		map[ny][nx].push_back({ ny, nx, mass, speed, drct });
	}

}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	for (int i = 0; i < k; i++)
	{
		moveFireball();
		calculateFireball();
	}
	for (int i = 0; i < fb.size(); i++)
	{
		ans += fb[i].mass;
	}
	cout << ans;
}