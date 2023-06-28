#include <iostream>
#include <algorithm>
using namespace std;

int n;
int board[1000001];

void input()
{
	cin >> n;
	for(int i = 0; i < n; i++)
	{
		cin >> board[i];
	}
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	input();
	sort(board, board + n);
	for(int i = 0; i < n; i++)
	{
		cout << board[i] << "\n";
	}
}