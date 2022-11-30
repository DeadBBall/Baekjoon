#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
typedef pair<int, int> pii;
#define INF 987654321

vector<pii> v[1001];
int dist[1001], total[1001] = {0};

struct cmp
{
  bool operator()(pii a, pii b)
	{
		return a.first > b.first;
  }
};

void dij(int start)
{
	priority_queue<pii, vector<pii>, cmp> pq;
	pq.push({0, start});
	dist[start] = 0;
	while(!pq.empty())
	{
		int time = pq.top().first;
		int now = pq.top().second;
		pq.pop();
		if(time > dist[now])
			continue;
		for(int i = 0; i < (int)v[now].size(); i++)
		{
			int cost = time + v[now][i].second;
			if(cost < dist[v[now][i].first])
			{
				dist[v[now][i].first] = cost;
				pq.push({cost, v[now][i].first});
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m, x, ans = 0;
	cin >> n >> m >> x;
	while(m--)
	{
		int from, to, time;
		cin >> from >> to >> time;
		v[from].push_back({to, time});
	}
	for(int i = 1; i <= n; i++)
	{
		fill(dist, dist + n + 1, INF);
		dij(i);
		total[i] += dist[x];
		if(i == x)
			for(int j = 1; j <= n; j++)
				total[j] += dist[j];
	}
	for(int i = 1; i <= n; i++)
		ans = max(ans, total[i]);
	cout << ans;
}