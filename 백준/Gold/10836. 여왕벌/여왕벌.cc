#include <iostream>
using namespace std;

int growth[700][700], m, n, arr[1400] = {0};

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> m >> n;
	for(int y = 0; y < m; y++)
		for(int x = 0; x < m; x++)
			growth[y][x] = 0;
	for(int j = 0; j < n; j++)
	{
		int num[3];
		for(int i = 0; i < 3; i++)
			cin >> num[i];
		for(int i = num[0]; i < m * 2 - 1; i++)
		{
			if(num[1] != 0)
			{
				arr[i] += 1;
				num[1]--;
			}
			else
			{
				arr[i] += 2;
				num[2]--;
			}
		}
	}
	int pos = m - 1;
	for(int i = 0; i < m * 2 - 1; i++)
	{
		if(i < m)
			growth[pos--][0]= arr[i];
		else
			growth[0][pos++ + 2] = arr[i];
	}
	for(int y = 1; y < m; y++)
		for(int x = 1; x < m; x++)
		{
			int tmp = growth[y - 1][x] > growth[y - 1][x - 1] ? growth[y - 1][x] : growth[y - 1][x - 1];
			tmp = growth[y][x - 1] > tmp ? growth[y][x - 1] : tmp;
			growth[y][x] = tmp;
		}
	for(int y = 0; y < m; y++)
	{
		for(int x = 0; x < m; x++)
			cout << growth[y][x] + 1 << " ";
		cout << "\n";
	}
}