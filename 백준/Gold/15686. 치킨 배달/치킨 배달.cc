#include <iostream>
#include <vector>
#include <cstdlib>
using namespace std;
typedef pair<int, int> pii;
#define MAX 9999999

int n, m, map[50][50], ans = MAX;
bool selc[13];
vector<pii> house, chicken, v;

void calcDist(int idx, int cnt)
{
	if(cnt == m)
	{
		int sum = 0;
		for(auto it = house.begin(); it != house.end(); it++)
		{
			int tmp = MAX;
			for(auto ite = v.begin(); ite != v.end(); ite++)
				tmp = min(abs((*ite).first - (*it).first) + abs((*ite).second - (*it).second), tmp);
			sum += tmp;
		}
		ans = min(ans, sum);
		return;
	}
	for(int i = idx; i < (int)chicken.size(); i++)
	{
		if(selc[i])
			continue;
		selc[i] = true;
		v.push_back(chicken[i]);
		calcDist(i, cnt + 1);
		selc[i] = false;
		v.pop_back();
	}
}

void initMap()
{
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
		{
			cin >> map[y][x];
			if(map[y][x] == 1)
				house.push_back({y, x});
			else if(map[y][x] == 2)
				chicken.push_back({y, x});
		}
}

void solve()
{
	initMap();
	calcDist(0, 0);
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	solve();
	cout << ans;
}