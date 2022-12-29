#include <iostream>
#include <queue>
using namespace std;
typedef pair<int, int> pii;

bool visit[100001];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, k, time = 100001, num = 0;
	cin >> n >> k;
	queue<pii> q;
	q.push({n, 0});
	while(!q.empty())
	{
		pii now = q.front();
		visit[now.first] = 1;
		if(now.first == k)
		{
			if(now.second < time)
			{
				time = now.second;
				num = 1;
			}
			else if(now.second == time)
				num++;
		}
		q.pop();
		if(now.second >= time)
			continue;
		if(now.first - 1 >= 0 && !visit[now.first - 1])
			q.push({now.first - 1, now.second + 1});
		if(now.first + 1 < 100001 && !visit[now.first + 1])
			q.push({now.first + 1, now.second + 1});
		if(now.first * 2 < 100001 && !visit[now.first * 2])
			q.push({now.first * 2, now.second + 1});
	}
	cout << time << "\n" << num;
}