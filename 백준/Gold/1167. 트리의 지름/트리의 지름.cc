#include <iostream>
#include <vector>
#include <cstring>
using namespace std;
typedef pair<int, int> pii;

int v, ans = 0, point = 0;
bool visit[100001];
vector<pii> tree[100001];

void dfs(int start, int len)
{
	if(visit[start])
		return;
	visit[start] = true;
	if(len > ans)
	{
		ans = len;
		point = start;
	}
	for(int i = 0; i < tree[start].size(); i++)
		dfs(tree[start][i].first, len + tree[start][i].second);
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> v;
	for(int i = 1; i <= v; i++)
	{
		int parent;
		cin >> parent;
		while(1)
		{
			int child, value;
			cin >> child;
			if(child == -1)
				break;
			cin >> value;
			tree[parent].push_back({child, value});
		}
	}
	dfs(1, 0);
	memset(visit, 0, sizeof(visit));
	ans = 0;
	dfs(point, 0);
	cout << ans;
}