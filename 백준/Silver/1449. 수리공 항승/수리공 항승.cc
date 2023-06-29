#include <iostream>
#include <algorithm>
using namespace std;

int n, l, board[1001], ans;

void input()
{
	ans = 1;
	cin >> n >> l;
	for(int i = 0; i < n; i++)
	{
		cin >> board[i];
	}
	sort(board, board + n);
}

void countTape()
{
	int start = board[0];
	for(int i = 1; i < n; i++)
	{
		if(board[i] - start + 1> l)
		{
			ans++;
			start = board[i];
		}
	}
}

int main()
{
	input();
	countTape();
	cout << ans;
}