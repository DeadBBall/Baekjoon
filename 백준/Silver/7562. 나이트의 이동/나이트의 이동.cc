#include <iostream>
#include <queue>
#include <tuple>
#include <cstring>
using namespace std;
typedef tuple<int, int, int> tiii;

int dy[] = {-2, -1, 1, 2, 2, 1, -1, -2};
int dx[] = {1, 2, 2, 1, -1, -2, -2, -1};
int y, x, l, objX, objY, ans;
bool visit[300][300];

void bfs()
{
	visit[y][x] = true;
	queue<tiii> q;
	q.push({y, x, 0});
	while(!q.empty())
	{
		tiii now = q.front();
		q.pop();
		if(get<0>(now) == objY && get<1>(now) == objX)
		{
			ans = ans < get<2>(now) ? ans : get<2>(now);
			return;
		}
		for(int i = 0; i < 8; i++)
		{
			int ny = get<0>(now) + dy[i];
			int nx = get<1>(now) + dx[i];
			if(ny >= l || nx >= l || ny < 0 || nx < 0 || visit[ny][nx] == true)
				continue;
			visit[ny][nx] = true;
			q.push({ny, nx, get<2>(now) + 1});
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t;
	cin >> t;
	while(t--)
	{
		ans = 9999999;
		cin >> l >> x >> y >> objX >> objY;
		memset(visit, 0, sizeof(visit));
		bfs();
		cout << ans << "\n";
	}
}