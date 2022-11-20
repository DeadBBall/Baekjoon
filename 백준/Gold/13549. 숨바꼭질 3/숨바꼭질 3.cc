#include <iostream>
#include <queue>
using namespace std;
typedef pair<int, int> pii;

int n, k;
bool visit[100001];

void bfs()
{
	queue<pii> q;
	q.push({n, 0});
	visit[n] = true;
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		if(now.first == k)
		{
			cout << now.second;
			return;
		}
		if(now.first * 2 <= 100000 && !visit[now.first * 2])
		{
			q.push({now.first * 2, now.second});
			visit[now.first * 2] = true;
		}
		if(now.first - 1 >= 0 && !visit[now.first - 1])
		{
			q.push({now.first - 1, now.second + 1});
			visit[now.first - 1] = true;
		}
		if(now.first + 1 <= 100000 && !visit[now.first + 1])
		{
			q.push({now.first + 1, now.second + 1});
			visit[now.first + 1] = true;
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> k;
	bfs();
}