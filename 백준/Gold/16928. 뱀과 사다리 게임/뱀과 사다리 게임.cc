#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;
typedef pair<int, int> pii;

bool visit[101];
pii ladder[15], snake[15];
int dice = 0;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	cin >> n >> m;
	for(int i = 0; i < n; i++)
	{
		int start, end;
		cin >> start >> end;
		ladder[i] = {start, end};
	}
	sort(ladder, ladder + n);
	for(int i = 0; i < m; i++)
	{
		int start, end;
		cin >> start >> end;
		snake[i] = {start, end};
	}
	sort(snake, snake + m);
	queue<pii> q;
	q.push({1, 0});
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		visit[now.first] = 1;
		if(now.first == 100)
		{
			cout << now.second;
			return 0;
		}
		for(int i = 0; i < n; i++)
		{
			if(now.first == ladder[i].first)
				now.first = ladder[i].second;
			else if(now.first < ladder[i].first)
				break;
		}
			for(int i = 0; i < m; i++)
		{
			if(now.first == snake[i].first)
				now.first = snake[i].second;
			else if(now.first < snake[i].first)
				break;
		}
		visit[now.first] = 1;
		for(int i = 1; i < 7; i++)
		{
			if(!visit[now.first + i])
				q.push({now.first + i, now.second + 1});
		}
	}
}