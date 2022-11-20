#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int k, n, m, ans = 0;
	cin >> k >> n >> m;
	if(k * n - m > 0)
		ans = k * n - m;
	cout << ans;
}