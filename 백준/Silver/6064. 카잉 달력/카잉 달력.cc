#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int t;
	cin >> t;
	for(int i = 0; i < t; i++)
	{
		int m, n, x, y, ans = -1;
		cin >> m >> n >> x >> y;
		for(int j = 0; j < n; j++)
		{
			if((m * j + x) % n == y || (n == y && (m * j + x) % n == 0))
			{
				ans = m * j + x;
				break;
			}
		}
		cout << ans << "\n";
	}
}