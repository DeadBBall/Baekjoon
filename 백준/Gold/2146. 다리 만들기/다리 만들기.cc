#include <iostream>
#include <queue>
#include <set>
#include <algorithm>
using namespace std;
typedef pair<int, int> pii;

const int dy[] = {1, -1, 0, 0};
const int dx[] = {0, 0, 1, -1};
int n, cnt, ans;
int board[101][101];
set<pii> edge;

void input()
{
	cnt = 1;
	ans = 987654321;
	cin >> n;
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			cin >> board[y][x];
		}
	}
}

void bfs(int yStart, int xStart)
{
	board[yStart][xStart] = cnt;
	queue<pii> q;
	q.push({yStart, xStart});
	while(!q.empty())
	{
		pii now = q.front();
		q.pop();
		for(int i = 0; i < 4; i++)
		{
			int ny = now.first + dy[i];
			int nx = now.second + dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= n)
			{
				continue;
			}
			if(board[ny][nx] == 0)
			{
				edge.insert({now.first, now.second});
			}
			if(board[ny][nx] != 1)
			{
				continue;
			}
			board[ny][nx] = cnt;
			q.push({ny, nx});
		}
	}
}

void makeBridge()
{
	bool visit[101][101];
	for(auto it = edge.begin(); it != edge.end(); it++)
	{
		for(int y = 0; y < n; y++)
		{
			for(int x = 0; x < n; x++)
			{
				visit[y][x] = false;
			}
		}
		queue<pii> q;
		q.push({it->first * 1000 + it->second, 0});
		int idx = board[it->first][it->second];
		while(!q.empty())
		{
			pii now = q.front();
			q.pop();
			int y = now.first / 1000;
			int x = now.first % 1000;
			for(int i = 0; i < 4; i++)
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == idx || visit[ny][nx])
				{
					continue;
				}
				visit[ny][nx] = true;
				if(board[ny][nx] != 0)
				{
					ans = min(ans, now.second);
					break;
				}
				q.push({ny * 1000 + nx, now.second + 1});
			}
		}
	}
}

int main()
{
	input();
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			if(board[y][x] == 1)
			{
				cnt++;
				bfs(y, x);
			}
		}
	}
	makeBridge();
	cout << ans;
}