#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int in_degree[32001];

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	cin >> n >> m;
	vector<int> v[32001];
	queue<int> tmp;
	vector<int> ans;
	for(int i = 0; i < m; i++)
	{
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		in_degree[b]++;
	}
	for(int i = 1; i <= n; i++)
	{
		if(in_degree[i] == 0)
		{
			tmp.push(i);
			in_degree[i] = -1;
		}
	}
	while(!tmp.empty())
	{
		int now = tmp.front();
		tmp.pop();
		for(int i = 0; i < v[now].size(); i++)
			in_degree[v[now][i]]--;
		ans.push_back(now);
		for(int i = 1; i <= n; i++)
		{
			if(in_degree[i] == 0)
			{
				tmp.push(i);
				in_degree[i] = -1;
			}
		}
	}
	for(int i = 0; i < ans.size(); i++)
		cout << ans[i] << " ";
}