#include <iostream>
using namespace std;
#define INF 1600

int n, m, r, item[101], line[101][101];
int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m >> r;
	for(int y = 1; y <= n; y++)
		for(int x = 1; x <= n; x++)
			line[y][x] = INF;
	for(int i = 1; i <= n; i++)
	{
		cin >> item[i];
		line[i][i] = 0;
	}
	for(int i = 0; i < r; i++)
	{
		int a, b, l;
		cin >> a >> b >> l;
		line[a][b] = l;
		line[b][a] = l;
	}
	for(int j = 1; j <= n; j++)
	{
		for(int i = 1; i <= n; i++)
		{
			for(int k = 1; k <= n; k++)
			{
				line[i][k] = min(line[i][j] + line[j][k], line[i][k]);
			}
		}
	}
	int itemMax = 0;
	for(int i = 1; i <= n; i++)
	{
		int itemTmp = 0;
		for(int j = 1; j <= n; j++)
		{
			if(line[i][j] <= m)
				itemTmp += item[j];
		}
		itemMax = max(itemTmp, itemMax);
	}
	cout << itemMax;
}