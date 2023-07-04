#include <iostream>
#include <algorithm>
typedef long long ll;
using namespace std;

int n, m, rides[10001], ans;
ll maxTime;

void input()
{
		cin >> n >> m;
		for(int i = 0; i < m; i++)
		{
				cin >> rides[i];
				maxTime = max(maxTime, (ll)rides[i]);
		}
}

ll countCnt(ll sec)
{
		ll cnt = m;
		for(int i = 0; i < m; i++)
		{
				cnt += sec / rides[i];
		}
		return cnt;
}

void searchRide()
{
		ll time = 0;
		if(n <= m)
		{
				ans = n;
				return;
		}
		ll start = 1;
		ll end = n * maxTime;
		while(start <= end)
		{
				ll mid = (start + end) / 2;
				ll cnt = countCnt(mid);
				if(cnt < n)
				{
						start = mid + 1;
				}
				else
				{
						time = mid;
						end = mid - 1;
				}
		}
		ll children = m;
		for(int i = 0; i < m; i++)
		{
			children += (time - 1) / rides[i];
		}
		for(int i = 0; i < m; i++)
		{
			if(time % rides[i] == 0)
			{
				children++;
			}
			if(children == n)
			{
				ans = i + 1;
				return;
			}
		}
}

int main()
{
		input();
		searchRide();
		cout << ans;
}