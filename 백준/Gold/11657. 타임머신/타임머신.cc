#include <iostream>
#include <tuple>
#include <vector>
using namespace std;
#define INF 987654321
typedef tuple<int, int, int> tiii;

long long dist[501];
vector<tiii> v;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	cin >> n >> m;
	for(int i = 1; i <= n; i++)
		dist[i] = INF;
	while(m--)
	{
		int a, b, c;
		cin >> a >> b >> c;
		v.push_back({a, b, c});
	}
	dist[1] = 0;
	for(int i = 1; i < n; i++)
	{
		for(int j = 0; j < (int)v.size(); j++)
		{
			int from = get<0>(v[j]);
			int to = get<1>(v[j]);
			int value = get<2>(v[j]);
			if(dist[from] == INF)
				continue;
			else if(dist[from] + value < dist[to])
				dist[to] = dist[from] + value;
		}
	}
	for(int j = 0; j < (int)v.size(); j++)
	{
		int from = get<0>(v[j]);
		int to = get<1>(v[j]);
		int value = get<2>(v[j]);
		if(dist[from] == INF)
			continue;
		if(dist[from] + value < dist[to])
		{
			cout << -1;
			return 0;
		}
	}
	for(int i = 2; i <= n; i++)
	{
		if(dist[i] != INF)
			cout << dist[i] << "\n";
		else
			cout << "-1\n";
	}
}