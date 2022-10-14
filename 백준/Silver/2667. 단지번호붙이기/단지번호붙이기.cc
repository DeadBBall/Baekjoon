#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int map[26][26], n, ans;

int dy[] = {-1, 1, 0, 0};
int dx[] = {0, 0, -1, 1};
vector<int> v;

void dfs(int y, int x)
{
	map[y][x] = 0;
	ans++;
	for(int i = 0; i < 4; i++)
	{
		int ny = dy[i] + y;
		int nx = dx[i] + x;
		if(ny < 0 || ny > n || nx < 0 || nx > n)
			continue;
		if(map[ny][nx] == 1)
			dfs(ny, nx);
	}
}

int main()
{
	cin >> n;
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			scanf("%1d", &map[i][j]);
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
			if(map[y][x] == 1)
			{
				ans = 0;
				dfs(y, x);
				v.push_back(ans);
			}
	sort(v.begin(), v.end());
	cout << v.size() << "\n";
	for(int i = 0; i < v.size(); i++)
		cout << v[i] << "\n";
}