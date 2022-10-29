#include <iostream>
using namespace std;

int n, m, r, c, d, ans = 0, checkAngle = 0;
int map[50][50];
int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, -1, 1};

bool checkMove(int y, int x)
{
	if(map[y][x] == 1)
		return false;
	return true;
}

void solve(int y, int x)
{
	if(d == -1)
		d = 3;
	if(map[y][x] == 0)
	{
		ans++;
		map[y][x] = -1;
	}
	if(checkAngle != 4 && d == 0)
	{
		d--;
		if(checkMove(y, x - 1) && map[y][x - 1] != -1)
		{
			checkAngle = 0;
			solve(y, x - 1);
		}
		else
		{
			checkAngle++;
			solve(y, x);
		}
	}
	else if(checkAngle != 4 && d == 1)
	{
		d--;
		if(checkMove(y - 1, x) && map[y - 1][x] != -1)
		{
			checkAngle = 0;
			solve(y - 1, x);
		}
		else
		{
			checkAngle++;
			solve(y, x);
		}
	}
	else if(checkAngle != 4 && d == 2)
	{
		d--;
		if(checkMove(y, x + 1) && map[y][x + 1] != -1)
		{
			checkAngle = 0;
			solve(y, x + 1);
		}
		else
		{
			checkAngle++;
			solve(y, x);
		}
	}
	else if(checkAngle != 4 && d == 3)
	{
		d--;
		if(checkMove(y + 1, x) && map[y + 1][x] != -1)
		{
			checkAngle = 0;
			solve(y + 1, x);
		}
		else
		{
			checkAngle++;
			solve(y, x);
		}
	}
	else if(checkAngle == 4)
	{
		checkAngle = 0;
		if(d == 0 && checkMove(y + 1, x))
			solve(y + 1, x);
		else if(d == 1 && checkMove(y, x - 1))
			solve(y, x - 1);
		else if(d == 2 && checkMove(y - 1, x))
			solve(y - 1, x);
		else if(d == 3 && checkMove(y, x + 1))
			solve(y, x + 1);
		else
			return;
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m >> r >> c>> d;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
			cin >> map[y][x];
	solve(r, c);
	cout << ans;
}