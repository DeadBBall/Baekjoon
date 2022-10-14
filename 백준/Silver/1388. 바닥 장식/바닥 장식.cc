#include <iostream>

using namespace std;

int n, m, ans = 0;
char c[50][50];

void dfs(int y, int x, int check)
{
	c[y][x] = '.';
	if(check == 0 && x + 1 < m && c[y][x + 1] == '-')
		dfs(y, x + 1, 0);
	else if(check == 1 && y + 1 < n && c[y + 1][x] == '|')
		dfs(y + 1, x, 1);
}

int main()
{
	cin >> n >> m;
	for(int i = 0; i < n; i++)
		cin >> c[i];
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
		{
			ans++;
			if(c[y][x] == '-')
				dfs(y, x, 0);
			else if(c[y][x] == '|')
				dfs(y, x, 1);
			else
				ans--;
		}
	cout << ans;
}