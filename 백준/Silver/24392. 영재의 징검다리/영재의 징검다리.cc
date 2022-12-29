#include <iostream>
#include <queue>
using namespace std;
#define INF 1000000007

unsigned int ans[1001][1001] = {0};
int m, n, obj = 0;
bool map[1001][1001];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for(int y = 1; y <= n; y++)
		for(int x = 1; x <= m; x++)
		{
			cin >> map[y][x];
			if(y == 1)
				ans[y][x] = map[y][x];
		}
	for(int y = 2; y <= n; y++)
		for(int x = 1; x <= m; x++)
			if(map[y][x] == 1)
				{
					if(x == 1)
						ans[y][x] = (ans[y - 1][x] + ans[y - 1][x + 1]) % INF;
					else if(x == m)
						ans[y][x] = (ans[y - 1][x - 1] + ans[y - 1][x]) % INF;
					else
						ans[y][x] = (ans[y - 1][x - 1] + ans[y - 1][x] + ans[y - 1][x + 1]) % INF;
				}
	for(int x = 1; x <= m; x++)
		obj = (obj + ans[n][x]) % INF;
	cout << obj;
}