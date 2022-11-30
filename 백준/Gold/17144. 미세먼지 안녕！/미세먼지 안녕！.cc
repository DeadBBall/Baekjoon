#include <iostream>
#include <vector>
using namespace std;

int r, c, map[2][51][51] = {0};
vector<int> cleaner;
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};

void resetMap()
{
	for(int y = 1; y <= r; y++)
		for(int x = 1; x <= c; x++)
			map[1][y][x] = 0;
}

void clean(int num)
{
	int cleanerY = cleaner[num];
	if(num == 0)
	{
		for(int y = cleanerY - 1; y > 1; y--)
			map[0][y][1] = map[0][y - 1][1];
		for(int x = 1; x < c; x++)
			map[0][1][x] = map[0][1][x + 1];
		for(int y = 1; y < cleanerY; y++)
			map[0][y][c] = map[0][y + 1][c];
		for(int x = c; x > 1; x--)
		{
			if(map[0][cleanerY][x - 1] == -1)
				map[0][cleanerY][x] = 0;
			else
				map[0][cleanerY][x] = map[0][cleanerY][x - 1];
		}
	}
	else
	{
		for(int y = cleanerY + 1; y < r; y++)
			map[0][y][1] = map[0][y + 1][1];
		for(int x = 1; x < c; x++)
			map[0][r][x] = map[0][r][x + 1];
		for(int y = r; y > cleanerY; y--)
			map[0][y][c] = map[0][y - 1][c];
		for(int x = c; x > 1; x--)
		{
			if(map[0][cleanerY][x - 1] == -1)
				map[0][cleanerY][x] = 0;
			else
				map[0][cleanerY][x] = map[0][cleanerY][x - 1];
		}
	}
}

void solve()
{
	resetMap();
	for(int y = 1; y <= r; y++)
		for(int x = 1; x <= c; x++)
			if(map[0][y][x] > 0)
			{
				int num = 0;
				for(int i = 0; i < 4; i++)
				{
					int ny = dy[i] + y;
					int nx = dx[i] + x;
					if(ny < 1 || nx < 1 || ny > r || nx > c || map[0][ny][nx] == -1)
						continue;
					num++;
					map[1][ny][nx] += map[0][y][x] / 5;
				}
				map[1][y][x] -= map[0][y][x] / 5 * num;
			}
	for(int y = 1; y <= r; y++)
		for(int x = 1; x <= c; x++)
			map[0][y][x] += map[1][y][x];
	clean(0);
	clean(1);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t, ans = 0;
	cin >> r >> c >> t;
	for(int y = 1; y <= r; y++)
		for(int x = 1; x <= c; x++)
		{
			cin >> map[0][y][x];
			if(map[0][y][x] == -1)
				cleaner.push_back(y);
		}
	while(t--)
		solve();
	for(int y = 1; y <= r; y++)
		for(int x = 1; x <= c; x++)
			ans += map[0][y][x];
	cout << ans + 2;
}