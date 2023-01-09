#include <iostream>
#include <queue>
#include <tuple>
#include <cstring>
using namespace std;
typedef tuple<int, int, int> tiii;
typedef pair<int, int> pii;

int cheese[100][100], n, m;
int dy[] = {0, 0, 1, -1};
int dx[] = {1, -1, 0, 0};
bool visit[100][100];
queue<pii> q2;

bool checkCheese(int y, int x)
{
	int sum = 0;
	for(int i = 0; i < 4; i++)
	{
		int ny = y + dy[i];
		int nx = x + dx[i];
		if(cheese[ny][nx] == -1)
			sum++;
	}
	if(sum >= 2)
		return true;
	return false;
}

void checkInterior(int y, int x)
{
	cheese[y][x] = -1;
	visit[y][x] = 1;
	for(int i = 0; i < 4; i++)
	{
		int ny = y + dy[i];
		int nx = x + dx[i];
		if(ny < 0 || nx < 0 || ny >= n || nx >= m || visit[ny][nx])
			continue;
		if(cheese[ny][nx] != 1)
			checkInterior(ny, nx);
	}
}

void onehourLater()
{
	while(!q2.empty())
	{
		int y = q2.front().first;
		int x = q2.front().second;
		q2.pop();
		cheese[y][x] = -1;
	}
	memset(visit, 0, sizeof(visit));
	checkInterior(0, 0);
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	queue<tiii> q;
	cin >> n >> m;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
		{
			cin >> cheese[y][x];
			if(cheese[y][x] == 1)
				q.push({y, x, 1});
		}
	checkInterior(0, 0);
	int count = 0;
	while(!q.empty())
	{
		int y = get<0>(q.front());
		int x = get<1>(q.front());
		if(count != get<2>(q.front()))
			onehourLater();
		count = get<2>(q.front());
		q.pop();
		if(checkCheese(y, x))
			q2.push({y, x});
		else
			q.push({y, x, count + 1});
	}
	cout << count;
}