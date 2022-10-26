#include <iostream>
using namespace std;

int n, m;
int line[100][100];

int main()
{
	cin >> n >> m;
	for(int i = 0; i < m; i++)
	{
		int a, b;
		cin >> a >> b;
		line[a - 1][b - 1] = 1;
		line[b - 1][a - 1] = 1;
	}
	for(int k = 0; k < n; k++)
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
			{
				if(i == j)
					continue;
				else if(line[i][k] != 0 && line[k][j] != 0)
				{
					if(line[i][j] == 0)
						line[i][j] = line[i][k] + line[k][j];
					else
						line[i][j] = min(line[i][j], line[i][k] + line[k][j]);
				}
			}
	int ans[2] = {10000};
	for(int i = 0; i < n; i++)
	{
		int sum = 0;
			for(int j = 0; j < n; j++)
				if(i != j)
					sum += line[i][j];
		if(sum < ans[0])
		{
			ans[0] = sum;
			ans[1] = i + 1;
		}
	}
	cout << ans[1];
}