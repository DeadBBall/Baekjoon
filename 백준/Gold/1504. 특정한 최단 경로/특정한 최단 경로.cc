#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
typedef pair<int, int> pii;
#define INF 9876543

int n, v, v2, dist[801];
vector<pii> graph[801];

void dij(int start)
{
	for(int i = 1; i <= n; i++)
		dist[i] = INF;
	priority_queue<pii, vector<pii>, greater<pii>> pq;
	pq.push({0, start});
	dist[start] = 0;
	while(!pq.empty())
	{
		int minCost = pq.top().first;
		int now = pq.top().second;
		pq.pop();
		if(minCost > dist[now])
			continue;
		for(int i = 0; i < (int)graph[now].size(); i++)
		{
			int cost = minCost + graph[now][i].second;
			if(cost < dist[graph[now][i].first])
			{
				dist[graph[now][i].first] = cost;
				pq.push({cost, graph[now][i].first});
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int e;
	cin >> n >> e;
	for(int i = 0; i < e; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		graph[a].push_back({b, c});
		graph[b].push_back({a, c});
	}
	cin >> v >> v2;
	int StoV, StoV2, VtoV2, VtoN, V2toN, ans = INF;
	dij(1);
	StoV = dist[v];
	StoV2 = dist[v2];
	dij(v);
	VtoN = dist[n];
	VtoV2 = dist[v2];
	dij(v2);
	V2toN = dist[n];
	ans = min(ans, StoV + VtoV2 + V2toN);
	ans = min(ans, StoV2 + VtoV2 + VtoN);
	if(VtoV2 == INF || ans == INF)
		cout << -1;
	else
		cout << ans;
}