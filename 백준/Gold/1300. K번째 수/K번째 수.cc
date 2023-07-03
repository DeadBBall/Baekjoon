#include <iostream>
#include <algorithm>
typedef long long ll;
using namespace std;

ll n, k, ans;

void input()
{
	cin >> n >> k;
}

ll countNum(ll num)
{
	ll sum = 0;
	for(int i = 1; i <= n; i++)
	{
		sum += min(num / i, (ll)n);
	}
	return sum;
}

void searchK()
{
	ll start = 1;
	ll end = n * n;
	while(start <= end)
	{
		ll mid = (start + end) / 2;
		ll idx = countNum(mid);
		if(idx < k)
		{
			start = mid + 1;
		}
		else
		{
			ans = mid;
			end = mid - 1;
		}
	}
}

int main()
{
	input();
	searchK();
	cout << ans;
}