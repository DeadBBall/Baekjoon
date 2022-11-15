#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
typedef pair<int, int> pii;
#define INF 987654321

int n, m, dist[1001];
vector<pii> bus[1001];

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
	dist[start] = 0;
	while(!pq.empty())
	{
		int d = pq.top().first;
		int now = pq.top().second;
		pq.pop();
		if(d > dist[now])
			continue;
		for(int i = 0; i < (int)bus[now].size(); i++)
		{
			int cost = d + bus[now][i].second;
			if(cost < dist[bus[now][i].first])
			{
				dist[bus[now][i].first] = cost;
				pq.push({cost, bus[now][i].first});
			}
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for(int i = 0; i < m; i++)
	{
		int start, end, cost;
		cin >> start >> end >> cost;
		bus[start].push_back({end, cost});
	}
	int startObj, endObj;
	cin >> startObj >> endObj;
	fill(dist, dist + 1001, INF);
	dijkstra(startObj);
	cout << dist[endObj];
}