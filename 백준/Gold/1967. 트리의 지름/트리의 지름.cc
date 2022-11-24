#include <iostream>
#include <vector>
#include <cstring>
using namespace std;
typedef pair<int, int> pii;

int n, ans = 0, point = 0;
vector<pii> tree[10001];
bool visit[10001];

void dfs(int start, int len)
{
	if(visit[start])
		return;
	visit[start] = true;
	if(ans < len)
	{
		ans = len;
		point = start;
	}
	for(int i = 0; i < (int)tree[start].size(); i++)
		dfs(tree[start][i].first, len + tree[start][i].second);
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for(int i = 1; i < n; i++)
	{
		int parent, child, value;
		cin >> parent >> child >> value;
		tree[parent].push_back({child, value});
		tree[child].push_back({parent, value});
	}
	dfs(1, 0);
	ans = 0;
	memset(visit, 0, sizeof(visit));
	dfs(point, 0);
	cout << ans;
}