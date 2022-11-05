#include <iostream>
#include <queue>
using namespace std;

int n, m, output[8] = {0};
bool visit[8][8] = {0};

void dfs(int num)
{
	if(num == m)
	{
		for(int i = 1; i <= m; i++)
			cout << output[i] << " ";
		cout << "\n";
		return;
	}
	for(int i = 1; i <= n; i++)
	{
		if(!visit[num + 1][i])
		{
			visit[num + 1][i] = true;
			output[num + 1] = i;
			dfs(num + 1);
			visit[num + 1][i] = false;
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	dfs(0);
}