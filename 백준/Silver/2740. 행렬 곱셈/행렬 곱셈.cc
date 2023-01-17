#include <iostream>
using namespace std;

int n, m, k, matrix1[100][100], matrix2[100][100], ans[100][100];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < m; x++)
			cin >> matrix1[y][x];
	cin >> m >> k;
	for(int y = 0; y < m; y++)
		for(int x = 0; x < k; x++)
			cin >> matrix2[y][x];
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < k; j++)
		{
			for (int l = 0; l < m; l++)
				ans[i][j] += matrix1[i][l] * matrix2[l][j];
			cout << ans[i][j] << " ";
		}
		cout << "\n";
	}
}