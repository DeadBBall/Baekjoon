#include <iostream>
#include <cstdlib>
using namespace std;

int n, ans = 0, board[15] = {0};

bool canQueen(int y, int x)
{
	for(int i = 1; i < x; i++)
		if(board[i] == y)
			return false;
	for(int i = 1; i < x; i++)
		if(abs(y - board[i]) == abs(x - i))
			return false;
	return true;
}

void nQueen(int x)
{
	if(x > n)
	{
		ans++;
		return;
	}
	for(int y = 1; y <= n; y++)
	{
		if(!canQueen(y, x))
			continue;
		board[x] = y;
		nQueen(x + 1);
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	nQueen(1);
	cout << ans;
}