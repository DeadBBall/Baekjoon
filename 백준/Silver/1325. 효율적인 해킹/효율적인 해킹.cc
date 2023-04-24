#include <iostream>
#include <vector>
#include <cstring>

using namespace std;

int n, m, sum, maxNum, ans[10001];
vector<int> v[10001];
bool visit[10001];

void dfs(int start)
{
	sum++;
	visit[start] = true;
	for (int i = 0; i < v[start].size(); i++)
	{
		int end = v[start][i];
		if (visit[end]) continue;
		visit[end] = true;
		dfs(end);
	}
}

int main()
{
	cin >> n >> m;
	for (int i = 0; i < m; i++)
	{
		int a, b;
		cin >> a >> b;
		v[b].push_back(a);
	}
	for (int i = 1; i <= n; i++)
	{
		sum = 0;
		memset(visit, false, sizeof(visit));
		dfs(i);
		ans[i] = sum;
		if (sum > maxNum)
		{
			maxNum = sum;
		}
	}
	for (int i = 1; i <= n; i++)
	{
		if (ans[i] == maxNum)
			cout << i << " ";
	}
}