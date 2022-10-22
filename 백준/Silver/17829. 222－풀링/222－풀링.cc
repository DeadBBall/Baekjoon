#include <iostream>
#include <algorithm>
using namespace std;

int n;
int cnn[1024][1024];
int dy[] = {1, 0, 1};
int dx[] = {0, 1, 1};

void pooling(int y, int x)
{
	if(n == 1)
		return;
	for(y = 0; y < n; y += 2)
		for(x = 0; x < n; x += 2)
		{
			int rank_arr[4] = {0};
			for(int i = 0; i < 3; i++)
			{
				int ny = dy[i] + y;
				int nx = dx[i] + x;
				rank_arr[i] = cnn[ny][nx];
			}
			rank_arr[3] = cnn[y][x];
			sort(rank_arr, rank_arr + 4);
			cnn[y/2][x/2] = rank_arr[2];
		}
	n /= 2;
	pooling(0, 0);
}

int main()
{
	ios::sync_with_stdio(false);
  cin.tie(NULL);
	cin >> n;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
			cin >> cnn[y][x];
	pooling(0, 0);
	cout << cnn[0][0];
}