#include <iostream>
#include <set>
using namespace std;

int ans[8], n, m;
set<int> s;

void solve(int cnt)
{
	if(cnt == m)
	{
		for(int i = 0; i < cnt; i++)
			cout << ans[i] << " ";
		cout << "\n";
		return;
	}
	for(auto it = s.begin(); it != s.end(); it++)
	{
		if(cnt == 0 || ans[cnt - 1] <= *it)
		{
			ans[cnt] = *it;
			solve(cnt + 1);
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for(int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		s.insert(a);
	}
	solve(0);
}