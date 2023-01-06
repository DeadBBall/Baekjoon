#include <iostream>
using namespace std;

int ans[9], n;
bool visit[9];

void solve(int cnt)
{
	if(cnt > n)
	{
		for(int i = 1; i <= n; i++)
			cout << ans[i] << " ";
		cout << "\n";
		return;
	}

	for(int i = 1; i <= n; i++)
	{
		if(cnt == 1 || !visit[i])
		{
			ans[cnt] = i;
			visit[i] = 1;
			solve(cnt + 1);
			visit[i] = 0;
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	solve(1);
}