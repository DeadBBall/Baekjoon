#include <iostream>
using namespace std;

int n, num, map[20][20], students[401][5], studentIdx[401], satisfaction;
int dy[] = {1, -1, 0, 0};
int dx[] = {0, 0, 1, -1};

void input()
{
	cin >> n;
	num = n * n;
	for(int i = 0; i < num; i++)
	{
		for(int j = 0; j < 5; j++)
		{
			cin >> students[i][j];
		}
		studentIdx[students[i][0]] = i;
	}
}

void searchMap(int idx)
{
	int student = students[idx][0];
	int likeMax = 0;
	int emptyMax = 0;
	int xIdx = -1;
	int yIdx = -1;
	int like[4];
	for(int i = 0; i < 4; i++)
	{
		like[i] = students[idx][i + 1];
	}

	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			if(map[y][x] != 0)
			{
				continue;
			}
			if(yIdx == -1 && xIdx == -1)
			{
				yIdx = y;
				xIdx = x;
			}
			int likeCnt = 0;
			int emptyCnt = 0;
			for(int i = 0; i < 4; i++)
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= n)
				{
					continue;
				}
				for(int j = 0; j < 4; j++)
				{
					if(map[ny][nx] == like[j])
					{
						likeCnt++;
						break;
					}
				}
				if(map[ny][nx] == 0)
				{
					emptyCnt++;
				}
			}
			if(likeCnt == 4)
			{
				map[y][x] = student;
				return;
			}
			else
			{
				if(likeCnt > likeMax)
				{
					likeMax = likeCnt;
					emptyMax = emptyCnt;
					yIdx = y;
					xIdx = x;
				}
				else if(likeCnt == likeMax)
				{
					if(emptyMax < emptyCnt)
					{
						emptyMax = emptyCnt;
						yIdx = y;
						xIdx = x;
					}
				}
			}
		}
	}
	map[yIdx][xIdx] = student;
}


void setSeat()
{
	for(int i = 0; i < num; i++)
	{
		searchMap(i);
	}
}

void checkSatisfaction()
{
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
		{
			int likeCnt = 0;
			int student = map[y][x];
			int like[4];

			for(int i = 0; i < 4; i++)
			{
				like[i] = students[studentIdx[student]][i + 1];
			}

			for(int i = 0; i < 4; i++)
			{
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || nx < 0 || ny >= n || nx >= n)
				{
					continue;
				}
				for(int j = 0; j < 4; j++)
				{
					if(map[ny][nx] == like[j])
					{
						likeCnt++;
						break;
					}
				}
			}
			if(likeCnt == 1)
			{
				satisfaction ++;
			}
			else if(likeCnt == 2)
			{
				satisfaction += 10;
			}
			else if(likeCnt == 3)
			{
				satisfaction += 100;
			}
			else if(likeCnt == 4)
			{
				satisfaction += 1000;
			}
		}
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	input();
	setSeat();
	// for(int y = 0; y < n; y++)
	// {
	// 	for(int x = 0; x < n; x++)
	// 	{
	// 		cout << map[y][x] << " ";
	// 	}
	// 	cout << "\n";
	// }
	checkSatisfaction();
	cout << satisfaction;
}
