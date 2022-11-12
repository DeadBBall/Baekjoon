#include <iostream>
#include <queue>
#include <tuple>
using namespace std;
typedef tuple<int, int, bool> tiib;

int n, m, visit[1000][1000][2], ans = -1;
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};
bool map[1000][1000];

void initMap()
{
	for(int y = 0; y < n; y++)
	{
		string s;
		cin >> s;
		for(int x = 0; x < m; x++)
			map[y][x] = s[x] - '0';
	}
}

int bfs()
{
	queue<tiib> q;
	visit[0][0][0] = 1;
	visit[0][0][1] = 1;
	q.push({0, 0, 0});
	while(!q.empty())
	{
		tiib now = q.front();
		q.pop();
		if(get<0>(now) == n - 1 && get<1>(now) == m - 1)
				return visit[get<0>(now)][get<1>(now)][get<2>(now)];
		for(int i = 0; i < 4; i++)
		{
			int ny = get<0>(now) + dy[i];
			int nx = get<1>(now) + dx[i];
			bool nSmash = get<2>(now);
			if(ny < 0 || nx < 0 || ny >= n || nx >= m)
				continue;
			if(map[ny][nx] && !nSmash)
			{
				nSmash = true;
				visit[ny][nx][nSmash] = visit[get<0>(now)][get<1>(now)][get<2>(now)] + 1;
				q.push({ny, nx, nSmash});
			}
			else if(visit[ny][nx][nSmash] == 0 && !map[ny][nx])
			{
				visit[ny][nx][nSmash] = visit[get<0>(now)][get<1>(now)][get<2>(now)] + 1;
				q.push({ny, nx, nSmash});
			}
		}
	}
	return -1;
}

void solve()
{
	initMap();
	ans = bfs();
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	solve();
	cout << ans;
}