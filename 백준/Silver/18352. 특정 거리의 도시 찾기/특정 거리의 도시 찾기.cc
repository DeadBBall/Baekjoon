#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
#define INF 1000000
typedef pair<int, int> pii;

int n, m, k, x, d[300001], ans = 0;
vector<int> line[1000001];

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
		for(int i = 0; i < (int)line[now].size(); i++)
		{
			int cost = dist + 1;
			if(cost < d[line[now][i]])
			{
				d[line[now][i]] = cost;
				pq.push({cost, line[now][i]});
			}
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m >> k >> x;
	for(int i = 0; i < m; i++)
	{
		int a, b;
		cin >> a >> b;
		line[a].push_back(b);
	}
	fill(d, d + 300001, INF);
	dijkstra(x);
	for(int i = 1; i <= n; i++)
	{
		if(d[i] == k)
		{
			cout << i << "\n";
			ans++;
		}
	}
	if(ans == 0)
		cout << "-1";
}