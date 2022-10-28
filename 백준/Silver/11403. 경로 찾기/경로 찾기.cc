#include <iostream>
using namespace std;

int map[100][100];
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n;
	cin >> n;
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
			cin >> map[y][x];
	for(int k = 0; k < n; k++)
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				if(map[i][j] == 0 && map[i][k] + map[k][j] == 2)
					map[i][j] = 1;
	for(int y = 0; y < n; y++)
		{
			for(int x = 0; x < n; x++)
				cout << map[y][x] << " ";
			cout << "\n";
		}
}