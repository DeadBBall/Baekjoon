#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool visit[100001];
int ans[100001], turn = 1;
int n, m, r;
vector<int> line[100001];

void dfs(int num)
{
	visit[num] = 1;
	ans[num] = turn++;
	for(int i = 0; i < line[num].size(); i++)
	{
		if(visit[line[num][i]] == 0)
			dfs(line[num][i]);
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m >> r;
	for(int i = 0; i < m; i++)
	{
		int line1, line2;
		cin >> line1 >> line2;
		line[line1].push_back(line2);
		line[line2].push_back(line1);
	}
	for(int i = 1; i <= n; i++)
		sort(line[i].begin(), line[i].end());
	dfs(r);
	for(int i = 1; i <= n; i++)
		cout << ans[i] << "\n";
}