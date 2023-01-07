#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;
typedef pair<int, int> pii;
#define INF 99999999

int n, m, dist[1000] = {0}, route[1000];
vector<pii> bus[1000];
vector<int> route_v;

struct cmp
{
  bool operator()(pii a, pii b)
	{
		return a.second > b.second;
  }
};

void dijkstra(int start)
{
	priority_queue<pii, vector<pii>, cmp> pq;
	pq.push({start, 0});
	dist[start] = 0;
	while(!pq.empty())
	{
		int now = pq.top().first;
		int dis = pq.top().second;
		pq.pop();
		if(dis > dist[now])
			continue;
		for(int i = 0; i < (int)bus[now].size(); i++)
		{
			int cost = dis + bus[now][i].second;
			if(cost < dist[bus[now][i].first])
			{
				route[bus[now][i].first] = now;
				dist[bus[now][i].first] = cost;
				pq.push({bus[now][i].first, cost});
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
	int start, end;
	cin >> start >> end;
	fill(dist, dist + 1000, INF);
	dijkstra(start);
	cout << dist[end] << "\n";
	int tmp = end;
	while(tmp)
	{
		route_v.push_back(tmp);
		tmp = route[tmp];
	}
	cout << route_v.size() << "\n";
	for(int i = route_v.size() - 1; i >= 0; i--)
		cout << route_v[i] << " ";
	cout << "\n";
}