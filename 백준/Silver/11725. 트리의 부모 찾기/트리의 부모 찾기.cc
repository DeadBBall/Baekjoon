#include <iostream>
#include <queue>
using namespace std;

int n, parent[100001];
vector<int> tree[100001];
bool visit[100001];

void bfs()
{
	queue<int> q;
	q.push(1);
	while(!q.empty())
	{
		int now = q.front();
		q.pop();
		visit[now] = true;
		for(int i = 0; i != tree[now].size(); i++)
			if(!visit[tree[now][i]])
			{
				q.push(tree[now][i]);
				parent[tree[now][i]] = now;
			}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for(int i = 1; i < n; i++)
	{
		int input, input2;
		cin >> input >> input2;
		tree[input].push_back(input2);
		tree[input2].push_back(input);
	}
	bfs();
	for(int i = 2; i <= n; i++)
		cout << parent[i] << "\n";
}