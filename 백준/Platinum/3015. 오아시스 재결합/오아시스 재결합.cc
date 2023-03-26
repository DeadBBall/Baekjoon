#include <iostream>
#include <stack>
using namespace std;
typedef pair<int, int> pii;
typedef long long ll;

int n, num;
ll ans;
stack<pii> s;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	cin >> num;
	s.push({num, 1});
	for(int i = 1; i < n; i++)
	{
		cin >> num;
		while(!s.empty() && num > s.top().first)
		{
			s.pop();
			ans++;
		}

		if(s.empty())
		{
			s.push({num , 1});
		}

		else if(num == s.top().first)
		{
			int cnt;
			ans += s.top().second;
			if(s.top().second != s.size())
			{
				ans++;
			}
			cnt = s.top().second + 1;
			s.push({num, cnt});
		}

		else
		{
			ans++;
			s.push({num, 1});
		}
	}
	cout << ans;
}
