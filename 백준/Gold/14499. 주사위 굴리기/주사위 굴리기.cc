#include <iostream>
using namespace std;

int n, m, x, y, k, orders[1000], map[20][20], dice[6];
int tmp;

void moveU()
{
	y--;
	tmp = dice[3];
	dice[3] = dice[1];
	dice[1] = dice[2];
	dice[2] = dice[0];
	dice[0] = tmp;
	if(map[y][x] == 0)
	{
		map[y][x] = dice[0];
	}
	else
	{
		dice[0] = map[y][x];
		map[y][x] = 0;
	}
}

void moveD()
{
	y++;
	tmp = dice[3];
	dice[3] = dice[0];
	dice[0] = dice[2];
	dice[2] = dice[1];
	dice[1] = tmp;
	if(map[y][x] == 0)
	{
		map[y][x] = dice[0];
	}
	else
	{
		dice[0] = map[y][x];
		map[y][x] = 0;
	}
}

void moveL()
{
	x--;
	tmp = dice[0];
	dice[0] = dice[4];
	dice[4] = dice[1];
	dice[1] = dice[5];
	dice[5] = tmp;
	if(map[y][x] == 0)
	{
		map[y][x] = dice[0];
	}
	else
	{
		dice[0] = map[y][x];
		map[y][x] = 0;
	}
}

void moveR()
{
	x++;
	tmp = dice[0];
	dice[0] = dice[5];
	dice[5] = dice[1];
	dice[1] = dice[4];
	dice[4] = tmp;
	if(map[y][x] == 0)
	{
		map[y][x] = dice[0];
	}
	else
	{
		dice[0] = map[y][x];
		map[y][x] = 0;
	}
}

void input()
{
	cin >> n >> m >> y >> x >> k;
	for(int i = 0; i < n; i++)
	{
		for(int j = 0; j < m; j++)
		{
			cin >> map[i][j];
		}
	}
	for(int i = 0; i < k; i++)
	{
		cin >> orders[i];
	}
}

void rollDice()
{
	for(int i = 0; i < k; i++)
	{
		if(orders[i] == 1 && x < m - 1)
		{
			moveR();
			cout << dice[1] << "\n";
		}
		else if(orders[i] == 2 && x > 0)
		{
			moveL();
			cout << dice[1] << "\n";
		}
		else if(orders[i] == 3 && y > 0)
		{
			moveU();
			cout << dice[1] << "\n";
		}
		else if(orders[i] == 4 && y < n - 1)
		{
			moveD();
			cout << dice[1] << "\n";
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	rollDice();
}