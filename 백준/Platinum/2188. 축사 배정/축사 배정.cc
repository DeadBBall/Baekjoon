#include <iostream>
#include <vector>
using namespace std;

int n, m, ans;
vector<int> v[1001];
int line[1001];
bool visit[1001];

bool dfs(int num)
{
	for(int i = 0; i < v[num].size(); i++)
	{
		int now = v[num][i];
		if(visit[now])
		{
			continue;
		}
		visit[now] = true;
		if(line[now] == 0 || dfs(line[now]))
		{
			line[now] = num;
			return true;
		}
	}
	return false;
}

void input()
{
	cin >> n >> m;
	for(int i = 1; i <= n; i++)
	{
		int a, b;
		cin >> a;
		for(int j = 0; j < a; j++)
		{
			cin >> b;
			v[i].push_back(b);
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	for(int i = 1; i <= n; i++)
	{
		fill(visit, visit + m + 1, false);
		if(dfs(i))
		{
			ans++;
		}
	}
	cout << ans;
}
