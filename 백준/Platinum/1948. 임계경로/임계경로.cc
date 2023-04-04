#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;
typedef pair<int, int> pii;

int n, m, dp[10001], in[10001], st, ed, cnt;
bool visit[10001][10001];
vector<pii> info[10001];
vector<pii> rev[10001];

void checkRoad(int end)
{
	for(int i = 0; i < rev[end].size(); i++)
	{
		pii now = rev[end][i];
		if(!visit[end][now.first] && dp[end] == dp[now.first] + now.second)
		{
			visit[end][now.first] = true;
			cnt++;
			// cout << end << " " << now.first << "\n";
			checkRoad(now.first);
		}
	}
}

int main()
{
	cin >> n >> m;
	for(int i = 0; i < m; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		info[a].push_back({b, c});
		in[b]++;
		rev[b].push_back({a, c});
	}
	cin >> st >> ed;
	queue<int> q;
	for(int i = 1; i <= n; i++)
	{
		if(in[i] == 0)
		{
			q.push(i);
		}
	}
	while(!q.empty())
	{
		int start = q.front();
		q.pop();
		for(int i = 0; i < info[start].size(); i++)
		{
			pii now = info[start][i];
			if(dp[now.first] < dp[start] + now.second)
			{
				dp[now.first] = dp[start] + now.second;
			}
			in[now.first]--;
			if(in[now.first] == 0)
			{
				q.push(now.first);
			}
		}
	}
	checkRoad(ed);
	cout << dp[ed] << "\n" << cnt;
}
