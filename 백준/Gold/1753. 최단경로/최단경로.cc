#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
#define INF 1000000
typedef pair<int, int> pii;

int d[20001], v, e, k;
vector<pii> graph[20001];

struct cmp
{
  bool operator()(pii a, pii b)
	{
		return a.first > b.first;
  }
};

void dijkstra(int start)
{
	priority_queue<pii, vector<pii>, cmp> pq;
	pq.push({0, start});
	d[start] = 0;
	while(!pq.empty())
	{
		int dist = pq.top().first;
		int now = pq.top().second;
		pq.pop();
		if(dist > d[now])
			continue;
		for (int i = 0; i < graph[now].size(); i++)
		{
			int cost = dist + graph[now][i].second;
			if (cost < d[graph[now][i].first])
			{
				d[graph[now][i].first] = cost;
				pq.push({cost, graph[now][i].first});
			}
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> v >> e >> k;
	for(int i = 0; i < e; i++)
	{
		int u, b, w;
		cin >> u >> b >> w;
		graph[u].push_back({b, w});
	}
	fill(d, d + 20001, INF);
	dijkstra(k);
	for(int i = 1; i <= v; i++)
	{
		if(d[i] == INF)
			cout << "INF" << "\n";
		else
			cout << d[i] << "\n";
	}
}