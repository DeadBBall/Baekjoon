#include <iostream>
#include <set>
#include <algorithm>
using namespace std;

int n, k, arr[100], plugCnt, ans;
set<int> s;

int main()
{
	cin >> n >> k;
	for (int i = 0; i < k; i++)
	{
		cin >> arr[i];
	}
	for (int i = 0; i < k; i++)
	{
		int now = arr[i];
		if (plugCnt < n)
		{
			if (find(s.begin(), s.end(), arr[i]) != s.end())
			{
				continue;
			}
			plugCnt++;
			s.insert(now);
		}
		else
		{
			if (find(s.begin(), s.end(), arr[i]) != s.end())
			{
				continue;
			}
			ans++;
			set<int> tmps(s);
			for (int j = i + 1; j < k; j++)
			{
				if (tmps.size() == 1)
				{
					break;
				}
				if (find(tmps.begin(), tmps.end(), arr[j]) != tmps.end())
				{
					tmps.erase(find(tmps.begin(), tmps.end(), arr[j]));
				}
			}
			if (tmps.size() != n)
			{
				s.erase(find(s.begin(), s.end(), *tmps.begin()));
				s.insert(now);
			}
			else
			{
				s.erase(s.begin());
				s.insert(now);
			}
		}
	}
	cout << ans;
}