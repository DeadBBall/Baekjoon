#include <iostream>
#include <algorithm>
using namespace std;

int n, m, arr[8], ans[8];
bool visit[8];
void solve(int cnt)
{
	if(cnt == m)
	{
		for(int i = 0; i < m; i++)
			cout << ans[i] << " ";
		cout << "\n";
		return;
	}
	for(int i = 0; i < n; i++)
	{
		if(!visit[i])
		{
			visit[i] = true;
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
	for(int i = 0; i < n; i++)
		cin >> arr[i];
	sort(arr, arr + n);
	solve(0);
}