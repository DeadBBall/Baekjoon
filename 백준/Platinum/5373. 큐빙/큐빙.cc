#include <iostream>
#include <string>
using namespace std;

int tc;
int n;
string inputStr[1000];
char map[6][10];
char tmp[4];

void input()
{
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		cin >> inputStr[i];
	}
	for(int i = 0; i < 9; i++)
	{
		map[0][i] = 'w';
		map[1][i] = 'y';
		map[2][i] = 'r';
		map[3][i] = 'o';
		map[4][i] = 'g';
		map[5][i] = 'b';
	}
}

void spin(int i)
{
	tmp[0] = map[i][0];
	tmp[1] = map[i][1];
	tmp[2] = map[i][2];
	map[i][2] = tmp[0];
	map[i][1] = map[i][3];
	map[i][0] = map[i][6];
	map[i][3] = map[i][7];
	map[i][6] = map[i][8];
	map[i][7] = map[i][5];
	map[i][8] = tmp[2];
	map[i][5] = tmp[1];
}

void moveU(char drct)
{
	int cnt = 1;
	if(drct == '-')
	{
		cnt = 3;
	}
	for(int i = 0; i < cnt; i++)
	{
		spin(0);
		tmp[0] = map[3][0];
		tmp[1] = map[3][1];
		tmp[2] = map[3][2];
		map[3][2] = map[4][2];
		map[3][1] = map[4][1];
		map[3][0] = map[4][0];
		map[4][2] = map[2][2];
		map[4][1] = map[2][1];
		map[4][0] = map[2][0];
		map[2][2] = map[5][2];
		map[2][1] = map[5][1];
		map[2][0] = map[5][0];
		map[5][0] = tmp[0];
		map[5][1] = tmp[1];
		map[5][2] = tmp[2];
	}
}

void moveD(char drct)
{
	int cnt = 1;
	spin(1);
	spin(1);
	if(drct == '+')
	{
		cnt = 3;
	}
	for(int i = 0; i < cnt; i++)
	{
		spin(1);
		tmp[0] = map[3][8];
		tmp[1] = map[3][7];
		tmp[2] = map[3][6];
		map[3][8] = map[4][8];
		map[3][7] = map[4][7];
		map[3][6] = map[4][6];
		map[4][8] = map[2][8];
		map[4][7] = map[2][7];
		map[4][6] = map[2][6];
		map[2][8] = map[5][8];
		map[2][7] = map[5][7];
		map[2][6] = map[5][6];
		map[5][6] = tmp[2];
		map[5][7] = tmp[1];
		map[5][8] = tmp[0];
	}
}

void moveF(char drct)
{
	int cnt = 1;
	if(drct == '-') {
		cnt = 3;
	}
	for(int i = 0; i < cnt; i++)
	{
		spin(2);
		tmp[0] = map[1][0];
		tmp[1] = map[1][1];
		tmp[2] = map[1][2];
		map[1][0] = map[5][6];
		map[1][1] = map[5][3];
		map[1][2] = map[5][0];
		map[5][6] = map[0][8];
		map[5][3] = map[0][7];
		map[5][0] = map[0][6];
		map[0][8] = map[4][2];
		map[0][7] = map[4][5];
		map[0][6] = map[4][8];
		map[4][2] = tmp[0];
		map[4][5] = tmp[1];
		map[4][8] = tmp[2];
	}
}

void moveB(char drct)
{
	int cnt = 1;
	spin(3);
	spin(3);
	if(drct == '+') {
		cnt = 3;
	}
	for(int i = 0; i < cnt; i++)
	{
		spin(3);
		tmp[0] = map[0][0];
		tmp[1] = map[0][1];
		tmp[2] = map[0][2];
		map[0][0] = map[4][6];
		map[0][1] = map[4][3];
		map[0][2] = map[4][0];
		map[4][0] = map[1][6];
		map[4][3] = map[1][7];
		map[4][6] = map[1][8];
		map[1][6] = map[5][8];
		map[1][7] = map[5][5];
		map[1][8] = map[5][2];
		map[5][2] = tmp[0];
		map[5][5] = tmp[1];
		map[5][8] = tmp[2];
	}
}

void moveL(char drct)
{
	int cnt = 1;
	if(drct == '-') {
		cnt = 3;
	}
	for(int i = 0; i < cnt; i++)
	{
		spin(4);
		tmp[0] = map[0][0];
		tmp[1] = map[0][3];
		tmp[2] = map[0][6];

		map[0][0] = map[3][8];
		map[0][3] = map[3][5];
		map[0][6] = map[3][2];

		map[3][8] = map[1][0];
		map[3][5] = map[1][3];
		map[3][2] = map[1][6];

		map[1][0] = map[2][0];
		map[1][3] = map[2][3];
		map[1][6] = map[2][6];

		map[2][6] = tmp[2];
		map[2][3] = tmp[1];
		map[2][0] = tmp[0];
	}
}

void moveR(char drct)
{
	int cnt = 1;
	if(drct == '-') {
		cnt = 3;
	}
	for(int i = 0; i < cnt; i++)
	{
		spin(5);
		tmp[0] = map[0][2];
		tmp[1] = map[0][5];
		tmp[2] = map[0][8];
		map[0][2] = map[2][2];
		map[0][5] = map[2][5];
		map[0][8] = map[2][8];
		map[2][2] = map[1][2];
		map[2][5] = map[1][5];
		map[2][8] = map[1][8];
		map[1][2] = map[3][6];
		map[1][5] = map[3][3];
		map[1][8] = map[3][0];
		map[3][6] = tmp[0];
		map[3][3] = tmp[1];
		map[3][0] = tmp[2];
	}
}

void moveCube()
{
	for(int i = 0; i < n; i++)
	{
		if(inputStr[i][0] == 'U')
		{
			moveU(inputStr[i][1]);
		}
		else if(inputStr[i][0] == 'D')
		{
			moveD(inputStr[i][1]);
		}
		else if(inputStr[i][0] == 'F')
		{
			moveF(inputStr[i][1]);
		}
		else if(inputStr[i][0] == 'B')
		{
			moveB(inputStr[i][1]);
		}
		else if(inputStr[i][0] == 'L')
		{
			moveL(inputStr[i][1]);
		}
		else
		{
			moveR(inputStr[i][1]);
		}
	}
}

void solve()
{
	cin >> tc;
	for(int i = 1; i <= tc; i++)
	{
		input();
		moveCube();
		for(int j = 0; j < 9; j++)
		{
			cout << map[0][j];
			if((j + 1) % 3 == 0)
			{
				cout << "\n";
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	solve();
}