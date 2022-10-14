#include <iostream>

using namespace std;
int visit[1001] = {0}, line[1001][1001] = {0}, n, m;

void dfs(int a)
{
	visit[a] = 1;
	for(int i = 1; i <= n; i++)
		if(line[a][i] == 1 && visit[i] == 0)
			dfs(i);
}

int main()
{
	int ans = 0;
	cin >> n >> m;
	for(int i = 0; i < m; i++)
	{
		int a, b;
		cin >> a >> b;
		line[a][b] = 1;
		line[b][a] = 1;
	}
	for(int i = 1; i <= n; i++)
		if(visit[i] == 0)
		{
			dfs(i);
			ans++;
		}
	cout << ans;
}