#include <iostream>
using namespace std;

int check_num(int n)
{
	for(long long i = 0; i <= n; i++)
	{
		if(i * (i + 1) < n && n <= (i + 1) * (i + 2))
		{
			if(n <= (i + 1) * (i + 1))
				return (i + 1) * 2 - 1;
			else
				return (i + 1) * 2;
		}
	}
	return 0;
}

int main()
{
	ios::sync_with_stdio(false);
  cin.tie(NULL);
	int t;
	cin >> t;
	for(int i = 0; i < t; i++)
	{
		int x, y;
		cin >> x >> y;
		y -= x;
		cout << check_num(y) << "\n";
	}
}