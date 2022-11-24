#include <iostream>
#include <vector>
#include <tuple>
using namespace std;
typedef tuple<int, int, int> tiii;

vector<tiii> v;
int dist[501];

void bellmanford(int n)
{
	for(int i = 1; i < n; i++)
		for(int j = 0; j < v.size(); j++)
		{
			int from = get<0>(v[j]);
			int to = get<1>(v[j]);
			int value = get<2>(v[j]);
			if(dist[from] + value < dist[to])
				dist[to] = dist[from] + value;
		}
	for(int j = 0; j < v.size(); j++)
	{
			int from = get<0>(v[j]);
			int to = get<1>(v[j]);
			int value = get<2>(v[j]);
			if(dist[from] + value < dist[to])
			{
				cout << "YES\n";
				return;
			}
	}
	cout << "NO\n";
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int tc;
	cin >> tc;
	for(int i = 0; i < tc; i++)
	{
		v.clear();
		int n, m, w, s, e, t;
		cin >> n >> m >> w;
		for(int i = 1; i <= n; i++)
			dist[i] = 987654321;
		for(int j = 0; j < m; j++)
		{
			cin >> s >> e >> t;
			v.push_back({s, e, t});
			v.push_back({e, s, t});
		}
		for(int j = 0; j < w; j++)
		{
			cin >> s >> e >> t;
			v.push_back({s, e, -t});
		}
		bellmanford(n);
	}
}