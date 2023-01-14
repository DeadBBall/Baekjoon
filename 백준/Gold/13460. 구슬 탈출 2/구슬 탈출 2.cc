#include <iostream>
#include <queue>
using namespace std;
typedef pair<int, int> pii;

int n, m, ans = 11;
char board[10][10];
pii red, blue, hole;

struct bead
{
	int redY;
	int redX;
	int blueY;
	int blueX;
	int cnt;
};

bool checkMove(bead now, int drct)
{
	if(drct == 0)
	{
		if(board[now.blueY][now.blueX - 1] != '#' || board[now.redY][now.redX - 1] != '#')
			return true;
		return false;
	}
	else if(drct == 1)
	{
		if(board[now.blueY][now.blueX + 1] != '#' || board[now.redY][now.redX + 1] != '#')
			return true;
		return false;
	}
	else if(drct == 2)
	{
		if(board[now.blueY - 1][now.blueX] != '#' || board[now.redY - 1][now.redX] != '#')
			return true;
		return false;
	}
	else
	{
		if(board[now.blueY + 1][now.blueX] != '#' || board[now.redY + 1][now.redX] != '#')
			return true;
		return false;
	}
}

int checkClear(bead now)
{
	if(now.blueY == hole.first && now.blueX == hole.second)
		return 0;
	else if(now.redY == hole.first && now.redX == hole.second)
		return 1;
	else
		return 2;
}

bead moveLeft(bead now)
{
	if(now.blueY == now.redY)
	{
		if(now.blueX > now.redX)
		{
			while(true)
			{
				if(board[now.redY][now.redX - 1] == 'O')
				{
					now.redX--;
					break;
				}
				else if(board[now.redY][now.redX - 1] == '#')
					break;
				else
					now.redX--;
			}
			while(true)
			{
				if(board[now.blueY][now.blueX - 1] == 'O')
				{
					now.blueX--;
					break;
				}
				else if(board[now.blueY][now.blueX - 1] == '#' || now.blueX - 1 == now.redX)
					break;
				else
					now.blueX--;
			}
		}
		else
		{
			while(true)
			{
				if(board[now.blueY][now.blueX - 1] == 'O')
				{
					now.blueX--;
					break;
				}
				else if(board[now.blueY][now.blueX - 1] == '#')
					break;
				else
					now.blueX--;
			}
			while(true)
			{
				if(board[now.redY][now.redX - 1] == 'O')
				{
					now.redX--;
					break;
				}
				else if(board[now.redY][now.redX - 1] == '#' || now.blueX == now.redX - 1)
					break;
				else
					now.redX--;
			}
		}
	}
	else
	{
		while(true)
		{
			if(board[now.blueY][now.blueX - 1] == 'O')
			{
				now.blueX--;
				break;
			}
			else if(board[now.blueY][now.blueX - 1] == '#')
				break;
			else
				now.blueX--;
		}
		while(true)
		{
			if(board[now.redY][now.redX - 1] == 'O')
			{
				now.redX--;
				break;
			}
			else if(board[now.redY][now.redX - 1] == '#')
				break;
			else
				now.redX--;
		}
	}
	now.cnt++;
	return now;
}

bead moveRight(bead now)
{
	if(now.blueY == now.redY)
	{
		if(now.blueX < now.redX)
		{
			while(true)
			{
				if(board[now.redY][now.redX + 1] == 'O')
				{
					now.redX++;
					break;
				}
				else if(board[now.redY][now.redX + 1] == '#')
					break;
				else
					now.redX++;
			}
			while(true)
			{
				if(board[now.blueY][now.blueX + 1] == 'O')
				{
					now.blueX++;
					break;
				}
				else if(board[now.blueY][now.blueX + 1] == '#' || now.blueX + 1 == now.redX)
					break;
				else
					now.blueX++;
			}
		}
		else
		{
			while(true)
			{
				if(board[now.blueY][now.blueX + 1] == 'O')
				{
					now.blueX++;
					break;
				}
				else if(board[now.blueY][now.blueX + 1] == '#')
					break;
				else
					now.blueX++;
			}
			while(true)
			{
				if(board[now.redY][now.redX + 1] == 'O')
				{
					now.redX++;
					break;
				}
				else if(board[now.redY][now.redX + 1] == '#' || now.blueX == now.redX + 1)
					break;
				else
					now.redX++;
			}
		}
	}
	else
	{
		while(true)
		{
			if(board[now.blueY][now.blueX + 1] == 'O')
			{
				now.blueX++;
				break;
			}
			else if(board[now.blueY][now.blueX + 1] == '#')
				break;
			else
				now.blueX++;
		}
		while(true)
		{
			if(board[now.redY][now.redX + 1] == 'O')
			{
				now.redX++;
				break;
			}
			else if(board[now.redY][now.redX + 1] == '#')
				break;
			else
				now.redX++;
		}
	}
	now.cnt++;
	return now;
}

bead moveUp(bead now)
{
	if(now.blueX == now.redX)
	{
		if(now.blueY > now.redY)
		{
			while(true)
			{
				if(board[now.redY - 1][now.redX] == 'O')
				{
					now.redY--;
					break;
				}
				else if(board[now.redY - 1][now.redX] == '#')
					break;
				else
					now.redY--;
			}
			while(true)
			{
				if(board[now.blueY - 1][now.blueX] == 'O')
				{
					now.blueY--;
					break;
				}
				else if(board[now.blueY - 1][now.blueX] == '#' || now.blueY - 1 == now.redY)
					break;
				else
					now.blueY--;
			}
		}
		else
		{
			while(true)
			{
				if(board[now.blueY - 1][now.blueX] == 'O')
				{
					now.blueY--;
					break;
				}
				else if(board[now.blueY - 1][now.blueX] == '#')
					break;
				else
					now.blueY--;
			}
			while(true)
			{
				if(board[now.redY - 1][now.redX] == 'O')
				{
					now.redY--;
					break;
				}
				else if(board[now.redY - 1][now.redX] == '#' || now.blueY == now.redY - 1)
					break;
				else
					now.redY--;
			}
		}
	}
	else
	{
		while(true)
		{
			if(board[now.blueY - 1][now.blueX] == 'O')
			{
				now.blueY--;
				break;
			}
			else if(board[now.blueY - 1][now.blueX] == '#')
				break;
			else
				now.blueY--;
		}
		while(true)
		{
			if(board[now.redY - 1][now.redX] == 'O')
			{
				now.redY--;
				break;
			}
			else if(board[now.redY - 1][now.redX] == '#')
				break;
			else
				now.redY--;
		}
	}
	now.cnt++;
	return now;
}

bead moveDown(bead now)
{
	if(now.blueX == now.redX)
	{
		if(now.blueY < now.redY)
		{
			while(true)
			{
				if(board[now.redY + 1][now.redX] == 'O')
				{
					now.redY++;
					break;
				}
				else if(board[now.redY + 1][now.redX] == '#')
					break;
				else
					now.redY++;
			}
			while(true)
			{
				if(board[now.blueY + 1][now.blueX] == 'O')
				{
					now.blueY++;
					break;
				}
				else if(board[now.blueY + 1][now.blueX] == '#' || now.blueY + 1 == now.redY)
					break;
				else
					now.blueY++;
			}
		}
		else
		{
			while(true)
			{
				if(board[now.blueY + 1][now.blueX] == 'O')
				{
					now.blueY++;
					break;
				}
				else if(board[now.blueY + 1][now.blueX] == '#')
					break;
				else
					now.blueY++;
			}
			while(true)
			{
				if(board[now.redY + 1][now.redX] == 'O')
				{
					now.redY++;
					break;
				}
				else if(board[now.redY + 1][now.redX] == '#' || now.blueY == now.redY + 1)
					break;
				else
					now.redY++;
			}
		}
	}
	else
	{
		while(true)
		{
			if(board[now.blueY + 1][now.blueX] == 'O')
			{
				now.blueY++;
				break;
			}
			else if(board[now.blueY + 1][now.blueX] == '#')
				break;
			else
				now.blueY++;
		}
		while(true)
		{
			if(board[now.redY + 1][now.redX] == 'O')
			{
				now.redY++;
				break;
			}
			else if(board[now.redY + 1][now.redX] == '#')
				break;
			else
				now.redY++;
		}
	}
	now.cnt++;
	return now;
}

void bfs()
{
	queue<bead> q;
	q.push({red.first, red.second, blue.first, blue.second, 0});
	while(!q.empty())
	{
		bead now = q.front();
		q.pop();
		int flag = checkClear(now);
		if(ans <= now.cnt || flag == 0)
			continue;
		else if(flag == 1)
			ans = now.cnt;
		else
		{
			if(checkMove(now, 0))
				q.push(moveLeft(now));
			if(checkMove(now, 1))
				q.push(moveRight(now));
			if(checkMove(now, 2))
				q.push(moveUp(now));
			if(checkMove(now, 3))
				q.push(moveDown(now));
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
		{
			cin >> board[y][x];
			if(board[y][x] == 'R')
			{
				red = {y, x};
				board[y][x] = '.';
			}
			else if(board[y][x] == 'B')
			{
				blue = {y, x};
				board[y][x] = '.';
			}
			else if(board[y][x] == 'O')
				hole = {y, x};
		}
	bfs();
	if(ans != 11)
		cout << ans;
	else
		cout << -1;
	return 0;
}