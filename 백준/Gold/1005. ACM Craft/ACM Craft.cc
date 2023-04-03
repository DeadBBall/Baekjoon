#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>
using namespace std;

int t, n, k, time[1001], dp[1001], in[1001], w;


void playGame()
{
	cin >> n >> k;
	vector<int> v[1001];
	for(int i = 1; i <= n; i++)
	{
		cin >> time[i];
		in[i] = 0;
		dp[i] = -1;
	}
	for(int i = 0; i < k; i++)
	{
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		in[b]++;
	}
	cin >> w;
	queue<int> q;
	for(int i = 1; i <= n; i++)
	{
		if(in[i] == 0)
		{
			dp[i] = time[i];
			q.push(i);
		}
	}
	while(!q.empty())
	{
		int start = q.front();
		q.pop();
		for(int i = 0; i < v[start].size(); i++)
		{
			int end = v[start][i];
			in[end]--;
			dp[end] = max(dp[end], dp[start] + time[end]);
			if(in[end] == 0)
			{
				q.push(end);
			}
		}
	}
	cout << dp[w] << "\n";
}

int main()
{
	cin >> t;
	for(int tc = 0; tc < t; tc++)
	{
		playGame();
	}
}