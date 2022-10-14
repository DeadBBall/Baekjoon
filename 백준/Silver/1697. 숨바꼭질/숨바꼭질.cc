#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;
typedef pair<int, int> pii;

int n, m;
bool visit[100001] = {0};

int main()
{
	cin >> n >> m;
	queue<pii> q;
	q.push(make_pair(n, 0));
	visit[n] = true;
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		if(now.first == m)
		{
			cout << now.second;
			return (0);
		}
		if(now.first * 2 <= 100000)
			if(!visit[now.first * 2])
			{
				visit[now.first * 2] = true;
				q.push(make_pair(now.first * 2, now.second + 1));
			}
		if(now.first + 1 <= 100000)
			if(!visit[now.first + 1])
			{
				visit[now.first + 1] = true;
				q.push(make_pair(now.first + 1, now.second + 1));
			}
		if(now.first - 1 >= 0)
			if(!visit[now.first - 1])
			{
				visit[now.first - 1] = true;
				q.push(make_pair(now.first - 1, now.second + 1));
			}
	}
}