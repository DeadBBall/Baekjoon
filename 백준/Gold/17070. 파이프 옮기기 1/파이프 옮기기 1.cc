#include <iostream>
using namespace std;

bool house[17][17];
int n, ans = 0;

void setHouse()
{
	cin >> n;
	for(int i = 1; i <= n; i++)
		for(int j = 1; j <= n; j++)
			cin >> house[i][j];
}

void movePipe(int y, int x, int pipeDirection)
{
	if(y == n && x == n)
	{
		ans++;
		return;
	}
	else if(pipeDirection == 0)
	{
		if(x + 1 <= n && house[y][x + 1] == false)
			movePipe(y, x + 1, 0);
		if(x + 1 <= n && y + 1 <= n && house[y][x + 1] == 0 && house[y + 1][x] == 0 && house[y + 1][x + 1] == 0)
			movePipe(y + 1, x + 1, 1);
	}
	else if(pipeDirection == 1)
	{
		if(x + 1 <= n && house[y][x + 1] == false)
			movePipe(y, x + 1, 0);
		if(x + 1 <= n && y + 1 <= n && house[y][x + 1] == 0 && house[y + 1][x] == 0 && house[y + 1][x + 1] == 0)
			movePipe(y + 1, x + 1, 1);
		if(y + 1 <= n && house[y + 1][x] == false)
			movePipe(y + 1, x, 2);
	}
	else
	{
		if(x + 1 <= n && y + 1 <= n && house[y][x + 1] == 0 && house[y + 1][x] == 0 && house[y + 1][x + 1] == 0)
			movePipe(y + 1, x + 1, 1);
		if(y + 1 <= n && house[y + 1][x] == false)
			movePipe(y + 1, x, 2);
	}
}

void solve()
{
	setHouse();
	movePipe(1, 2, 0);
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	solve();
	cout << ans;
}