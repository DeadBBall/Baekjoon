#include <iostream>
using namespace std;

int n, m, tetromino[500][500];
bool visit[500][500] = {0};
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};
int ans = 0, sum = 0;

void dfs(int y, int x, int num)
{
	sum += tetromino[y][x];
	if(num == 4)
		return;
	for(int i = 0; i < 4; i++)
	{
		int ny = y + dy[i];
		int nx = x + dx[i];
		if(ny < 0 || nx < 0 || ny >= n || nx >= m)
			continue;
		if(!visit[ny][nx])
		{
			visit[ny][nx] = true;
			dfs(ny, nx, num + 1);
			visit[ny][nx] = false;
			if(num == 3)
				ans = max(ans, sum);
			sum -= tetromino[ny][nx];
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
    cin.tie(NULL);
	cin >> n >> m;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
			cin >> tetromino[y][x];
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
		{
			sum = 0;
			visit[y][x] = true;
			dfs(y, x, 1);
			visit[y][x] = false;
			if(y + 1 < n && x + 2 < m) // ㅜ
				ans = max(ans, tetromino[y][x] + tetromino[y + 1][x + 1] + tetromino[y][x + 1]  + tetromino[y][x + 2]);
			if(y + 2 < n && x + 1 < m) // ㅏ
				ans = max(ans, tetromino[y][x] + tetromino[y + 1][x] + tetromino[y + 2][x] + tetromino[y + 1][x + 1]);
			if(y - 1 >= 0 && x + 2 < m) // ㅗ
				ans = max(ans, tetromino[y][x] + tetromino[y - 1][x + 1] + tetromino[y][x + 1] + tetromino[y][x + 2]);
			if(y + 2 < n && x - 1 >= 0) // ㅓ
				ans = max(ans, tetromino[y][x] + tetromino[y + 1][x] + tetromino[y + 1][x - 1] + tetromino[y + 2][x]);
		}
	cout << ans;
}