#include <iostream>
using namespace std;

int n;
bool star[3072][6143];

void makeStar(int y, int x)
{
	star[y][x] = 1;
	star[y + 1][x - 1] = 1;
	star[y + 1][x + 1] = 1;
	for(int i = 0; i < 5; i++)
		star[y + 2][x - 2 + i] = 1;
}

void makeTriangle(int len, int y, int x)
{
	if (len == 3)
	{
		makeStar(y, x);
		return;
	}
	makeTriangle(len / 2, y, x);
	makeTriangle(len / 2, y + len / 2, x - len / 2);
	makeTriangle(len / 2, y + len / 2, x + len / 2);
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	makeTriangle(n, 0, n - 1);
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < 2 * n - 1; x++)
		{
			if(star[y][x] == 1)
				cout << "*";
			else
				cout << " ";
		}
		cout << "\n";
	}
}