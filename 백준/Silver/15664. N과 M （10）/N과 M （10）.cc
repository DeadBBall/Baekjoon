#include <iostream>
#include <algorithm>
using namespace std;

int n, m, arr[9], ans[9] = {0};
bool visit[9];

void solve(int cnt)
{
	if(cnt > m)
	{
		for(int i = 1; i <= m; i++)
			cout << ans[i] << " ";
		cout << "\n";
		return;
	}
	int check = 0;
	for(int i = 1; i <= n; i++)
	{
		if(!visit[i] && check != arr[i] && ans[cnt - 1] <= arr[i])
		{
			visit[i] = true;
			check = arr[i];
			ans[cnt] = arr[i];
			solve(cnt + 1);
			visit[i] = false;
		}
	}
}

int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for(int i = 1; i <= n; i++)
		cin >> arr[i];
	sort(arr + 1, arr + n + 1);
	solve(1);
}