#include <iostream>
using namespace std;

int n, m, k;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int arr[301][301];
	cin >> n >> m;
	for(int y = 1; y <= n; y++)
		for(int x = 1; x <= m; x++)
			cin >> arr[y][x];
	cin >> k;
	for(int t = 0; t < k; t++)
	{
		int i, j, x, y;
		cin >> i >> j >> x >> y;
		int sum = 0;
		for(int c = j; c <= y; c++)
			for(int r = i; r <= x; r++)
				sum += arr[r][c];
		cout << sum << "\n";
	}
}