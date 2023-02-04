#include <iostream>
#include <queue>
#include <deque>
using namespace std;
typedef pair<int, char> pic;
typedef pair<int, int> pii;

int n, k, l, map[101][101], sec = 0, drct = 0, headX = 1, headY = 1, tailX = 1, tailY = 1;
int dy[] = {0, 1, 0, -1};
int dx[] = {1, 0, -1, 0};
queue<pic> q;
deque<pii> snake;

void playDummy()
{
	while(true)
	{
		sec++;
		pic now = q.front();
		pii tail = snake.back();
		pii head = snake.front();
		int ny = head.first + dy[drct];
		int nx = head.second + dx[drct];
		if(nx < 1 || ny < 1 || nx > n || ny > n)
			return;
		else if(map[ny][nx] == 1)
			return;
		if(map[ny][nx] != -1)
		{
			map[tail.first][tail.second] = 0;
			snake.pop_back();
		}
		map[ny][nx] = 1;
		snake.push_front({ny, nx});
		if(now.first == sec)
		{
			q.pop();
			if(now.second == 'D')
			{
				drct++;
				if(drct == 4)
					drct = 0;
			}
			else
			{
				drct--;
				if(drct == -1)
					drct = 3;
			}
		}
	}
}

void inputProb()
{
	map[1][1] = 1;
	snake.push_back({1, 1});
	cin >> n >> k;
	for(int i = 0; i < k; i++)
	{
		int a, b;
		cin >> a >> b;
		map[a][b] = -1;
	}
	cin >> l;
	for(int i = 0; i < l; i++)
	{
		int x;
		char c;
		cin >> x >> c;
		q.push({x, c});
	}
}

void solve()
{
	inputProb();
	playDummy();
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin.tie(NULL);
	solve();
	cout << sec;
}