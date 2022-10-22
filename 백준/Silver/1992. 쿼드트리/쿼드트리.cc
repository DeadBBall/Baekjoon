#include <iostream>
#include <cstdio>
using namespace std;

int n, quadTree[64][64];

void solve(int inputY, int inputX, int size)
{
	int check = quadTree[inputY][inputX];
	for(int y = inputY; y < inputY + size; y++)
		for(int x = inputX; x < inputX + size; x++)
		{
			if(check != quadTree[y][x])
				check = -1;
			if(check == -1)
			{
				cout << "(";
				solve(inputY, inputX, size / 2);
				solve(inputY, inputX + size / 2, size / 2);
				solve(inputY + size / 2, inputX, size / 2);
				solve(inputY + size / 2, inputX + size / 2, size / 2);
				cout << ")";
				return;
			}
		}
	cout << to_string(check);
}

int main()
{
	// ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
			scanf("%1d", &quadTree[y][x]);
	solve(0, 0, n);
}