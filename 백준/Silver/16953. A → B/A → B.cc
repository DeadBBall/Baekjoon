#include <iostream>
#include <queue>
using namespace std;
typedef long long ll;
typedef pair<ll, int> plli;

ll a, b;
int ans = -1;

void solve()
{
	queue<plli> q;
	q.push({a, 1});
	while(!q.empty())
	{
		plli now = q.front();
		q.pop();
		if(now.first == b)
		{
			ans = now.second;
			return;
		}
		if(now.first * 2 <= b)
			q.push({now.first * 2, now.second + 1});
		if(now.first * 10 + 1 <= b)
			q.push({now.first * 10 + 1, now.second + 1});
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> a >> b;
	solve();
	cout << ans;
}