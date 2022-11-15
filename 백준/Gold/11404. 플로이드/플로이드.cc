#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m, bus[101][101] = {0};
	cin >> n >> m;
	for(int i = 0; i < m; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;
		if(bus[a][b] != 0)
			bus[a][b] = min(bus[a][b], c);
		else
			bus[a][b] = c;
	}
	for(int k = 1; k <= n; k++)
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
			{
				if(i == j)
					continue;
				if(bus[i][k] != 0 && bus[k][j] != 0)
				{
					if(bus[i][j] == 0)
						bus[i][j] = bus[i][k] + bus[k][j];
					else if(bus[i][j] != 0)
						bus[i][j] = min(bus[i][j], bus[i][k] + bus[k][j]);
				}
			}
	for(int i = 1; i <= n; i++)
	{
		for(int j = 1; j <= n; j++)
			cout << bus[i][j] << " ";
		cout << "\n";
	}
}