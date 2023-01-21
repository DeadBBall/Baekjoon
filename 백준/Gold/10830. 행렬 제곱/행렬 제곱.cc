#include <iostream>
using namespace std;
typedef long long ll;

int n;
ll b, ans[5][5];

void makeMatrix(ll a1[5][5], ll a2[5][5])
{
	ll now[5][5] = {0};
	for(int d = 0; d < n; d++)
	{
		for(int e = 0; e < n; e++)
		{
			for(int f = 0; f < n; f++)
				now[d][e] += a1[d][f] * a2[f][e];
		}
	}
	for(int y = 0; y < n; y++)
		for(int x = 0; x < n; x++)
			a1[y][x] = now[y][x] % 1000;
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> b;
	ll arr[5][5];
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
			cin >> arr[y][x];
		ans[y][y] = 1;
	}
	while(b > 0)
	{
		if(b % 2 == 1)
		{
			makeMatrix(ans, arr);
		}
			makeMatrix(arr, arr);
		b /= 2;
	}
	for(int y = 0; y < n; y++)
	{
		for(int x = 0; x < n; x++)
			cout << ans[y][x] << " ";
		cout << "\n";
	}
}