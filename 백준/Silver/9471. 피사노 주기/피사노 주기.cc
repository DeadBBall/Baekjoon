#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int p;
	cin >> p;
	while(p--)
	{
		int n, m, ans = 0;
		cin >> n >> m;
		int a = 1, b = 1;
		while(1)
		{
			int tmp = (a + b) % m;
			a = b;
			b = tmp;
			ans++;
			if(a == 1 && b == 1)
				break;
		}
		cout << n << " " << ans << "\n";
	}
}