#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

typedef tuple<int, int, int> tiii;

int m, n, k;
int tomato[100][100][100];
int dx[] = {1, -1, 0, 0, 0, 0};
int dy[] = {0, 0, 1, -1, 0, 0};
int dz[] = {0, 0, 0, 0, 1, -1};

int main()
{
	queue<tiii> q;
	cin >> m >> n >> k;
	for (int z = 0; z < k; z++)
		for (int y = 0; y < n; y++)
			for (int x = 0; x < m; x++)
			{
				cin >> tomato[z][y][x];
				if (tomato[z][y][x] == 1)
					q.push(make_tuple(z, y, x));
			}
	while (!q.empty())
	{
		tiii now = q.front();
		q.pop();
		for(int i = 0; i < 6; i++)
		{
			int nz = get<0>(now) + dz[i];
			int ny = get<1>(now) + dy[i];
			int nx = get<2>(now) + dx[i];
			if (ny < 0 || nx < 0 || nz < 0 || ny >= n || nx >= m || nz >= k)
				continue;
			if (tomato[nz][ny][nx] == 0)
			{
				tomato[nz][ny][nx] = tomato[get<0>(now)][get<1>(now)][get<2>(now)] + 1;
				q.push(make_tuple(nz, ny, nx));
			}
		}
	}
	int ans = 0;
	for (int z = 0; z < k; z++)
		for (int y = 0; y < n; y++)
			for (int x = 0; x < m; x++)
			{
				if(tomato[z][y][x] == 0)
				{
					cout << "-1";
					return (0);
				}
				ans = max(ans, tomato[z][y][x]);
			}
	cout << ans - 1;
}